package skyprocollectionslistsandsets.service;

import skyprocollectionslistsandsets.employees.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentAndSalaryEmployeeService {


    Double findSumSalaryOfDepartment(int departmentId);

    Double findMaxSalaryOfDepartment(int departmentId);


    Double findMinSalaryOfDepartment(int departmentId);

    List<Employee> findEmployeesOfDepartment(int departmentId);
    Map<Integer, List<Employee>> findEmployeesOfAllDepartments();
}
