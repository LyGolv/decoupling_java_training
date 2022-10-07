package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {

    public static void main(String[] args) {

        if (args.length == 1 && args[0].equals("-interactive")) {
            HumanPlayer hPlayer = new HumanPlayer();
            Simulation simulation = new Simulation(hPlayer);
            simulation.initialize(new SecureRandom().nextLong());
            simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);
        } else if (args.length == 2 && args[0].equals("-auto")) {
            ComputerPlayer cPlayer = new ComputerPlayer();
            Simulation simulation = new Simulation(cPlayer);
            simulation.initialize(Long.parseLong(args[1]));
            simulation.loopUntilPlayerSucceed(1000);
        } else {
            System.out.println("""
                ============ HELP =============
                Commande :
                    -> java NOM_DU_PROGRAMME -OPTION [, nombre]
                    
                    * NOM_DU_PROGRAMME: nom de votre programme
                    * -OPTION :
                        > -interactive
                        > -auto
                    * nombre: Utilisé obligatoirement avec '-auto'
                
                ##
                """);
        }

    }
}
