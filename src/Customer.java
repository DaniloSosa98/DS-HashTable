
import java.util.Objects;


public class Customer {

    private int c_number;
    private String c_name;
    private String con_lastname;
    private String con_firstname;
    private String phone;
    private String adress_1;
    private String adress_2;
    private String city;
    private String state;
    private String pcode;
    private String country;
    private int e_number;
    private double c_limit;

    public Customer() {
    }
    
    public Customer(int id){
        c_number = Integer.MIN_VALUE;
    }

    public Customer(int c_number, String c_name, String con_lastname, String con_firstname, String phone, String adress_1, String adress_2, String city, String state, String pcode, String country, int e_number, double c_limit) {
        this.c_number = c_number;
        this.c_name = c_name;
        this.con_lastname = con_lastname;
        this.con_firstname = con_firstname;
        this.phone = phone;
        this.adress_1 = adress_1;
        this.adress_2 = adress_2;
        this.city = city;
        this.state = state;
        this.pcode = pcode;
        this.country = country;
        this.e_number = e_number;
        this.c_limit = c_limit;
    }

    public int getC_number() {
        return c_number;
    }

    public String getC_name() {
        return c_name;
    }

    @Override
    public String toString() {
        return "\nCustomer" + "\n Costumer Number: " + c_number + "\n Name: "
                + c_name + "\n";
    }

    public int hash() {
        int index, hash;
        hash = c_name.hashCode();
        index = hash % 163;
        if (index<0) {
            index = index*-1;
        }
        return index;
    }
    
}
