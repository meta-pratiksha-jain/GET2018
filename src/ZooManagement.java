import java.util.*; 
public class ZooManagement {
	public static void main(String[] args)
	{
		Lion lion=new Lion("lion1",12,60.0);
		String info=lion.getInfo();
		System.out.println(info);
		
		Elephant elephant=new Elephant("elephant1", 10, 150.0);
		info=elephant.getInfo();
		System.out.println(info);
		
		Crocodile crocodile=new Crocodile("crocodile1", 14, 100.0);
		info=crocodile.getInfo();
		System.out.println(info);
		
		Snake snake=new Snake("snake1", 29, 38.0);
		info=snake.getInfo();
		System.out.println(info);
		
		Peacock peacock=new Peacock("peacock1", 24, 29.0);
		info=peacock.getInfo();
		System.out.println(info);
		
		Pigeon pigeon=new Pigeon("pigeon1", 5, 19);
		info=pigeon.getInfo();
		System.out.println(info);
		
		Cage cage=new Cage(1, "mammal", "lion", 2);
		System.out.println(cage.getCapacityOfAnimals());
		System.out.println(cage.getSpareCapacity());
		
		Zone zone=new Zone(1, "mammal",4);
		zone.addCage(cage);
		System.out.println(zone.getNumberOfCages());
		System.out.println(zone.getCapacityOfCages());
		System.out.println(zone.getTotalCapacity());
		System.out.println(zone.getSpareCapacity());
	}

}
