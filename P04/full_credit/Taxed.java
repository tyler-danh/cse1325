public class Taxed extends Product{
    
    public Taxed(String name, double cost){
        super(name, cost);
    }

    public static setTaxRate(double salesTax){
        tax = salesTax;
    }

    @Override
    public double price() {
        return cost * tax;
    }

    private static double tax = 0.0;
}