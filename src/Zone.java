import java.util.*;
public class Zone {
	public String category;
	public List<Cage> listOfCage;
	public int capacityOfCages;
	public int numberOfCages;
	public int zoneId;
	
	public Zone(int zoneId,String category,int capacityOfCages)
	{
		listOfCage=new ArrayList<Cage>();
		this.zoneId=zoneId;
		this.category=category;
		this.capacityOfCages=capacityOfCages;
		numberOfCages=0;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Cage> getListOfCage() {
		return listOfCage;
	}

	public void setListOfCage(List<Cage> listOfCage) {
		this.listOfCage = listOfCage;
	}

	public int getCapacityOfCages() {
		return capacityOfCages;
	}

	public void setCapacityOfCages(int capacityOfCages) {
		this.capacityOfCages = capacityOfCages;
	}
	
	public int getNumberOfCages() {
		return numberOfCages;
	}

	public void setNumberOfCages(int numberOfCages) {
		this.numberOfCages = numberOfCages;
	}

	public int getZoneId() {
		return zoneId;
	}

	public void setZoneId(int zoneId) {
		this.zoneId = zoneId;
	}

	public void addCage(Cage cageInstance)
	{
		boolean categoryMatch=category.equals(cageInstance.getCategory());
		if(!categoryMatch)
		{
			throw new AssertionError("Zone and cage are of different categories. So,this cage can't added to this zone.");
		}
		if(numberOfCages==capacityOfCages)
		{
			throw new AssertionError("Zone "+zoneId+"is full.So new cage can't added to this zone");
		}
		listOfCage.add(cageInstance);
		numberOfCages++;
	}
	
	public Animal addAnimal(String typeOfAnimal,String name,int age,double weight)
	{
		Animal animal=null;
		for(Cage cage:listOfCage)
		{
			if(cage.getTypeOfAnimal()==typeOfAnimal)
			{
				animal=cage.addAnimal(name,age,weight);
				if(animal!=null)
				{
					return animal;
				}
			}
		}
		return animal;
	}
	
	public void removeAnimal(Animal animal)
	{
		String animalType=animal.getType();
		for(Cage cage:listOfCage)
		{
		    String cageType=cage.getTypeOfAnimal();
		    if(animalType.equals(cageType));
		    {
		        cage.removeAnimal(animal);
		    }
		}
	}
	
	public int getTotalCapacity()
	{
		int totalCapacity=0;
		for(Cage cage:listOfCage)
		{
			totalCapacity=totalCapacity+cage.getCapacityOfAnimals();
		}
		return totalCapacity;
	}
	
	public int getSpareCapacity()
	{
		int spareCapacity=0;
		for(Cage cage:listOfCage)
		{
			spareCapacity+=cage.getSpareCapacity();
		}
		return spareCapacity;
	}

}
