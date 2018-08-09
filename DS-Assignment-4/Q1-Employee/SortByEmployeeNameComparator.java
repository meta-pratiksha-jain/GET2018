package employee;

import java.util.*;

public class SortByEmployeeNameComparator implements Comparator<Employee>{

    @Override
    public int compare(Employee employee1, Employee employee2) {
        String employee1Name=employee1.getName();
        String employee2Name=employee2.getName();
        int differenceOfName=employee1Name.compareTo(employee2Name);
        return differenceOfName;
    }

}
