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

    //@Override
    /*public boolean equals(Object o){
        if(this == o)
            return true;
        if((o == null) || !(o instanceof Order))
            return false;
        Order ord = (Order) o;
        return ();
    }*/

    private static long nextOrderNumber = 0;
    private long orderNumber;
    private Customer customer;
    private ArrayList<Computer> computers = new ArrayList<>();
}