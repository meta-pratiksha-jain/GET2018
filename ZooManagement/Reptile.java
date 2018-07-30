public abstract class Reptile extends Animal {
    public String category="reptile";

    public Reptile(String name, int age, double weight) {
        super(name, age, weight);
    }
    
    @Override
    public String getCategory() {
        return category;
    }

}
