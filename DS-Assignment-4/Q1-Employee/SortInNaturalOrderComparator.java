package employee;

import java.util.*;

public class SortInNaturalOrderComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee employee1, Employee employee2) {
        int employee1Id=employee1.getId();
        int employee2Id=employee2.getId();
        int differenceOfId=employee1Id-employee2Id;
        return differenceOfId;
    }

}
