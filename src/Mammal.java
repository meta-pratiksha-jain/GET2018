
public abstract class Mammal extends Animal {
	public String category="mammal";

	public Mammal(String name, int age, double weight) {
		super(name, age, weight);
	}

	@Override
	public abstract String getInfo() ;

	@Override
	public abstract String getSound();

    @Override
    public String getCategory() {
        // TODO Auto-generated method stub
        return category;
    }

}
