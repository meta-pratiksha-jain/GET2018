public abstract class Bird extends Animal {

    public String category="bird";

    public Bird(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public String getCategory() {
        return category;
    }

}
