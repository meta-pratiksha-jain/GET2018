package employee;

/**
 * This class represents an employee.
 * 
 */
public class Employee {
    private int id;
    private String name;
    private String addresss;
    
    /**
     * constructor
     * @param id
     * @param name
     * @param address
     */
    public Employee(int id,String name,String address)
    {
        this.id=id;
        this.name=name;
        this.addresss=address;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddresss() {
        return addresss;
    }
    public void setAddresss(String addresss) {
        this.addresss = addresss;
    }

}
