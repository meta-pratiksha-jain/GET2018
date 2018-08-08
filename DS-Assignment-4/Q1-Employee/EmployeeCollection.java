package employee;

import java.util.*;

/**
 * This class represents employee collection.
 * An employee should have unique id.
 */
public class EmployeeCollection {
    private List<Employee> listOfEmployee;
    
    /**
     * constructor
     */
    public EmployeeCollection()
    {
        listOfEmployee=new ArrayList<Employee>();
    }
    
    /**
     * add an employee in collection if employee has unique id.
     * @param newEmployee
     * @return returns true if employee is added to collection otherwise false.
     */
    public boolean addEmployeeToCollection(Employee newEmployee)
    {
        boolean isAdded=false;
        if(newEmployee==null)
        {
            throw new AssertionError("Employee is null");
        }
        int newEmployeeId=newEmployee.getId();
        for(Employee employee:listOfEmployee)
        {
            int currentEmployeeId=employee.getId();
            if(newEmployeeId==currentEmployeeId)
            {
                return isAdded;
            }
        }
        listOfEmployee.add(newEmployee);
        isAdded=true;
        return isAdded;
    }
    
    /**
     * sorts employee list in natural order.
     * Natural ordering is based on employee id.
     * @return returns sorted list of employee.
     */
    public List<Employee> sortInNaturalOrder()
    {
        SortInNaturalOrderComparator comparatorInstance=new SortInNaturalOrderComparator();
        Collections.sort(listOfEmployee, comparatorInstance);
        return listOfEmployee;
    }
    
    /**
     * sorts employee list based on employee name.
     * @return returns sorted list of employee.
     */
    public List<Employee> sortByEmployeeName()
    {
        SortByEmployeeNameComparator comparatorInstance=new SortByEmployeeNameComparator();
        Collections.sort(listOfEmployee, comparatorInstance);
        return listOfEmployee;
    }

}
