package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player{

    private final Logger logger = LoggerFactory.getLogger("computer");
    private long oldNumber;
    private boolean indice;

    public void initNumber(long oldNumber) {
        this.oldNumber = oldNumber;
    }
    @Override
    public long askNextGuess() {
        oldNumber = indice ? oldNumber / 2 : (long)3 * oldNumber/2;
        this.logger.log("askNextGuess(): le nombre donné est " + oldNumber);
        return oldNumber;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        System.out.println(lowerOrGreater ? "Plus Grand" : "Plus Petit");
        this.indice = lowerOrGreater;
        String logMsg = lowerOrGreater ? "respond(): Nombre donné plus grand"
            : "respond(): Nombre donné plus petit";
        this.logger.log(logMsg);
    }
}
