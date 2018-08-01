/**
 * Animal is base class for all animals.Animal name must be unique.
 * @author User19
 *
 */
public abstract class Animal {
    public String name;
    public int age;
    public double weight;
    
    public Animal(String name,int age, double weight)
    {
        this.name=name;
        this.age=age;
        this.weight=weight;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    public abstract String getInfo();
    
    public abstract String getSound();
    
    public abstract String getCategory();
    
    public abstract String getType();
}
