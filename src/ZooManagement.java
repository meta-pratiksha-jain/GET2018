import java.util.*; 
public class ZooManagement {
	public static void main(String[] args)
	{
		Zoo zoo=new Zoo();
		zoo.addZone("mammal", 10);
		zoo.addZone("reptile", 5);
		zoo.addZone("bird",20);
		List<Zone> listOfZone=zoo.getListOfZone();
		for(Zone zone:listOfZone)
		{
		    System.out.println(zone.getZoneId());
		}
		zoo.addCage(1, "lion", 1, "mammal");
		zoo.addCage(1, "lion", 1, "mammal");
		zoo.addCage(1, "elephant", 5, "mammal");
		zoo.addCage(1, "elephant", 5, "mammal");
		zoo.addCage(2, "crocodile", 2, "reptile");
		zoo.addCage(2, "crocodile", 2, "reptile");
		zoo.addCage(2, "crocodile", 2, "reptile");
		zoo.addCage(2, "snake", 5, "reptile");
		zoo.addCage(2, "snake", 5, "reptile");
		List<Cage> listOfCage=zoo.getListOfCage();
        for(Cage cage:listOfCage)
        {
            System.out.println(cage.getCageId());
        }
        zoo.addAnimal("mammal", "lion", "lion1", 20, 80);
        List<Animal> listOfAnimals=zoo.getListOfAnimal();
        for(Animal animal:listOfAnimals)
        {
            System.out.println(animal.getInfo());
        }
        zoo.removeAnimal("lion1");
        System.out.println(listOfAnimals.size());
	}

}
