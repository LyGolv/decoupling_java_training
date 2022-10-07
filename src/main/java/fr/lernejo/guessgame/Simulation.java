package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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
        if (guess == this.numberToGuess) return true;
        // true: lower to found, false: Greater to found
        else player.respond(this.numberToGuess < guess);
        return false;
    }

    public void loopUntilPlayerSucceed(long maxIteration) {

        long oldTime = System.currentTimeMillis() * 1000000;
        while (!this.nextRound()) --maxIteration;
        System.out.println("\nTime: " + LocalTime.ofNanoOfDay(System.currentTimeMillis() * 1000000 - oldTime)
            .format(DateTimeFormatter.ofPattern("mm:ss.SSS")));
        String text = maxIteration > 0 ? "Nombre atteint avant la limite d'itération"
            : "Nombre atteint après la limite";
        System.out.println("->" + text);
    }
}
