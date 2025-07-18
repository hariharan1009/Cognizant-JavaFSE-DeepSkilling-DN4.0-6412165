public class SingletonTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        
        System.out.println("Are logger1 and logger2 the same instance? " +(logger1 == logger2));
        
        logger1.log("First message from logger1");
        logger2.log("Second message from logger2");
        
        System.out.println("Logger1 hash code: " + logger1.hashCode());
        System.out.println("Logger2 hash code: " + logger2.hashCode());
        if(logger1.hashCode() == logger2.hashCode()) {
            System.out.println("Both logger1 and logger2 have the same hash code, confirming they are the same instance.");
        } else {
            System.out.println("logger1 and logger2 have different hash codes, which should not happen in a singleton pattern.");
        }
    }
}