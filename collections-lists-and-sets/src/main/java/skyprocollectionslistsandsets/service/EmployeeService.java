package skyprocollectionslistsandsets.service;


import skyprocollectionslistsandsets.employees.Employee;

import java.util.List;

public interface EmployeeService {

    void addEmployee(Employee employee);

    Employee removeEmployee(String serviceNumber);

    Employee findEmployee(String serviceNumber);

    List<Employee> printEmployeesInfo();
}
