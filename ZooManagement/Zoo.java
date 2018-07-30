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

    /**
     * add a zone into zoo.
     * @param category contains category of zone.
     * @param capacityOfCages contains total number of cages can be placed in zone.
     * @return returns true when zone is added to the zoo.
     */
    public boolean addZone(String category,int capacityOfCages)
    {
        numberOfZones++;
        Zone zoneInstance=new Zone("zone"+numberOfZones,category,capacityOfCages);
        listOfZone.add(zoneInstance);
        return true;
    }
    
    /**
     * add a cage into zone.
     * @param zoneId contains the id of the zone in which cage is  to be added.
     * @param typeOfAnimal contains type of animals can be added into cage.
     * @param capacityOfAnimal contains number of animals can be placed into cage.
     * @param category contains category of animals.
     * @return returns true if cage is added to the zoo otherwise false.
     */
    public boolean addCage(String zoneId,String category,int capacityOfAnimal,String typeOfAnimal) 
    {
        boolean isCageAdded=false;
        for(Zone zone:listOfZone)
        {
            if(zoneId.equals(zone.getZoneId()))
            {
                Cage cageInstance=new Cage("cage"+(numberOfCages+1),category,typeOfAnimal,capacityOfAnimal);
                isCageAdded=zone.addCage(cageInstance);
                listOfCage.add(cageInstance);
                numberOfCages++;
            }
        }
        return isCageAdded;
    }
    
    /**
     * add an animal into zoo.
     * @param category contains category of animal.
     * @param typeOfAnimal contains animal type.
     * @param name contains name of animal.It must be unique.
     * @param age contains  age of animal.
     * @param weight contains weight of animal.
     * @return returns true if animal has been added to the zoo otherwise false.
     */
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
                    return isAdded;
                }
            }
        }
        return isAdded;
    }
    
    /**
     * removes an animal from the zoo.Animal is removed on it's death. 
     * @param name contains name of animal.
     * @return returns true if animal is removed from zoo otherwise false.
     */
    public boolean removeAnimal(String name)
    {
        boolean isRemoved=false;
        Animal removedAnimal=null;
        for(Animal animal:listOfAnimal)
        {
            String animalName=animal.getName();
            if(name.equals(animalName))
            {
                listOfAnimal.remove(animal);
                removedAnimal=animal;
                for(Zone zone:listOfZone)
                {
                    String zoneCategory=zone.getCategory();
                    String animalCategory=removedAnimal.getCategory();
                    if(zoneCategory.equals(animalCategory))
                    {
                        isRemoved=zone.removeAnimal(removedAnimal);
                        if(isRemoved)
                        {
                            return isRemoved;
                        }
                    }
                }
                break;
            }
        }
        
        return isRemoved;
    }
    
}
