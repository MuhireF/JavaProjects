package com.hrishigadkari;

import java.util.ArrayList;

public class Game{
    private Players player;
    private Monsters monster;


    public Game(Players player, Monsters monster) {
        this.player = player;
        this.monster = monster;
    }



    public Players getPlayer() {
        return player;
    }

    public Monsters getMonster() {
        return monster;
    }
}
