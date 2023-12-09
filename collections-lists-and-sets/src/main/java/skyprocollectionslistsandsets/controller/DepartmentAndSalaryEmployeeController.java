package skyprocollectionslistsandsets.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import skyprocollectionslistsandsets.employees.Employee;
import skyprocollectionslistsandsets.service.DepartmentAndSalaryEmployeeService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "employee/departments")

public class DepartmentAndSalaryEmployeeController {
    private final DepartmentAndSalaryEmployeeService departmentAndSalaryEmployeeService;

    public DepartmentAndSalaryEmployeeController(DepartmentAndSalaryEmployeeService departmentAndSalaryEmployeeService) {
        this.departmentAndSalaryEmployeeService = departmentAndSalaryEmployeeService;
    }

    @GetMapping(path = "/max-salary")
    public Employee findMaxSalaryEmployeeOfDepartment(@RequestParam("departmentId") int departmentId) {
        return departmentAndSalaryEmployeeService.findMaxSalaryEmployeeOfDepartment(departmentId);
    }

    @GetMapping(path = "/min-salary")
    public Employee findMinSalaryEmployeeOfDepartment(@RequestParam("departmentId") int departmentId) {
        return departmentAndSalaryEmployeeService.findMinSalaryEmployeeOfDepartment(departmentId);
    }
    @GetMapping(path = "/all", params = "departmentId")
    public List<Employee> findEmployeesOfDepartment(@RequestParam("departmentId") int departmentId) {
        return departmentAndSalaryEmployeeService.findEmployeesOfDepartment(departmentId);
    }

    @GetMapping(path = "/all")
    public Map<Integer,List<Employee>> findEmployeesOfDepartments() {
        return departmentAndSalaryEmployeeService.findEmployeesOfAllDepartments();
    }

}
