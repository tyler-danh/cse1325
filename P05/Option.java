public class Option{

    public Option(String name, long cost){
        this.name = name;
        this.cost = cost;

        if(cost<0){
            throw new IllegalArgumentException("Cost cannot be negative");
        }
    }

    public long cost(){
        return cost/100;
    }

    public boolean equals(Object o){
        if(this == o)
            return true;
        if((o == null) || !(o instanceof Option))
            return false;
        Option op = (Option) o;
        return (name.equals(op.name) && cost == op.cost);
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder("" + name + " (" + cost() + ") ");
        return result.toString();
    }

    protected String name;
    protected long cost;
}