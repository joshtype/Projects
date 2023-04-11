/**
 * Inheritance Hierarchy: Food <-- FrozenYogurt
 * Inherits name, price, topping, setName(), setPrice(), getName(), getPrice(), getTopping()
 * Overrides toString(), addTopping(), setTopping()
 * <p>
 * @author  Joshua Gregory
 * @version 1.0 (Apr. 2023)
 * </p>
 */
public class FrozenYogurt extends Food
{
    // Subclass Instance Fields (inherits name and price):
    private String base;
    private StringBuilder froTop;    
    // Constructors:
    public FrozenYogurt(){}  // No-Argument: define attributes by invoking mutators and accessors
    /**
     * Parameterized constructor for objects of subclass FrozenYogurt.
     * <p>
     * @param   name, price (USD), base yogurt flavor, topping
     * </p>
     */
    public FrozenYogurt(String n, double p, String b, String t)
    {
        this.name = n;
        this.price = p;
        this.base = b;
        this.froTop = new StringBuilder(100);  // 100 chars capacity
        froTop.append(t);                 // append to SB
    }
    // Class Method:
    /**
     * Aligns and displays each attribute with double and SB represented as Strings and double rounded two places.
     * <p>
     * @return   new line
     * </p>
     */
    @Override
    public String toString()
    {
        String align = "%-15s%s%n";  // %-15 = text aligned 15 spaces to left  %s = lowercase, %n = new line
        froTop.trimToSize();         // trim any unused space from SB
        
        System.out.println(dashline);
        System.out.printf(align, "Frozen Yogurt", ":" + "\t\t" + name);
        System.out.printf(align, "Price", ":" + "\t\t" + String.format("%.2f", price));
        System.out.printf(align, "Base Yogurt", ":" + "\t\t" + base);
        System.out.printf(align, "Topping(s)", ":" + "\t\t" + froTop);
        return dashline;
    }
    // Class Method:
    /**
     * Appends argument to SB, separates multiple values with comman and space, ensures SB has enough capacity.
     * <p>
     * @param   String to append to SB
     * </p>
     */
    @Override
    public void addTopping(String t1)
    {
        if(froTop.length() < 1)  // if SB is empty
        {
            froTop.append(t1).ensureCapacity(t1.length());  // add topping to SB and increase capacity as needed
        }
        else if(froTop.length() >= 1)  // if SB isn't empty, prefix appended value with comma and space
        {
            froTop.append(", " + t1).ensureCapacity(t1.length());  // add topping to SB and increase capacity as needed
        }
    }
    // Mutator and Accessor Methods:
    /**
     * Sets value of SB. WARNING: if SB contains value when invoking, all existing values will be deleted and replaced!
     * <p>
     * @param   String to replace entire SB salTop
     * </p>
     */
    @Override
    public void setTopping(String t2)
    {
        this.froTop.replace(0, froTop.length(), t2);
    }
    public void setBase(String b1)
    {
        this.base = b1;
    }
    // Accessor Methods - inherits getName() and getTopping()
    public String getBase()
    {
        return base;
    }
    public StringBuilder getTopping()
    {
        return froTop;
    }
    // inherits setName(), setPrice(), getName(), getPrice(), getTopping()
}
