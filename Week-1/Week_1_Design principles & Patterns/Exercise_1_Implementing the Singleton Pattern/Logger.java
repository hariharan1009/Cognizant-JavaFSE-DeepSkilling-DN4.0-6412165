public class Logger {
    private static Logger instance = null;
    private Logger() {
        // Initialization code can go here
        System.out.println("Logger initialized.");
    }
    
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}