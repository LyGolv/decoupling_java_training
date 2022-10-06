package fr.lernejo.guessgame;

import java.util.Scanner;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class HumanPlayer implements Player{

    private final Logger logger = LoggerFactory.getLogger("player");
    private final Scanner scan = new Scanner(System.in);

    @Override
    public long askNextGuess() {
        System.out.println("Veuillez saisir un nombre");
        long n = scan.nextLong();
        this.logger.log("askNextGuess(): nombre saisi par l'utilisateur " + n);
        return n;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        System.out.println(lowerOrGreater ? "Plus Grand" : "Plus Petit");
        String logMsg = lowerOrGreater ? "respond(): Nombre donné plus grand"
            : "respond(): Nombre donné plus petit";
        this.logger.log(logMsg);
    }
}
