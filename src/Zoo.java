import java.util.*;
public class Zoo {
	public List<Zone> listOfZone;
	public List<Cage> listOfCage;
	public List<Animal> listOfAnimal;
	public int numberOfZones;
	public int numberOfCages;
	
	public Zoo()
	{
		listOfZone=new ArrayList<Zone>();
		listOfCage=new ArrayList<Cage>();
		listOfAnimal=new ArrayList<Animal>();
		numberOfZones=0;
		numberOfCages=0;
	}

	public List<Zone> getListOfZone() {
		return listOfZone;
	}

	public void setListOfZone(List<Zone> listOfZone) {
		this.listOfZone = listOfZone;
	}

	public List<Cage> getListOfCage() {
		return listOfCage;
	}

	public void setListOfCage(List<Cage> listOfCage) {
		this.listOfCage = listOfCage;
	}

	public List<Animal> getListOfAnimal() {
		return listOfAnimal;
	}

	public void setListOfAnimal(List<Animal> listOfAnimal) {
		this.listOfAnimal = listOfAnimal;
	}
	
	public int getNumberOfZones() {
		return numberOfZones;
	}

	public void setNumberOfZones(int numberOfZones) {
		this.numberOfZones = numberOfZones;
	}

	public int getNumberOfCages() {
		return numberOfCages;
	}

	public void setNumberOfCages(int numberOfCages) {
		this.numberOfCages = numberOfCages;
	}

	public void addZone(String category,int capacityOfCages)
	{
		numberOfZones++;
		Zone zoneInstance=new Zone(numberOfZones,category,capacityOfCages);
		listOfZone.add(zoneInstance);
	}
	
	public void addCage(int zoneId,String typeOfAnimal,int capacityOfAnimal,String category) 
	{
		if(zoneId>numberOfZones)
		{
			throw new AssertionError("Zone with zone id "+zoneId+" doesn't exist in zoo");
		}
		Cage cageInstance=new Cage(numberOfCages+1,category,typeOfAnimal,capacityOfAnimal);
		Zone zone=listOfZone.get(zoneId);
		zone.addCage(cageInstance);
		listOfCage.add(cageInstance);
		numberOfCages++;
	}
	
	public boolean addAnimal(String category,String typeOfAnimal,String name,int age,double weight)
	{
		boolean isAdded=false;
		for(Zone zone:listOfZone)
		{
			String zoneCategory=zone.getCategory();
			if(category.equals(zoneCategory))
			{
				Animal animal=zone.addAnimal(typeOfAnimal,name,age,weight);
				if(animal!=null)
				{
					listOfAnimal.add(animal);
					isAdded=true;
					break;
				}
			}
		}
		return isAdded;
	}
	
	public void removeAnimal(String name)//not completed
	{
		Animal removingAnimal=null;
		for(Animal animal:listOfAnimal)
		{
			String animalName=animal.getName();
			if(name.equals(animalName))
			{
				listOfAnimal.remove(animal);
				
			}
		}
	}
	
	public int getTotalCapacity()
	{
		int totalCapacity=0;
		for(Zone zone:listOfZone)
		{
			totalCapacity+=zone.getTotalCapacity();
		}
		return totalCapacity;
	}
	
	public int getSpareCapacity()
	{
		int spareCapacity=0;
		for(Zone zone:listOfZone)
		{
		spareCapacity+=zone.getSpareCapacity();
		}
		return spareCapacity;
	}
	
	public HashMap<String, Integer> getSpecificSpareCapacity()
	{
		HashMap<String, Integer> specificSpareCapacity=new HashMap<String,Integer>();
		for(Cage cage:listOfCage)
		{
			String typeOfAnimal=cage.getTypeOfAnimal();
			int spareCapacity=cage.getSpareCapacity();
			boolean containsTypeOfAnimal=specificSpareCapacity.containsKey(typeOfAnimal);
			if(containsTypeOfAnimal)
			{
				spareCapacity+=specificSpareCapacity.get(typeOfAnimal);
				specificSpareCapacity.replace(typeOfAnimal, spareCapacity);
			}
			else
			{
				specificSpareCapacity.put(typeOfAnimal, spareCapacity);
			}
		}
		return specificSpareCapacity;
	}

}
