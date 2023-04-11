/**
 * Inheritance Hierarchy: Food <-- Sandwich
 * Inherits name, price, topping, setName(), setPrice(), getName(), getPrice(), getTopping()
 * Overrides toString(), addTopping(), setTopping()
 * <p>
 * @author  Joshua Gregory
 * @version 1.0 (Apr. 2023)
 * </p>
 */
public class Sandwich extends Food {
    // Subclass Instance Fields (inherits name and price):
    private String side;
    private String bread;
    private StringBuilder sandTop;
    // Constructors:
    /**
     * Parameterized constructor for Sandwich objects. SB not defined until addTopping() is invoked.
     * <p>
     * @param   item name, item price in USD, side dish, type of bread
     * </p>
     */
    public Sandwich(String n, double p, String s, String b) {
        this.name = n;
        this.price = p;
        this.side = s;
        this.bread = b;
        this.sandTop = new StringBuilder(100);  
        // 100 char capacity, defined by invoking addTopping()
    }
    /**
     * No-Argument constructor for Sandwich objects.
     */
    public Sandwich() {
        // invoke mutator methods to define name, price, side, bread
    }
    // Class Method:
    /**
     * Aligns and displays each attribute with double and SB represented as Strings and double rounded two places.
     * <p>
     * @return   new line
     * </p>
     */
    @Override
    public String toString() {
        String align = "%-15s%s%n";  // %-15 = text aligned 15 spaces to left  %s = lowercase, %n = new line
        sandTop.trimToSize();         // trim any unused space from SB
        
        System.out.println(dashline);
        System.out.printf(align, "Sandwich", ":" + "\t\t" + name);
        System.out.printf(align, "Price", ":" + "\t\t" + String.format("%.2f", price));
        System.out.printf(align, "Side Dish", ":" + "\t\t" + side);
        System.out.printf(align, "Bread", ":" + "\t\t" + bread);
        
        if(sandTop.length() > 0)  // if user added topping(s), then display the topping(s) with 
        {
            sandTop.trimToSize();  // trims unused capacity
            System.out.printf(align, "Topping(s)", ":" + "\t\t" + sandTop.toString());  // represents SB values as a String
        }
        return dashline;
    }
    // Class Method:
    /**
     * Appends argument to SB, separats multiple values with comma and space, ensures sufficient capacity.
     * <p>
     * @param   String to append to SB
     * </p>
     */
    @Override
    public void addTopping(String t1) {
        if(sandTop.length() < 1)  // if SB is empty
        {
            sandTop.append(t1).ensureCapacity(t1.length());  // add topping to SB and increase capacity as needed
        }
        else if(sandTop.length() >= 1)  // if SB isn't empty, prefix appended value with comma and space
        {
            sandTop.append(", " + t1).ensureCapacity(t1.length());  // add topping to SB and increase capacity as needed
        }
    }
    // Mutators and Accessors:
    /**
     * Sets value of SB. WARNING: if SB contains value when invoking, all existing values will be deleted and replaced!
     * <p>
     * @param   String to replace current SB
     * </p>
     */
    @Override
    public void setTopping(String t2) {
        this.sandTop.replace(0, sandTop.length(), t2);
    }
    public void setSide(String s2) {
        this.side = s2;
    }
    public void setBread(String b2) {
        this.bread = b2;
    }
    public String getSide() {
        return side;
    }
    public String getBread() {
        return bread;
    }
    public StringBuilder getTopping() {
        return sandTop;
    }
    // inherits setName(), setPrice(), getName(), getPrice(), getTopping()
}
