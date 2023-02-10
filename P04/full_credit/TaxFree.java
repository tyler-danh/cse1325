public class TaxFree extends Product{
    public TaxFree(String name, double cost){
        super(name, cost);
    }

    @Override
    public double price(){
        return cost;
    }
}