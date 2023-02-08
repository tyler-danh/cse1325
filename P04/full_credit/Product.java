public class Product{
    protected double cost;
    protected String name;

    public class Product{
        this.cost = cost;
        this.name = name;

        if(cost<0){
            throw new IllegalArgumentException("Cost: " + cost + " cannot be negative!");
        }
    }
    public abstract class price{}

    public string toString() {
        StringBuilder item = new Stringbuilder("" + name + "(" + cost + ")" + "" + cost);
        return item.toString();
    }

}