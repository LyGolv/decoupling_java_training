package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player{

    private final Logger logger = LoggerFactory.getLogger("computer");
    private long inf = 0;
    private long sup = Long.MAX_VALUE;

    @Override
    public long askNextGuess() {
        long oldNumber = (sup + inf) / 2;
        this.logger.log("askNextGuess(): le nombre donné est " + oldNumber);
        return oldNumber;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        System.out.println(lowerOrGreater ? "Plus Grand" : "Plus Petit");
        long oldNumber = (sup + inf) / 2;
        if (lowerOrGreater) sup = Math.min(sup, oldNumber);
        else inf = Math.max(inf, oldNumber);
        String logMsg = lowerOrGreater ? "respond(): Nombre donné plus grand"
            : "respond(): Nombre donné plus petit";
        this.logger.log(logMsg);
    }
}
