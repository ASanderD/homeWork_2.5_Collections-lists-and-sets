package skyprocollectionslistsandsets.controller;

import org.springframework.web.bind.annotation.*;
import skyprocollectionslistsandsets.employees.Employee;
import skyprocollectionslistsandsets.service.DepartmentAndSalaryEmployeeService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "department")

public class DepartmentAndSalaryEmployeeController {
    private final DepartmentAndSalaryEmployeeService departmentAndSalaryEmployeeService;

    public DepartmentAndSalaryEmployeeController(DepartmentAndSalaryEmployeeService departmentAndSalaryEmployeeService) {
        this.departmentAndSalaryEmployeeService = departmentAndSalaryEmployeeService;
    }

    @GetMapping(path = "{id}/employees")
    public List<Employee> findEmployeesOfDepartment(@PathVariable("id") int departmentId) {
        return departmentAndSalaryEmployeeService.findEmployeesOfDepartment(departmentId);
    }

    @GetMapping("{id}/salary/sum")
    public Double findSumSalaryOfDepartment(@PathVariable("id") int departmentId) {
        return departmentAndSalaryEmployeeService.findSumSalaryOfDepartment(departmentId);
    }

    @GetMapping(path = "{id}/salary/max")
    public Double findMaxSalaryOfDepartment(@PathVariable("id") int departmentId) {
        return departmentAndSalaryEmployeeService.findMaxSalaryOfDepartment(departmentId);
    }

    @GetMapping(path = "{id}/salary/min")
    public Double findMinSalaryOfDepartment(@PathVariable("id") int departmentId) {
        return departmentAndSalaryEmployeeService.findMinSalaryOfDepartment(departmentId);
    }

    @GetMapping(path = "/employees")
    public Map<Integer, List<Employee>> findEmployeesOfDepartments() {
        return departmentAndSalaryEmployeeService.findEmployeesOfAllDepartments();
    }

}
