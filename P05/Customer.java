public class Customer{

    public Customer(String name, String email){
        this.name = name;
        this.email = email;

        if(email.indexOf("@", 0) && email.indexOf(".", (email.indexOf("@", 0))) ){
            throw new IllegalArgumentException("Invalid Email");
        }
            
    }

    public boolean equals(Object o){
        return true;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder("" + name + " (" + email + ") ");
        return result.toString();
    }

    private String name;
    private String email;

}