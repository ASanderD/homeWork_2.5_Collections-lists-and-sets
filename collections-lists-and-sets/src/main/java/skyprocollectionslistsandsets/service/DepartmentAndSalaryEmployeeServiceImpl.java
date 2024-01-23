package skyprocollectionslistsandsets.service;

import org.springframework.stereotype.Service;
import skyprocollectionslistsandsets.employees.Employee;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentAndSalaryEmployeeServiceImpl implements DepartmentAndSalaryEmployeeService {
    private final EmployeeService employeeService;

    public DepartmentAndSalaryEmployeeServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @Override
    public Double findSumSalaryOfDepartment(int departmentId) { // Получить в качестве параметра номер отдела (1–5) и найти сотрудника с минимальной зарплатой
        return employeeService.printEmployeesInfo().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .mapToDouble(Employee::getSalary)
                .sum();
    }
    @Override
    public Double findMaxSalaryOfDepartment(int departmentId) { // Получить в качестве параметра номер отдела (1–5) и найти сотрудника с максимальной зарплатой
        return employeeService.printEmployeesInfo().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .map(Employee::getSalary)
                .max(Double::compareTo)
                .orElse(null);

    }

    @Override
    public Double findMinSalaryOfDepartment(int departmentId) { // Получить в качестве параметра номер отдела (1–5) и найти сотрудника с минимальной зарплатой
        return employeeService.printEmployeesInfo().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .map(Employee::getSalary)
                .min(Double::compareTo)
                .orElse(null);
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
