import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Store{
    public static void main(String[] args){
        Taxed.setTaxRate(0.08);
        Scanner input = new Scanner(System.in);
        int selection;
        double totalPrice = 0;

        while(true){
            System.out.println("= = = = = = = = = = = = = = = = = = = =\n" 
                                + "          Welcome to WAHMart    \n"
                        + "= = = = = = = = = = = = = = = = = = = =\n");
            for(Product p : products){
                System.out.println((products.indexOf(p)) + ") " + p);
            }
            System.out.println("Which would you like to purchase?");
            selection = input.nextInt();
            try{
                shoppingCart.add(products.get(selection)); 
            }catch(Exception e){
                System.err.println("Invalid selection!");
                System.exit(-2);
            }
            System.out.println("- - - - - - - - - -\n" 
                                + "   Current Order\n");
            for(Product s : shoppingCart){
                System.out.println(s);
                totalPrice = s.price() + totalPrice;
            }
            System.out.println("Total price: " + decimal.format(totalPrice));
        }
        
    }
    private static ArrayList<Product> products = new ArrayList<>(
           Arrays.asList(new Taxed("Coca-cola", 2.68), new Taxed("Ice Cream", 7.98), new Taxed("M&Ms Milk Chocolate", 6.98),
                            new TaxFree("Milk", 3.07), new TaxFree("Bread", 3.13), new TaxFree("Butter", 4.98)));

    private static ArrayList<Product> shoppingCart = new ArrayList<>();

    private final static DecimalFormat decimal = new DecimalFormat("0.00");
}