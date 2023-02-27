import java.util.ArrayList;

public class Computer{
    public Computer(String name, String model){
        this.name = name;
        this.model = model;
    }

    public void addOption(Option option){
        options.add(option);
    }

    public long cost(){
        long total = 0;
        for(Option o : options){
            total += o.cost;
        }
        return total;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder("" + name + " (" + model + ")\n");
        for(Option o : options){
            result.append(o + " (" + o.cost + ")\n");
        }
        return result.toString();
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if((o == null) || !(o instanceof Computer))
            return false;
        Computer c = (Computer) o;
        return (c.toString().equals(o.toString()));
    }

    private String name;
    private String model;
    private ArrayList<Option> options = new ArrayList<>();
}