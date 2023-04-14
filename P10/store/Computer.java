package store;
import java.util.ArrayList;
import java.IOException;
import java.BufferedReader;
import java.BufferedWriter;

public class Computer{
    public Computer(String name, String model){
        this.name = name;
        this.model = model;
    }

    public void addOption(Option option){
        options.add(option);
    }
    public Computer(BufferedReader br) throws IOException {
        this.name = br.readLine();
        this.model = br.readLine();
        int numOptions = Integer.parseInt(br.readLine());
        while(numOptions-- > 0)
            options.add(new Option(br));
    }

    public void save(BufferedWriter bw) throws IOException {
        bw.write(name + '\n');
        bw.write(model + '\n');
        bw.write("" + options.size() + '\n');
        for(Option option : options)
            option.save(bw);
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
    public boolean equals(Object o) {
        try {
            if(this == o) return true;
            if(this.getClass() != o.getClass()) return false;
            Computer c = (Computer) o;
            return this.toString().equals(c.toString());
        } catch (Exception e) {
            return false;
        }
    }

    private String name;
    private String model;
    private ArrayList<Option> options = new ArrayList<>();
}