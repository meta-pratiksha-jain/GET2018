
public abstract class Bird extends Animal {

    public String category="bird";

	public Bird(String name, int age, double weight) {
		super(name, age, weight);
	}

	@Override
    public String getCategory() {
        // TODO Auto-generated method stub
        return category;
    }

    @Override
	public abstract String getInfo() ;

	@Override
	public abstract String getSound(); 


}
