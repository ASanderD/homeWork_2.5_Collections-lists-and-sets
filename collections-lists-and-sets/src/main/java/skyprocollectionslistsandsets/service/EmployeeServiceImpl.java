package skyprocollectionslistsandsets.service;

import org.springframework.stereotype.Service;
import skyprocollectionslistsandsets.employees.Employee;
import skyprocollectionslistsandsets.exceptions.DepartmentsStorageFullException;
import skyprocollectionslistsandsets.exceptions.EmployeeAlreadyAddedException;
import skyprocollectionslistsandsets.exceptions.EmployeeNotFoundException;
import skyprocollectionslistsandsets.exceptions.EmployeeStorageIsFullException;

import java.util.*;

@Service

public class EmployeeServiceImpl implements EmployeeService {
    private static final int maxEmployeeNumber = 20;
    private static final int maxDepartmentNumber = 5;
    private int countId = 1;

    private final Map<Integer, Employee> employees = new HashMap<>();

    @Override
    public void addEmployee(Employee employee) {
        if (employees.size() == maxEmployeeNumber) {
            throw new EmployeeStorageIsFullException();
        }
        if (employees.containsKey(employee.getId())) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employee.getDepartmentId() > maxDepartmentNumber) {
            throw new DepartmentsStorageFullException();
        }
        employees.put(employee.getId(), employee);
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
}
