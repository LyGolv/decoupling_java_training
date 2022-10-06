package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {
    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        this.logger.log("nextRound(): playing...");
        long guess = player.askNextGuess();
        boolean test = guess == this.numberToGuess;
        player.respond(guess > this.numberToGuess);
        return test;
    }

    public void loopUntilPlayerSucceed() {
        while (!this.nextRound());
    }
}