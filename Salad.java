/**
 * Inheritance Hierarchy: Food <-- Salad
 * Inherits name, price, topping, setName(), setPrice(), getName(), getPrice(), getTopping()
 * Overrides toString(), addTopping(), setTopping()
 * <p>
 * @author  Joshua Gregory
 * @version 1.0 (Apr. 2023)
 * </p>
 */
import java.util.ArrayList;
public class Salad extends Food {
    // Subclass Instance Fields (inherits name and price):
    private String side;
    private String dressing;
    private StringBuilder salTop;
    // Constructors:
    /**
     * No-Argument constructor for Sandwich objects
     */
    public Salad() {
        // define attributes by invoking mutators and accessors
    }  
    /**
     * Parameterized constructor for Sandwich objects
     * Value of salTop defined by invoking addTopping() or setTopping()
     * <p>
     * @param   name, price (USD), side dish, dressing
     * </p>
     */
    public Salad(String n, double p, String s, String d) {
        this.name = n;
        this.price = p;
        this.side = s;
        this.dressing = d; 
        this.salTop = new StringBuilder(100);
        // 100 char capacity, invoke addTopping() to define
    } 
    // Class Methods:
    /**
     * Aligns and displays each attribute with double and SB represented as Strings and double rounded two places.
     * <p>
     * @return   new line
     * </p>
     */
    @Override
    public String toString() {
        String align = "%-15s%s%n";  // %-15 = text aligned 15 spaces to left  %s = lowercase, %n = new line
        salTop.trimToSize();         // trim any unused space from SB
        
        System.out.println(dashline);
        System.out.printf(align, "Salad", ":" + "\t\t" + name);
        System.out.printf(align, "Price", ":" + "\t\t" + String.format("%.2f", price));
        System.out.printf(align, "Side Dish", ":" + "\t\t" + side);
        System.out.printf(align, "Dressing", ":" + "\t\t" + dressing);
        
        if(salTop.length() > 0)  // if user added topping(s), then display the topping(s) with 
        {
            salTop.trimToSize();  // trims unused capacity
            System.out.printf(align, "Topping(s)", ":" + "\t\t" + salTop.toString());  // represents SB values as a String
        }
        return dashline;
    }
    /**
     * Appends argument to SB, separates multiple values with comma and space, ensures SB has sufficient capacity.
     * <p>
     * @param   String to append to SB
     * </p>
     */
    @Override
    public void addTopping(String t1) {
        if(salTop.length() < 1)  // if SB is empty
        {
            salTop.append(t1).ensureCapacity(t1.length());  // add topping to SB and increase capacity as needed
        }
        else if(salTop.length() >= 1)  // if SB isn't empty, prefix appended value with comma and space
        {
            salTop.append(", " + t1).ensureCapacity(t1.length());  // add topping to SB and increase capacity as needed
        }
    }
    // Mutator and Accessor Methods:
    /**
     * Sets value of SB. WARNING: if SB contains value when invoking, all existing values will be deleted and replaced!
     * <p>
     * @param   String to replace entire SB
     * </p>
     */
    @Override
    public void setTopping(String t2) {
        salTop.replace(0, salTop.length(), t2);
    }
    public void setSide(String s2) {
        this.side = s2;
    }
    public void setDressing(String d2) {
        this.dressing = d2;
    }
    public String getSide() {
        return side;
    }
    public String getDressing() {
        return dressing;
    }
    public StringBuilder getTopping() {
        return salTop;
    }
    // Inherits setName(), setPrice(), getName(), getPrice(), getTopping()
}
