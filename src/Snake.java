
public class Snake extends Reptile {
	public String type="snake";

	public Snake(String name, int age, double weight) {
		super(name, age, weight);
	}

	@Override
	public String getInfo() {
		String information="Name:"+name+" age:"+age+ " weight:"+weight+" sound:"+getSound()+" type:"+type+" category:"+category;
		return information;
	}

	@Override
	public String getSound() {
		String sound="hiss";
		return sound;
	}

    @Override
    public String getType() {
        // TODO Auto-generated method stub
        return type;
    }

}
