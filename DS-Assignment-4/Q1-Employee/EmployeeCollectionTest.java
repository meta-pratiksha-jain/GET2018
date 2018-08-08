package employee;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

public class EmployeeCollectionTest {
    EmployeeCollection collectionInstance;

    //test case for addEmployeeToCollection()
    @Test
    public void testaddEmployeeShouldReturnTrueWhenCollectionEmpty() {
        collectionInstance=new EmployeeCollection();
        Employee employee=new Employee(1,"pratiksha","jaipur");
        boolean isAdded=collectionInstance.addEmployeeToCollection(employee);
        assertEquals(true,isAdded);
    }
    
    @Test
    public void testaddEmployeeShouldReturnTrueWhenEmployeeIdDifferent() {
        collectionInstance=new EmployeeCollection();
        Employee employee=new Employee(1,"pratiksha","jaipur");
        collectionInstance.addEmployeeToCollection(employee);
        employee=new Employee(6,"pratiksha","udaipur");
        boolean isAdded=collectionInstance.addEmployeeToCollection(employee);
        assertEquals(true,isAdded);
    }
    
    @Test
    public void testaddEmployeeShouldReturnTrueWhenEmployeeIdSame() {
        collectionInstance=new EmployeeCollection();
        Employee employee=new Employee(1,"pratiksha","jaipur");
        collectionInstance.addEmployeeToCollection(employee);
        employee=new Employee(1,"priya","udaipur");
        boolean isAdded=collectionInstance.addEmployeeToCollection(employee);
        assertEquals(false,isAdded);
    }
    
    @Test(expected=AssertionError.class)
    public void testaddEmployeeShouldThrowExceptionForNullEmployee() {
        collectionInstance=new EmployeeCollection();
        Employee employee=null;
        collectionInstance.addEmployeeToCollection(employee);
    }
    
    //Test cases for sortInNaturalOrder()
    @Test
    public void testSortInNaturalOrderShouldReturnSortedList() {
        collectionInstance=new EmployeeCollection();
        collectionInstance.addEmployeeToCollection(new Employee(5,"pratiksha","udaipur"));
        collectionInstance.addEmployeeToCollection(new Employee(4,"anil","jaipur"));
        collectionInstance.addEmployeeToCollection(new Employee(7,"priya","delhi"));
        collectionInstance.addEmployeeToCollection(new Employee(3,"komal","jodhpur"));
        collectionInstance.addEmployeeToCollection(new Employee(1,"ronak","jaipur"));
        
        List<Employee> actualOutput=collectionInstance.sortInNaturalOrder();
        int[] expectedOutput={1,3,4,5,7};
        for(int i=0;i<expectedOutput.length;i++)
        {
            int actualOutputId=actualOutput.get(i).getId();
            assertEquals(expectedOutput[i],actualOutputId);
        }
    }
    
  //Test cases for sortByEmployeeName()
    @Test
    public void testSortByEmployeeNameShouldReturnSortedList() {
        collectionInstance=new EmployeeCollection();
        collectionInstance.addEmployeeToCollection(new Employee(5,"pratiksha","udaipur"));
        collectionInstance.addEmployeeToCollection(new Employee(4,"anil","jaipur"));
        collectionInstance.addEmployeeToCollection(new Employee(7,"priya","delhi"));
        collectionInstance.addEmployeeToCollection(new Employee(3,"komal","jodhpur"));
        collectionInstance.addEmployeeToCollection(new Employee(1,"ronak","jaipur"));
        
        List<Employee> actualOutput=collectionInstance.sortByEmployeeName();
        String[] expectedOutput={"anil","komal","pratiksha","priya","ronak"};
        for(int i=0;i<expectedOutput.length;i++)
        {
            String actualOutputId=actualOutput.get(i).getName();
            assertEquals(expectedOutput[i],actualOutputId);
        }
    }
    

}
