package skyprocollectionslistsandsets.service;

import skyprocollectionslistsandsets.employees.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentAndSalaryEmployeeService {


    Employee findMaxSalaryEmployeeOfDepartment(int departmentId);

    Employee findMinSalaryEmployeeOfDepartment(int departmentId);

    List<Employee> findEmployeesOfDepartment(int departmentId);
    Map<Integer, List<Employee>> findEmployeesOfAllDepartments();
}
