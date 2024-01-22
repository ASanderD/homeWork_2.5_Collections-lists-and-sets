package skyprocollectionslistsandsets.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import skyprocollectionslistsandsets.employees.Employee;
import skyprocollectionslistsandsets.exceptions.*;

import java.util.*;

@Service

public class EmployeeServiceImpl implements EmployeeService {
    private static final int maxEmployeeNumber = 5;
    private static final int maxDepartmentNumber = 5;
    private int countId = 1;

    private final Map<Integer, Employee> employees = new HashMap<>();

    @Override
    public void addEmployee(String firstName, String lastName, int departmentId, double salary) {
        checkEmployee(firstName.toLowerCase());
        checkEmployee(lastName.toLowerCase());

        if (employees.size() == maxEmployeeNumber) {
            throw new EmployeeStorageIsFullException();
        }
        int key = countId++;
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (departmentId > maxDepartmentNumber) {
            throw new DepartmentsStorageFullException();
        }
        employees.put(key, new Employee(key, firstName, lastName, departmentId, salary));
    }

    @Override
    public Employee removeEmployee(int id) {
        Employee employee = employees.get(id);
        if (!employees.containsKey(id)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee.getId(), employee);
        return employee;
    }

    @Override
    public Employee findEmployee(int id) {
        final Employee employee = employees.get(id);
        if (!employees.containsKey(id)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Collection<Employee> printEmployeesInfo() {
        return Collections.unmodifiableCollection(employees.values());
    }

    @Override
    public int generateId() {
        return countId++;
    }

    @Override
    public void checkEmployee(String string) {
        if (!StringUtils.isAlpha(string)) {
            throw new EmployeeBadRequestException();
        }
        StringUtils.capitalize(string);
    }
}