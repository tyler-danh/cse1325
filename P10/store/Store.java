package store;
import java.util.ArrayList;

import javax.swing.text.html.Option;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Store {

    public void save(BufferedWriter bw)throws IOException{
        bw.write("" + name + '\n');
        bw.write("" + options.size() + '\n');
        for(Option options : options) options.save(bw);
        bw.write("" + customers.size() + '\n');
        for(Customer customers : customers) customers.save(bw);
        
    }

    public Store(BufferedReader br)throws IOException{
        this.name = br.readLine();
        //int i = Integer.parseInt(br.readLine());
        long l = Long.parseLong(br.readLine());
        double d = Double.parseDouble(br.readLine());
        int size = Integer.parseInt(br.readLine());
        while(size-->0) options.add(new Option(br));
        while(size-->0) customers.add(new Customer(br));
        }

    public Store(String name) {
        this.name = name;
    }
    public String name() {
        return this.name;
    }
    
    // ///////////////////////////////////////////////////////////
    // Customers
    
    public void add(Customer customer) {
        if(!customers.contains(customer)) customers.add(customer);
    }
    public Object[] customers() {
        return this.customers.toArray();
    }
    
    // ///////////////////////////////////////////////////////////
    // Options
    
    public void add(Option option) {
        if(!options.contains(option)) options.add(option);
    }
    public Object[] options() {
        return this.options.toArray();
    }
    
    // ///////////////////////////////////////////////////////////
    // Computers
    
    public void add(Computer computer) {
        if(!computers.contains(computer)) computers.add(computer);
    }
    public Object[] computers() {
        return this.computers.toArray();
    }
    
    // ///////////////////////////////////////////////////////////
    // Orders
    
    public void add(Order order) {
        if(!orders.contains(order)) orders.add(order);
    }
    public Object[] orders() {
        return this.orders.toArray();
    }

    // ///////////////////////////////////////////////////////////
    // Fields
    
    private String name;
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Option> options = new ArrayList<>();
    private ArrayList<Computer> computers = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
}
