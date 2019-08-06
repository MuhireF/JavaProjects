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
    //function Initializing elevator objects and adding to the list
    private void initialize(Building building) {
        if (!flag) {
            for (int i = 0; i < building.getNumberOfElevators(); i++) {
                elevators.add(building.getElevator(i));
            }


            flag = true;
        }
    }

    @Override
    public void cycleElapsed(Building building) {

        initialize(building);

        //     List<Integer> upLobbyButtonFloorNumbers = getUpLobbyButtonFloorNumbers(building);
        //   List<Integer>  downLobbyButtonFloorNumbers = getDownLobbyButtonFloorNumbers(building);
        //  List<Integer> pressedNumbersInsideElevator = getPressedNumbersInsideElevator(elevator);



        for(Elevator elevator: elevators){

            if(getUpElevatorStatus(elevator)) {
                for (int upLobbyButtonFloorNumbers : getUpLobbyButtonFloorNumbers(building)) {

                    if (upLobbyButtonFloorNumbers < elevator.getNextStop() && upLobbyButtonFloorNumbers > elevator.getCurrentFloor()) {
                        System.out.println(upLobbyButtonFloorNumbers);
                        setNewElevatorInstructUp(elevator, upLobbyButtonFloorNumbers);
                    } else if(upLobbyButtonFloorNumbers > elevator.getNextStop() && elevator.getNextStop() == elevator.getCurrentFloor()){
                        System.out.println(+ upLobbyButtonFloorNumbers);
                        setNewElevatorInstructUp(elevator, upLobbyButtonFloorNumbers);

                    }
                    // could be a problem
//                   else if (upLobbyButtonFloorNumbers == elevator.getNextStop() && elevator.getNextStop() == elevator.getCurrentFloor()){
//                       setNewElevatorInstruct(elevator, upLobbyButtonFloorNumbers);
//                      //  elevator.setNewInstruction(upLobbyButtonFloorNumbers, Elevator.DirectionEnum.UP);
//                    }
                }
            }else if(getDownElevatorStatus(elevator)){
                for (int downLobbyButtonFloorNumbers : getDownLobbyButtonFloorNumbers(building)) {

                    if (downLobbyButtonFloorNumbers > elevator.getNextStop() && downLobbyButtonFloorNumbers < elevator.getCurrentFloor()) {
                        setNewElevatorInstructDown(elevator, downLobbyButtonFloorNumbers);
                    } else if(downLobbyButtonFloorNumbers < elevator.getNextStop() && elevator.getNextStop() == elevator.getCurrentFloor()){

                        setNewElevatorInstructDown(elevator, downLobbyButtonFloorNumbers);

                    }
                    // could be a problem
//                   else if (upLobbyButtonFloorNumbers == elevator.getNextStop() && elevator.getNextStop() == elevator.getCurrentFloor()){
//                       setNewElevatorInstruct(elevator, upLobbyButtonFloorNumbers);
//                      //  elevator.setNewInstruction(upLobbyButtonFloorNumbers, Elevator.DirectionEnum.UP);
//                    }
                }
            }



            if(setNextStopForInsideElevator(elevator)){
                System.out.println("Success In setting Inside nextStop For Elevator");
            }

            if((getPressedNumbersInsideElevator(elevator).isEmpty()) && (elevator.getNextStop() == elevator.getCurrentFloor()) && (elevator.getCurrentFloor() > (int) building.getNumberOfElevators()/2)){
                elevator.setNewInstruction(elevator.getNextStop(), Elevator.DirectionEnum.DOWN);
            }else if((getPressedNumbersInsideElevator(elevator).isEmpty()) && (elevator.getNextStop() == elevator.getCurrentFloor()) && (elevator.getCurrentFloor() < (int) building.getNumberOfElevators()/2)){
                elevator.setNewInstruction(elevator.getNextStop(), Elevator.DirectionEnum.UP);
            }


        }


    }



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

    private boolean getUpElevatorStatus(Elevator elevator){
        if(elevator.getButtonToAnswerAtNextStop().toString().equals("UP")){
            return true;
        }
        return false;
    }

    private boolean getDownElevatorStatus(Elevator elevator){
        if(elevator.getButtonToAnswerAtNextStop().toString().equals("DOWN")){
            return true;
        }
        return false;
    }

    private boolean setNextStopForInsideElevator(Elevator elevator){
        List<Integer> pressedNumbersInsideElevator = getPressedNumbersInsideElevator(elevator);
        if(!pressedNumbersInsideElevator.isEmpty()) {
            for (int number : pressedNumbersInsideElevator) {
                if (getUpElevatorStatus(elevator)) {
                    if (number > elevator.getCurrentFloor() && elevator.getCurrentFloor() == elevator.getNextStop()){
                        elevator.setNewInstruction(number, Elevator.DirectionEnum.UP);
                        return true;
                    }else if(number == elevator.getCurrentFloor()){
                        System.out.println("Button Inside Elevator Presses Same as Floor");
                        elevator.setNewInstruction(number, Elevator.DirectionEnum.UP);
                        return true;
                    }
                }
                if (getDownElevatorStatus(elevator)) {
                    if (number < elevator.getCurrentFloor() && elevator.getCurrentFloor() == elevator.getNextStop()){
                        elevator.setNewInstruction(number, Elevator.DirectionEnum.DOWN);
                        return true;
                    }else if(number == elevator.getCurrentFloor()){
                        System.out.println("Button Inside Elevator Presses Same as Floor");
                        elevator.setNewInstruction(number, Elevator.DirectionEnum.DOWN);
                        return true;
                    }
                }
            }
        }
        return false;
    }

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