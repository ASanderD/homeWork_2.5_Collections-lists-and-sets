package skyprocollectionslistsandsets;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service

public class EmployeeServiceImpl implements EmployeeService {
    private static final int maxEmployeeNumber = 2;
    private final List<Employee> employees = new ArrayList<>();

    @Override
    public void addEmployee(Employee employee) {
        if (employees.size() == maxEmployeeNumber) {
            throw new EmployeeStorageIsFullException();
        }
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
    }

    @Override
    public Employee removeEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee findEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public List<Employee> printEmployeesInfo() {
        return employees;
    }
}
