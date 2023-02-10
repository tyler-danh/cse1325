import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Store{
    public static void main(String[] args){
        setSalesTax();
        System.out.println("= = = = = = = = = = = = = = = = = = = =\n" 
                                + "   Welcome to WAHMart    \n"
                        + "= = = = = = = = = = = = = = = = = = = =\n");
        
    }
    private ArrayList<Product> products = new ArrayList<>(
            Arrays.asList(new Taxed("Coca-cola (2-liter)", 2.68), new Taxed("Cookies & Cream Ice Cream (half gallon)", 7.98), new Taxed("M&Ms Milk Chocolate (family size)", 6.98),
                            new TaxFree("Milk (1-gallon)", 3.07), new TaxFree("Bread", 3.13), new TaxFree("Butter", 4.98)));

    private ArrayList<Product> shoppingCart = new ArrayList<>();
}