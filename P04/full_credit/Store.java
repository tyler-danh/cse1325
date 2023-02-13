import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Store{
    public static void main(String[] args){
        Taxed.setTaxRate(0.08);
        Scanner input = new Scanner(System.in);
        int selection;

        while(true){
            System.out.println("= = = = = = = = = = = = = = = = = = = =\n" 
                                + "          Welcome to WAHMart    \n"
                        + "= = = = = = = = = = = = = = = = = = = =\n");
            for(Product p : products){
                int i = 1;
                p.price();
                //System.out.printf("%d) %.2f\n", ++i , p.price());

                System.out.println(i + p.toString());
                ++i;
            }
            System.out.println("Which would you like to purchase?");
            selection = input.nextLine();
        }
        
    }
    private static ArrayList<Product> products = new ArrayList<>(
           Arrays.asList(new Taxed("Coca-cola (2-liter)", 2.68), new Taxed("Cookies & Cream Ice Cream (half gallon)", 7.98), new Taxed("M&Ms Milk Chocolate (family size)", 6.98),
                            new TaxFree("Milk (1-gallon)", 3.07), new TaxFree("Bread", 3.13), new TaxFree("Butter", 4.98)));

    private static ArrayList<Product> shoppingCart = new ArrayList<>();
}