package a2_2201040036;



/**
 * @overview PCFactory is a program that is used to create PC.
 *           This class must also be a singleton. In layman's term,
 *           this is a simple class uses Customer and has only one instance.
 */
public class PCFactory{
    private static PCFactory factory = new PCFactory();

    // Make the default constructor private to restrict creating instance outside
    private PCFactory(){};
    public static PCFactory getFactory(){
        return factory;
    }
    // Method for creating PC
    public PC createPC(String model, Integer year, String manufacture, Set<String> comps) {
        return new PC(model, year, manufacture, comps);
    }
}


