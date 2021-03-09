package comm.example;

import java.util.Comparator;

public class SalaryComparator implements Comparator {
    @Override
    public int compare(Object o, Object t1) {
        Employee employee1=(Employee) o;
        Employee employee2=(Employee) t1;
        if(employee1.getSalary()==employee2.getSalary())
        {
            return 0;
        }
        else if (employee1.getSalary()<employee2.getSalary())
            return 1;
        else
            return -1;

    }
}
