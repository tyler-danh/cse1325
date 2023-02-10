public class Product{
    
    public class Product(String name, double cost){
        this.cost = cost;
        this.name = name;

        if(cost<0){
            throw new IllegalArgumentException("Cost: " + cost + " cannot be negative!");
        }
    }
    public abstract class price{}

    public String toString() {
        StringBuilder item = new Stringbuilder("" + name + "(" + cost + ")" + "" + cost);
        return item.toString();
    }

    protected double cost;
    protected String name;
}
