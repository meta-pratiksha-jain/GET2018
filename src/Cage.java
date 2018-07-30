import java.util.*;
public class Cage {
	public List<Animal> listOfAnimals;
	public String typeOfAnimal;
	public int capacityOfAnimals;
	public String category;
	public int cageId;
	public int numberOfAnimals;
	

	public Cage(int cageId,String category,String typeOfAnimal,int capacityOfAnimals)
	{
		listOfAnimals=new ArrayList<Animal>();
		this.cageId=cageId;
		this.typeOfAnimal=typeOfAnimal;
		this.capacityOfAnimals=capacityOfAnimals;
		this.category=category;
		numberOfAnimals=0;
	}

	public List<Animal> getListOfAnimals() {
		return listOfAnimals;
	}

	public void setListOfAnimals(List<Animal> listOfAnimals) {
		this.listOfAnimals = listOfAnimals;
	}

	public String getTypeOfAnimal() {
		return typeOfAnimal;
	}

	public void setTypeOfAnimal(String typeOfAnimal) {
		this.typeOfAnimal = typeOfAnimal;
	}

	public int getCapacityOfAnimals() {//8th operation
		return capacityOfAnimals;
	}

	public void setCapacityOfAnimals(int capacityOfAnimals) {
		this.capacityOfAnimals = capacityOfAnimals;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getCageId() {
		return cageId;
	}

	public void setCageId(int cageId) {
		this.cageId = cageId;
	}
	
	public Animal addAnimal(String name,int age,double weight)
	{
		Animal animal=null;
		if(numberOfAnimals<capacityOfAnimals)
		{
			switch(typeOfAnimal)
			{
			case "lion":
				animal=new Lion(name,age,weight);
				listOfAnimals.add(animal);
				numberOfAnimals++;
				break;
			case "elephant":
				animal=new Elephant(name, age, weight);
				listOfAnimals.add(animal);
				numberOfAnimals++;
				break;
			case "crocodile":
				animal=new Crocodile(name, age, weight);
				listOfAnimals.add(animal);
				numberOfAnimals++;
				break;
			case "snake":
				animal=new Snake(name, age, weight);
				listOfAnimals.add(animal);
				numberOfAnimals++;
				break;
			case "peacock":
				animal=new Peacock(name, age, weight);
				listOfAnimals.add(animal);
				numberOfAnimals++;
				break;
			case "pigeon":
				animal=new Pigeon(name, age, weight);
				listOfAnimals.add(animal);
				numberOfAnimals++;
				break;
			}
			
		}
		return animal;
	}
	
	public void removeAnimal(String name)
	{
		for(Animal animal:listOfAnimals)
		{
			String animalName=animal.getName();
			if(name.equals(animalName))
			{
				listOfAnimals.remove(animal);
				numberOfAnimals--;
				return;
			}
		}
	}
	
	public int getSpareCapacity()
	{
		int spareCapacity=capacityOfAnimals-numberOfAnimals;
		return spareCapacity;
	}

}
