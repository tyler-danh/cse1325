package store;
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

    @Override
    public boolean equals(Object o){
        try {
            if(this == o) return true;
            if(this.getClass() != o.getClass()) return false;
            Option p = (Option) o;
            return this.name.equals(p.name) && (this.cost == p.cost);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder("" + name + " (" + cost() + ") ");
        return result.toString();
    }

    protected String name;
    protected long cost;
}