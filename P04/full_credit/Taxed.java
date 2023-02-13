public class Taxed extends Product{
    
    public Taxed(String name, double cost){
        super(name, cost);
    }

    public static void setTaxRate(double salesTax){
        tax = salesTax;
    }

    @Override
    public double price() {
        return cost * (tax+1);
    }

    private static double tax = 0.0;
}