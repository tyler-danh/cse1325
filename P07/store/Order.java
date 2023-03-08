package store;
import java.util.ArrayList;

public class Order{
    public Order(Customer customer){
        this.customer = customer;
        this.orderNumber = nextOrderNumber;
    }

    public void addComputer(Computer computer){
        computers.add(computer);
    }
    
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder(" Order " + orderNumber + " for " + customer + "\n");
        for(Computer c : computers){
            result.append(c);
        }
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