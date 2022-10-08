package fr.lernejo.logger;

public class LoggerFactory {

    public static Logger getLogger(String name) {
        return new CompositeLogger(
            new FilteredLogger(
                new ContextualLogger(
                    name,
                    new FileLogger("./training.log")
                ),
                (message) -> name.equals("simulation")
            ),
            new ContextualLogger(name, new ConsoleLogger())
        );
    }
}
