package skyprocollectionslistsandsets.service;

import org.springframework.stereotype.Service;
import skyprocollectionslistsandsets.employees.Employee;
import skyprocollectionslistsandsets.exceptions.EmployeeAlreadyAddedException;
import skyprocollectionslistsandsets.exceptions.EmployeeNotFoundException;
import skyprocollectionslistsandsets.exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service

public class EmployeeServiceImpl implements EmployeeService {
    private static final int maxEmployeeNumber = 5;

    private final Map<String, Employee> employees = new HashMap<>();

    @Override
    public void addEmployee(Employee employee) {
        if (employees.size() == maxEmployeeNumber) {
            throw new EmployeeStorageIsFullException();
        }
        if (employees.containsKey(employee.getServiceNumber())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getServiceNumber(), employee);
    }

    @Override
    public Employee removeEmployee(String serviceNumber) {
        Employee employee = employees.get(serviceNumber);
        if (!employees.containsKey(serviceNumber)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee.getServiceNumber(), employee);
        return employee;
    }

    @Override
    public Employee findEmployee(String serviceNumber) {
        final Employee employee = employees.get(serviceNumber);
        if (!employees.containsKey(serviceNumber)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public List<Employee> printEmployeesInfo() {
        return new ArrayList<>(employees.values());
    }
}
