/*
My approach to solve the problem was pretty straightforward. I went through the 4 interfaces to have a look of the functions defined. This gave me a summary of the state and behaviour of
other classes in the operation package and avoided the effort and time to go through the classes. I did some mock testing to see it getting executed. Then I tried to get more familiar with the problem
and help me get some idea about how to make it work by solving it on white paper. With this got a brief idea of the algorithm and some functioning of the problem. While implementing
several other constraints were popping out but eventually tackled them.
 */
package com.nodalexchange.elevator.controllers;

import com.nodalexchange.elevator.Building;
import com.nodalexchange.elevator.Elevator;
import com.nodalexchange.elevator.ElevatorController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElevatorControllerSoftware implements ElevatorController {
    private boolean flag = false;
    private List<Elevator> elevators = new ArrayList<>();


    //function add elevator objects to the list
    private void initialize(Building building) {
        if (!flag) {
            if(building.getNumberOfElevators() == 0 || building.getNumberOfFloors() == 0 || building.getElevator(0).getCapacity() == 0){
                throw new IllegalArgumentException("Invalid Arguments");
            }
            for (int i = 0; i < building.getNumberOfElevators(); i++) {
                elevators.add(building.getElevator(i));
            }


            flag = true;
        }
    }

    @Override
    public void cycleElapsed(Building building) {


        //function call to initialize list of elevator objects
        initialize(building);

        //loop through elevator list containing elevator objects
        for(Elevator elevator: elevators){

            //condition if elevator Direction is set to UP
            if(getUpElevatorStatus(elevator)) {
                //loop through the lobby buttons pressed to go UP
                for (int upLobbyButtonFloorNumbers : getUpLobbyButtonFloorNumbers(building)) {
                    if (upLobbyButtonFloorNumbers < elevator.getNextStop() && upLobbyButtonFloorNumbers > elevator.getCurrentFloor()) {
                        setNewElevatorInstructUp(elevator, upLobbyButtonFloorNumbers);
                    } else if(upLobbyButtonFloorNumbers > elevator.getNextStop() && elevator.getNextStop() == elevator.getCurrentFloor()){
                        setNewElevatorInstructUp(elevator, upLobbyButtonFloorNumbers);
                    }
                }
            }
            //condition if elevator Direction is set to go DOWN
            else if(getDownElevatorStatus(elevator)){
                //loop through the lobby buttons pressed to go DOWN
                for (int downLobbyButtonFloorNumbers : getDownLobbyButtonFloorNumbers(building)) {
                    if (downLobbyButtonFloorNumbers > elevator.getNextStop() && downLobbyButtonFloorNumbers < elevator.getCurrentFloor()) {
                        setNewElevatorInstructDown(elevator, downLobbyButtonFloorNumbers);
                    } else if(downLobbyButtonFloorNumbers < elevator.getNextStop() && elevator.getNextStop() == elevator.getCurrentFloor()){
                        setNewElevatorInstructDown(elevator, downLobbyButtonFloorNumbers);
                    }
                }
            }
             //function call to setNextStop based on the button pressed inside the elevator
            setNextStopForInsideElevator(elevator);
            //condition to toggle Direction of the elevator to DOWN
            if((getPressedNumbersInsideElevator(elevator).isEmpty()) && (elevator.getNextStop() == elevator.getCurrentFloor()) && (elevator.getCurrentFloor() >  (building.getNumberOfFloors()/2))){
                elevator.setNewInstruction(elevator.getNextStop(), Elevator.DirectionEnum.DOWN);
            }
            //condition to toggle Direction of the elevator to UP
            else if((getPressedNumbersInsideElevator(elevator).isEmpty()) && (elevator.getNextStop() == elevator.getCurrentFloor()) && (elevator.getCurrentFloor() < (building.getNumberOfFloors()/2)) ){
                elevator.setNewInstruction(elevator.getNextStop(), Elevator.DirectionEnum.UP);
            }
        }
    }


    //function to set the newElevatorInstruction going in Downward direction
    private void setNewElevatorInstructDown(Elevator elevator, int downLobbyButtonFloorNumbers) {
        if (!getListOfStopsDown().containsValue(downLobbyButtonFloorNumbers)) {
            elevator.setNewInstruction(downLobbyButtonFloorNumbers, Elevator.DirectionEnum.DOWN);

        } else if (getListOfStopsDown().containsValue(downLobbyButtonFloorNumbers)){
            if(getKeyElevator(downLobbyButtonFloorNumbers, getListOfStopsDown()) != null){
                if(getKeyElevator(downLobbyButtonFloorNumbers, getListOfStopsDown()).getNextStop() == getKeyElevator(downLobbyButtonFloorNumbers, getListOfStopsDown()).getCurrentFloor()) {
                    elevator.setNewInstruction(downLobbyButtonFloorNumbers, Elevator.DirectionEnum.DOWN);
                }
            }
        }
    }

    //function to set the newElevatorInstruction going in Upward direction
    private void setNewElevatorInstructUp(Elevator elevator, int upLobbyButtonFloorNumbers) {
        if (!getListOfStopsUp().containsValue(upLobbyButtonFloorNumbers)) {
            elevator.setNewInstruction(upLobbyButtonFloorNumbers, Elevator.DirectionEnum.UP);

        } else if (getListOfStopsUp().containsValue(upLobbyButtonFloorNumbers)){
            if(getKeyElevator(upLobbyButtonFloorNumbers, getListOfStopsUp()) != null){
                if(getKeyElevator(upLobbyButtonFloorNumbers, getListOfStopsUp()).getNextStop() == getKeyElevator(upLobbyButtonFloorNumbers, getListOfStopsUp()).getCurrentFloor()) {
                    elevator.setNewInstruction(upLobbyButtonFloorNumbers, Elevator.DirectionEnum.UP);
                }
            }
        }
    }

    //function to get the elevator object whose nextStop value matches with other object
    private Elevator getKeyElevator(int value, Map<Elevator,Integer> multimap){
        for(Map.Entry<Elevator, Integer> entry : multimap.entrySet()) {
            Elevator key = entry.getKey();
            Integer value1 = entry.getValue();

            if(value1 == value){
                return key;
            }
        }
        return null;
    }

    //function to store elevator objects and their nextStop values in a Map going UP
    private Map<Elevator,Integer>  getListOfStopsUp(){
        Map<Elevator,Integer> multiMap = new HashMap<>();
        for (Elevator elevatorList: elevators)
        {
            if(getUpElevatorStatus(elevatorList)) {
                multiMap.put(elevatorList, elevatorList.getNextStop());
            }
        }
        return multiMap;
    }

    //function to store elevator objects and their nextStop values in a Map going DOWN
    private Map<Elevator,Integer>  getListOfStopsDown(){
        Map<Elevator,Integer> multiMap = new HashMap<>();
        for (Elevator elevatorList: elevators)
        {
            if(getDownElevatorStatus(elevatorList)) {
                multiMap.put(elevatorList, elevatorList.getNextStop());
            }
        }
        return multiMap;
    }

    //function to get Elevator Direction Status
    private boolean getUpElevatorStatus(Elevator elevator){
        if(elevator.getButtonToAnswerAtNextStop().toString().equals("UP")){
            return true;
        }
        return false;
    }

    //function to get Elevator Direction Status
    private boolean getDownElevatorStatus(Elevator elevator){
        if(elevator.getButtonToAnswerAtNextStop().toString().equals("DOWN")){
            return true;
        }
        return false;
    }

    //function to set the nextStopValue when button is pressed from inside the Elevator
    private boolean setNextStopForInsideElevator(Elevator elevator){
        List<Integer> pressedNumbersInsideElevator = getPressedNumbersInsideElevator(elevator);
       if(!pressedNumbersInsideElevator.isEmpty()) {
           for (int number : pressedNumbersInsideElevator) {
              //Up Direction
               if (getUpElevatorStatus(elevator)) {
                   if (number > elevator.getCurrentFloor() && elevator.getCurrentFloor() == elevator.getNextStop()){
                       elevator.setNewInstruction(number, Elevator.DirectionEnum.UP);
                       return true;
                   }else if(number == elevator.getCurrentFloor()){
                       elevator.setNewInstruction(number, Elevator.DirectionEnum.UP);
                       return true;
                   }
               }
               //Down Direction
               if (getDownElevatorStatus(elevator)) {
                   if (number < elevator.getCurrentFloor() && elevator.getCurrentFloor() == elevator.getNextStop()){
                       elevator.setNewInstruction(number, Elevator.DirectionEnum.DOWN);
                       return true;
                   }else if(number == elevator.getCurrentFloor()){
                       elevator.setNewInstruction(number, Elevator.DirectionEnum.DOWN);
                       return true;
                   }
               }
           }
       }
       return false;
    }
     // function to get the list of buttons pressed inside the elevator
    private List<Integer> getPressedNumbersInsideElevator(Elevator elevator){
        List<Integer> pressedNumbersInsideElevator = new ArrayList<>();
        boolean[] arrayNumbers = elevator.getButtonStates();
        for(int i = 0; i < arrayNumbers.length; i++){
            if(arrayNumbers[i]){
                pressedNumbersInsideElevator.add(i);
            }
        }
        return pressedNumbersInsideElevator;
    }

    // function to get List of DownPressed Lobby Numbers
    private List<Integer> getDownLobbyButtonFloorNumbers(Building building){
        List<Integer> downLobbyButtonFloorNumbers = new ArrayList<>();
        for (int i = 0; i < building.getNumberOfFloors(); i++) {
            if (building.getElevatorWaitingAreaInfo(i).isDownButtonPushed()) {
                if (!downLobbyButtonFloorNumbers.contains(i)) {
                    downLobbyButtonFloorNumbers.add(0, i);

                }
            }
        }
        return downLobbyButtonFloorNumbers;

    }
    // function to get List of UpPressed Lobby Numbers
    private List<Integer> getUpLobbyButtonFloorNumbers(Building building){
        List<Integer> upLobbyButtonFloorNumbers = new ArrayList<>();
        for (int i = 0; i < building.getNumberOfFloors(); i++) {
            if (building.getElevatorWaitingAreaInfo(i).isUpButtonPushed()) {
                if (!upLobbyButtonFloorNumbers.contains(i)) {
                    upLobbyButtonFloorNumbers.add(0, i);

                }
            }
        }
        return upLobbyButtonFloorNumbers;
    }
}

/*

Future Implementation:
I Will definitely try to reduce the number of if conditions as well as loop within a loop to reduce the complexity of the problem if possible.
Also try to divide the code in multiple classes and also go with a multi-threading approach if problem permits to.
Reduce the number of cycles to the lowest.
 */