package counselingProcess;

/**
 * This class represents program offered by college
 *
 */
public class Program {
    public String name;
    public int capacity;
    public int numberOfAllocatedStudents;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public int getNumberOfAllocatedStudents() {
        return numberOfAllocatedStudents;
    }
    public void setNumberOfAllocatedStudents(int numberOfAllocatedStudents) {
        this.numberOfAllocatedStudents = numberOfAllocatedStudents;
    }
    

}
