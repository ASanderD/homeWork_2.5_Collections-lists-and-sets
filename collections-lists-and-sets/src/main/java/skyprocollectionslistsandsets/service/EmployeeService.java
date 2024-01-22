package skyprocollectionslistsandsets.service;


import skyprocollectionslistsandsets.employees.Employee;

import java.util.Collection;

public interface EmployeeService {

    void addEmployee(String firstName, String lastName, int departmentId, double salary);
    Employee removeEmployee(int id);

    Employee findEmployee(int id);

    Collection<Employee> printEmployeesInfo();

    int generateId();


    void checkEmployee(String string);
}
