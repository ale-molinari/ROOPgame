package core.CharactersSetup;

import core.worldSetup.Room;

import java.util.Random;

public class Enemy extends Character implements Challenge {

    public Enemy(double life, String name, double attack) {
        super(life, name, attack);
    }
}

