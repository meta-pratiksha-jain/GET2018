public class Lion extends Mammal {
    public String type="lion";

    public Lion(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public String getInfo() {
        String information="Name:"+name+" age:"+age+ " weight:"+weight+" sound:"+getSound()+" type:"+type+" category:"+category;
        return information;
    }

    @Override
    public String getSound() {
        String sound="roars";
        return sound;
    }

    @Override
    public String getType() {
        return type;
    }

}
