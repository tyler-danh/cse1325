public abstract class Product{
    
    public Product(String name, double cost){
        this.cost = cost;
        this.name = name;

        if(cost<0){
            throw new IllegalArgumentException("Cost: " + cost + " cannot be negative!");
        }
    }

    @Override
    public String toString() {
        StringBuilder item = new StringBuilder("" + name + "(" + cost + ")" + "" + cost);
        return item.toString();
    }

    public abstract double price();

    protected double cost;
    protected String name;
}
