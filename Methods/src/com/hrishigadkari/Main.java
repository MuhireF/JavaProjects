package com.hrishigadkari;

public class Main {
    public static void displayHighScorePosition(String playerName, int positionTable){
        System.out.println(playerName + " managed to get into " + positionTable + " on the high score table.");
    }
    public static int calculateHighScorePosition(int playerScore){
        if(playerScore > 1000){
            return 1;
        }else if((playerScore > 500) && (playerScore < 1000)){
            return 2;
        }else if((playerScore > 100) && (playerScore < 500)) {
            return 3;
        }
         else {
             return 4;
         }

    }
    public static void main(String[] args) {
	    displayHighScorePosition("John Doe", 1);
	    int playerPosition =  calculateHighScorePosition(100);
        System.out.println("Player Position: " + playerPosition);
    }
}
