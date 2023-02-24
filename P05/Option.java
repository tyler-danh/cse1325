public class Option{

    public Option(String name, long cost){
        this.name = name;
        this.cost = cost;

        if(cost<0){
            throw new IllegalArgumentException("Cost cannot be negative");
        }
    }

    public long cost(){
        return cost/100.0;
    }

    public boolean equals(Object o){
        
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder("" + name + " (" + cost() + ") ");
        return options.toString();
    }

    protected String name;
    protected long cost;
}