import java.util.ArrayList;

public class Order{
    public Order(Customer customer){
        this.customer = customer;
    }
    public void addComputer(Computer computer){

    }
    @Override
    public String toString(){

    }
    public boolean equals(Object o){
        
    }

    private static long nextOrderNumber = 0;
    private long orderNumber;
    private Customer customer;
    private ArrayList<Computer> computers = new ArrayList<>();
}