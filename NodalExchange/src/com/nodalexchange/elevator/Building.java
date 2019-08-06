package com.nodalexchange.elevator;

public interface Building {
	public int getNumberOfFloors();
	public int getNumberOfElevators();
	public ElevatorWaitingAreaInfo getElevatorWaitingAreaInfo(int floor);
	public Elevator getElevator(int elevatorNumber);
}