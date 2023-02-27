public class Customer{

    public Customer(String name, String email){
        this.name = name;
        this.email = email;

        if((emailConfirm == -1) || (emailConfirm2 == -1)){
            throw new IllegalArgumentException("Invalid Email");
        }
            
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if((o == null) || !(o instanceof Customer))
            return false;
        Customer c = (Customer) o;
        return (email.equals(c.email) && name.equals(c.name));
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder("" + name + " (" + email + ") ");
        return result.toString();
    }

    private String name;
    private String email;
    private int emailConfirm = email.indexOf("@", 0);
    private int emailConfirm2 = email.indexOf(".", emailConfirm);

}