/**
 * Driver code for Superclass Food and subclasses.
 * <p>
 * @author  Joshua Gregory
 * @version 1.0 (Apr. 2023)
 * </p>
 */
import java.util.Scanner;    // scan user import
import java.util.ArrayList;  // storing objs in mutable size list
import java.util.Map;        // store unsorted objs by key
import java.util.HashMap;
public class Menu
{
    public static void main(String[] args)
    {
        ArrayList<Food> orderList = new ArrayList<Food>();  // store Food objs
        ArrayList<Double> priceList = new ArrayList<Double>();  // store price values (wrapped)
        Map<String, Food> orderMap = new HashMap<String, Food>();  // best for accessing unordered sets, <k=name, v=obj>
        
        // scanner obj
        Scanner scan = new Scanner(System.in);
                
        // welcome message
        System.out.println("Welcome to OOPs, an Online Ordering Program system!");
        System.out.println("At OOPs, 5 seconds isn't just a 'rule', it's the Law!");
        
        // implemented within loop until user exits program
        while(true)
        {
            // display menu and prompt for user's choice
            Food.menuForm();
            System.out.println("\nPlease enter the number from the above menu of Actions.");
            // scan for choice
            String choice = scan.nextLine();
            System.out.println("You entered: " + choice + "\n");
            if(choice.equals("1"))  // salad
            {
                // name
                System.out.println("Please enter the name of the Salad.");
                String n = scan.nextLine();
                System.out.println("You entered: " + n + ".\n");
                // price
                System.out.println("Please enter the price for the " + n + ".");
                double p = scan.nextDouble();
                System.out.println("You entered: " + p + ".\n");
                scan.nextLine();  // consume leftover line
                // side
                System.out.println("Please enter the side dish for the " + n + ".");
                String s = scan.nextLine();
                System.out.println("You entered: " + s + ".\n");
                // dressing
                System.out.println("Please enter the dressing for the " + n + ".");
                String d = scan.nextLine();
                System.out.println("You entered: " + d + ".\n");
                
                // create FrozenYogurt obj
                Salad sal = new Salad(n, p, s, d);
                // store obj and price in next index
                orderList.add(sal);
                priceList.add(p);
                // store obj in map with name assigned as key to the obj value
                orderMap.put(n, sal);
            }
            else if(choice.equals("2"))  // sandwich
            {
                // name
                System.out.println("Please enter the name of the sandwich.");
                String n = scan.nextLine();
                System.out.println("You entered: " + n + ".\n");
                // price
                System.out.println("Please enter the price for the " + n + ".");
                double p = scan.nextDouble();
                System.out.println("You entered: " + p + ".\n");
                scan.nextLine();
                // side
                System.out.println("Please enter the side dish for the " + n + ".");
                String s = scan.nextLine();
                System.out.println("You entered: " + s + ".\n");
                // bread
                System.out.println("Please enter the bread for the " + n + ".");
                String br = scan.nextLine();
                System.out.println("You entered: " + br + ".\n");
                
                // create FrozenYogurt obj
                Sandwich sand = new Sandwich(n, p, s, br);
                // store obj and price in next index
                orderList.add(sand);
                priceList.add(p);
                // map obj to orderMap as <name, obj>
                orderMap.put(n, sand);
            }
            else if(choice.equals("3"))  // frozen yogurt
            {
                // name
                System.out.println("Please enter the name of the Frozen Yogurt.");
                String n = scan.nextLine();
                System.out.println("You entered: " + n + ".\n");
                // price
                System.out.println("Please enter the price for the " + n + ".");
                double p = scan.nextDouble();
                System.out.println("You entered: " + p + ".\n");
                scan.nextLine();
                // base
                System.out.println("Please enter the base yogurt flavor for the " + n + ".");
                String ba = scan.nextLine();
                System.out.println("You entered: " + ba + ".\n");
                // String to append to topping
                System.out.println("Please enter the topping for the " + n + ".\n");
                String t = scan.nextLine();
                System.out.println("You entered: " + t + ".\n");
                
                // create FrozenYogurt obj
                FrozenYogurt frogurt = new FrozenYogurt(n, p, ba, t);
                // store obj and price in next index
                orderList.add(frogurt);
                priceList.add(p);
                // store <name, obj> in map
                orderMap.put(n, frogurt);
            }
            else if(choice.equals("4"))  // display an item
            {
                while(true)
                {
                    // scan for name
                    System.out.println("Please enter the name of item to display. Note: item names are case-sensitive.");
                    String n = scan.nextLine();
                    System.out.println("You entered: " + n + ".\n");
                    
                    if(orderMap.containsKey(n))  // if n is mapped as a key (ie: if name is found in map)
                    {
                        // invoke toString() on mapped objs (accessed via name key)
                        System.out.print(orderMap.get(n).toString());
                        break;
                    }
                    else if(orderMap.size() < 1)  // if no items have been stored in map
                    {
                        System.out.println("You haven't ordered any items yet. Please order an item from the Actions menu and try again.");
                        break;
                    }
                    else if(n.equalsIgnoreCase("0"))
                    {
                        break;
                    }
                    else  // else n is not mapped as key
                    {
                        System.out.println("Item not found. Please try again or enter 0 to return to the Actions menu.)");
                    }
                }
            }
            else if(choice.equals("5"))  // display all items
            {
                if(orderMap.size() < 1)  // if no items are stored in map
                {
                    System.out.println("You haven't ordered any items yet. Please add an item to your order then try again.");
                    break;
                }
                else
                {
                    System.out.println("\nReciept: displaying " + orderList.size() + " items():");
                    for(int i = 0; i < orderList.size(); i++)  // iterate orderList
                    {
                        // invoke toString() on each index
                        System.out.println(orderList.get(i).toString());
                    }
                }
                // display sum of each item's price
                double total = 0.0;
                for(int j = 0; j < priceList.size(); j++)  // iterate over priceList
                {
                    total += priceList.get(j);  // add double in each index to total
                }
                System.out.printf("Total bill: $", String.format("%.2f", total));  // round and display sum represented as a String
            }
            else if(choice.equals("6"))  // add topping
            {
                while(true) 
                {
                    // scan for item
                    System.out.println("Please enter the name of an item to add a topping. Note: item names are case-sensitive.");
                    String addTo = scan.nextLine();
                    System.out.println("You entered: " + addTo + "\n");
                    
                    if(orderMap.containsKey(addTo)) 
                    {  // if name of item is mapped as a key
                        // then scan for topping
                        System.out.println("Please enter the additional topping.");
                        String neoTop = scan.nextLine();
                        System.out.println("You entered: " + neoTop + "\n");
                        
                        // and invoke addTopping() on mapped obj (accessed via name key)
                        orderMap.get(addTo).addTopping(neoTop);
                        break;
                    }
                    else if(orderMap.size() < 1)  // if no items have been stored in map
                    {
                        System.out.println("You haven't ordered any items yet. Please order an item from the Actions menu and try again.");
                        break;
                    }
                    else if(addTo.equals("0")) 
                    {
                        break;
                    } 
                    else 
                    {
                        System.out.println("Item not found. Please try again or enter 0 to return to the Actions menu.");
                    }
                }
            }
            else if(choice.equals("9"))  // exit
            {
                System.out.println("Thanks for ordering from OOPs! Goodbye!");
                break;
            }
            else
            {
                System.out.println("That option is not valid option. Please enter a valid number.");                
            }
        }
    }
}
