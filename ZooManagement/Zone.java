import java.util.*;
public class Zone {
    public String category;
    public List<Cage> listOfCage;
    public int capacityOfCages;
    public int numberOfCages;
    public String zoneId;
    
    public Zone(String zoneId,String category,int capacityOfCages)
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

    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }
    
    /**
     * add a cage into zone.
     * @param cageInstance contains the cage which should be added to the zone.
     * @return returns true if cage is added to the zone otherwise false.
     */
    public boolean addCage(Cage cageInstance)
    {
        boolean isCageAdded=false;
        boolean categoryMatch=category.equals(cageInstance.getCategory());
        if(!categoryMatch)
        {
            return isCageAdded;
        }
        if(numberOfCages==capacityOfCages)
        {
            return isCageAdded;
        }
        listOfCage.add(cageInstance);
        numberOfCages++;
        isCageAdded=true;
        return isCageAdded;
    }
    
    /**
     * add an animal to the zone.
     * @param typeOfAnimal contains the animal type.
     * @param name contains name of animal.
     * @param age contains age of animal.
     * @param weight contains weight of animal.
     * @return returns the Animal instance which is added to the zone.
     */
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
    
    /**
     * removes an animal from zone.
     * @param animal contains animal which should be removed from zone.
     * @return returns true if animal is removed from cage otherwise false.
     */
    public boolean removeAnimal(Animal animal)
    {
        boolean isRemoved=false;
        String animalType=animal.getType();
        for(Cage cage:listOfCage)
        {
            String cageType=cage.getTypeOfAnimal();
            if(animalType.equals(cageType));
            {
                isRemoved=cage.removeAnimal(animal);
                if(isRemoved)
                {
                    return isRemoved;
                }
            }
        }
        return isRemoved;
    }

}
