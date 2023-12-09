package skyprocollectionslistsandsets.service;


import skyprocollectionslistsandsets.employees.Employee;

import java.util.Collection;
import java.util.Map;

public interface EmployeeService {

    void addEmployee(Employee employee);

    Employee removeEmployee(int id);

    Employee findEmployee(int id);

    Collection<Employee> printEmployeesInfo();

}
