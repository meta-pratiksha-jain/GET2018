import java.util.*;
public class Cage {
    public List<Animal> listOfAnimals;
    public String typeOfAnimal;
    public int capacityOfAnimals;
    public String category;
    public String cageId;
    public int numberOfAnimals;
    

    public Cage(String cageId,String category,String typeOfAnimal,int capacityOfAnimals)
    {
        listOfAnimals=new ArrayList<Animal>();
        this.cageId=cageId;
        this.category=category;
        this.typeOfAnimal=typeOfAnimal;
        this.capacityOfAnimals=capacityOfAnimals;
        
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

    public int getCapacityOfAnimals() {
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

    public String getCageId() {
        return cageId;
    }

    public void setCageId(String cageId) {
        this.cageId = cageId;
    }
    
    /**
     * Add an animal into cage.
     * @param name contains the name of the animal.
     * @param age contains age of animal.
     * @param weight contains weight of an animal.
     * @return returns animal instance which is added into cage.
     */
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
    
    /**
     * removes an animal from cage.
     * @param removedAnimal contains the animal instance which should be removed from cage.
     * @return returns true if animal is removed from cage otherwise false.
     */
    public boolean removeAnimal(Animal removedAnimal)
    {
        boolean isRemoved=false;
        String removedAnimalName=removedAnimal.getName();
        for(Animal animal:listOfAnimals)
        {
            String animalName=animal.getName();
            if(removedAnimalName.equals(animalName))
            {
                isRemoved=listOfAnimals.remove(animal);
                numberOfAnimals--;
                return isRemoved;
            }
        }
        return isRemoved;
    }

}
