package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {

    public static void main(String[] args) {
        HumanPlayer hPlayer = new HumanPlayer();
        Simulation simulation = new Simulation(hPlayer);
        simulation.initialize(new SecureRandom().nextLong());
    }
}
