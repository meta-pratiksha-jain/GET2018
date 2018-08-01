import static org.junit.Assert.*;

import org.junit.Test;


public class ZooTest {

    @Test
    public void test() {
       Zoo zoo=new Zoo();
       //test case to add zone
       boolean isAdded=zoo.addZone("mammal", 3);
       assertEquals(true,isAdded);
       isAdded=zoo.addZone("reptile", 10);
       assertEquals(true,isAdded);
       
       //test case to add cage with same category as category of zone and have space in zone 
       isAdded=zoo.addCage("zone1", "mammal", 1, "lion");
       assertEquals(true,isAdded);
       isAdded=zoo.addCage("zone1", "mammal", 1, "elephant");
       assertEquals(true,isAdded);
       isAdded=zoo.addCage("zone1", "mammal", 1, "elephant");
       assertEquals(true,isAdded);
       //test case to add cage with different category as category of zone
       isAdded=zoo.addCage("zone1", "reptile", 3, "crocodile");
       assertEquals(false,isAdded);
       //test case to add cage with same category as category of zone but zone is full
       isAdded=zoo.addCage("zone1", "mammal", 1, "lion");
       assertEquals(false,isAdded);
       
       //test case to add animal in zoo when there is space in zoo
       isAdded=zoo.addAnimal("mammal", "lion", "sheru", 12, 80);
       assertEquals(true,isAdded);
       //test case to add animal in zoo when zone with same category as animal doesn't exist in zoo
       isAdded=zoo.addAnimal("bird", "peacock", "cock", 5, 20);
       assertEquals(false,isAdded);
       //test case to add an animal in zoo when cage with same type as type of animal is full
       isAdded=zoo.addAnimal("mammal", "lion", "sher", 8, 70);
       assertEquals(false,isAdded);
       //test case to add an animal in zoo when cage doesn't exist in zoo
       isAdded=zoo.addAnimal("reptile", "snake", "snake1", 30, 28);
       assertEquals(false,isAdded);
       
       //test case to remove an animal when animal doesn't exist in zoo
       boolean isRemoved=zoo.removeAnimal("cock");
       assertEquals(false,isRemoved);
       //test case to remove an animal when it exists in zoo
       isRemoved=zoo.removeAnimal("sheru");
       assertEquals(true,isRemoved);
    }

}
