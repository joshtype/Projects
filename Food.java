/**
 * Hierarchy: Food <-- Salad / Sandwich / FrozenYogurt
 * <p>
 * @author  Joshua Gregory
 * @version 1.0 (Apr. 2023)
 * </p>
 */
import java.util.*;
import java.lang.*;
public class Food {   
    // Instance Fields:
    protected static String name;
    protected static double price;
    protected static StringBuilder topping;
    protected static final String dashline = "-------------------------------------";
    // Parameterized constructor:
    /**
     * Parameterized constructor for Food objects.
     * <p>
     * @param   name, price (USD), topping (appended to StringBuilder topping)
     * </p>
     */
    public Food(String n, double p, String t) {
        this.name = n;
        this.price = p;
        this.topping = new StringBuilder(100);  // define SB with 100 char cap
        topping.append(t);  // append argument to SB
    }
    /**
     * No-Argument Constructor for Food Objects.
     */
    public Food() {
        // invoke mutators to define name, price, and topping
    }
    /**
     * Displays menu organized in tabular form.
     * <p>
     * @return  new line
     * </p>
     */
    public static String menuForm() {
        System.out.println("\n");
        System.out.println("+---------+");
        System.out.println("| ACTIONS |");
        System.out.println("+---------+----------------+");
        System.out.println("| 1) Order a salad         |"); 
        System.out.println("|--------------------------|");
        System.out.println("| 2) Order a sandwich      |");
        System.out.println("|--------------------------|"); 
        System.out.println("| 3) Order a frozen yogurt |");
        System.out.println("|--------------------------|"); 
        System.out.println("| 4) Display an item       |");
        System.out.println("|--------------------------|");
        System.out.println("| 5) Display all items     |"); 
        System.out.println("|--------------------------|");    
        System.out.println("| 6) Add a Topping         |");
        System.out.println("|--------------------------|");
        System.out.println("| 9) Exit OOPs             |");
        System.out.println("+--------------------------+");
        return "\n";
    }
    // Class Method:
    /**
     * Display obj attributes; round price; convert price & topping to Strings.
     * <p>
     * @return  new line to assist with output organization
     * </p>
     */
    @Override  // overrides java.lang.Object's toString()
    public String toString() {
        String align = "%-15s%s%n";  // %-15 = text aligned 15 spaces to left  %s = lowercase, %n = new line
        String pad = "  ";           // further align text
        
        System.out.println("-------------------------------------");
        System.out.printf(align, "Food Item", ":" + pad + name);
        System.out.printf(align, "Price", ":" + pad + String.format("%.2f", price));
        System.out.printf(align, "Topping(s)", ":" + pad + topping.toString());
        return "-------------------------------------";
    }
    /**
     * Appends argument to SB, sepates multiple values by comma and space, ensures sufficient capacity.
     * <p>
     * @param   String to append to SB
     * </p>
     */
    public void addTopping(String t1) {
        if(topping.length() < 1)  // if SB is empty
        {
            topping.append(t1).ensureCapacity(t1.length());  // add topping to SB and increase capacity as needed
        }
        else if(topping.length() >= 1)  // if SB isn't empty, prefix appended value with comma and space
        {
            topping.append(", " + t1).ensureCapacity(t1.length());  // add topping to SB and increase capacity as needed
        }
    }
    
    /**
     * Method to calculate sum of wrapped doubles in ArrayList.
     * <p>
     * @param   ArrayList storing the price attributes for ordered items
     * @return  the sum of all doubles in the ArrayList argument
     * </p>
     */
    
    public static <T extends Number> double total(ArrayList<T> p) {
        double total = 0;
        for (int i = 0; i < p.size(); i++)
        {
            total += p.get(i).doubleValue();
        }
        
        return Math.round(total);
    }
    // Mutator and Accessor Methods:
    /**
     * Mutator to DELETE and REPLACE ALL values in StringBuilder topping!
     * Use this ONLy to delete currrent topping and replace with parameter!
     * <p>
     * @param   String to replace entire StringBuilder topping
     * </p>
     */
    public void setTopping(String t2){
        topping.replace(0, topping.length(), t2);
    }
    public void setName(String newName) {
        this.name = newName;
    }
    public void setPrice(double newPrice) {
        this.price = newPrice;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public StringBuilder getTopping() {
        return topping;
    }
}

