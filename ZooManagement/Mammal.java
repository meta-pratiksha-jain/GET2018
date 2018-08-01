public abstract class Mammal extends Animal {
    public String category="mammal";

    public Mammal(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public String getCategory() {
        return category;
    }

}
