package store;
import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;


public class Order{
    public Order(Customer customer){
        this.customer = customer;
        this.orderNumber = nextOrderNumber;
    }

    public Order(BufferedReader br) throws IOException {
        this.orderNumber = Long.parseLong(br.readLine());
        if(nextOrderNumber <= orderNumber) nextOrderNumber = orderNumber + 1;
        this.customer = new Customer(br);
        int numOptions = Integer.parseInt(br.readLine());
        while(numOptions-- > 0)
            computers.add(new Computer(br));
    }
    public void save(BufferedWriter bw) throws IOException {
        bw.write(Long.toString(orderNumber) + '\n');
        this.customer.save(bw);
        bw.write("" + computers.size() + '\n');
        for(Computer computer : computers)
            computer.save(bw);
    }

    public void addComputer(Computer computer){
        computers.add(computer);
    }

    public double totalCost(ArrayList<Computer> computers){
        double total = 0;
        for(Computer computer : computers){total+=computer.cost();}
        return total;
    }
    
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder(" Order " + orderNumber + " for " + customer + "\n");
        for(Computer c : computers){
            result.append(c);
        }
        result.append(this.totalCost(computers));
        return result.toString();
    }

    @Override
    public boolean equals(Object o){
        try {
            if(this == o) return true;
            if(this.getClass() != o.getClass()) return false;
            Order c = (Order) o;
            if(!this.customer.equals(c.customer)) return false;
            if(this.computers.size() != c.computers.size()) return false;
            for(int i=0; i<this.computers.size(); ++i)
                if(!this.computers.get(i).equals(c.computers.get(i))) return false;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static long nextOrderNumber = 0;
    private long orderNumber;
    private Customer customer;
    private ArrayList<Computer> computers = new ArrayList<>();
}