package skyprocollectionslistsandsets.service;

import org.springframework.stereotype.Service;
import skyprocollectionslistsandsets.employees.Employee;
import skyprocollectionslistsandsets.exceptions.EmployeeNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentAndSalaryEmployeeServiceImpl implements DepartmentAndSalaryEmployeeService {
    private final EmployeeService employeeService;

    public DepartmentAndSalaryEmployeeServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findMaxSalaryEmployeeOfDepartment(int departmentId) { // Получить в качестве параметра номер отдела (1–5) и найти сотрудника с максимальной зарплатой
        return employeeService.printEmployeesInfo().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);

    }

    @Override
    public Employee findMinSalaryEmployeeOfDepartment(int departmentId) { // Получить в качестве параметра номер отдела (1–5) и найти сотрудника с минимальной зарплатой
        return employeeService.printEmployeesInfo().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public List<Employee> findEmployeesOfDepartment(int departmentId) {
        return employeeService.printEmployeesInfo().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> findEmployeesOfAllDepartments() {
        return employeeService.printEmployeesInfo().stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }
}
