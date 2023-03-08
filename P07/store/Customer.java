package store;
public class Customer{

    public Customer(String name, String email){
        this.name = name;
        this.email = email;

        int emailConfirm = email.indexOf("@", 0);
        int emailConfirm2 = email.indexOf(".", emailConfirm);
        if((emailConfirm == -1) || (emailConfirm2 == -1)){
            throw new IllegalArgumentException("Invalid Email");
        }
           
    }

    @Override
    public boolean equals(Object o){
        try {
            if(this == o) return true;
            if(this.getClass() != o.getClass()) return false;
            Customer c = (Customer) o;
            return this.name.equals(c.name) && this.email.equals(c.email);
        } catch (Exception e) {
            return false;
        }
   }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder("" + name + " (" + email + ") ");
        return result.toString();
    }

    private String name;
    private String email;
    

}