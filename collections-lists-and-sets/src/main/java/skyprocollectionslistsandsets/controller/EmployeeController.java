package skyprocollectionslistsandsets.controller;

import org.springframework.web.bind.annotation.*;
import skyprocollectionslistsandsets.employees.Employee;
import skyprocollectionslistsandsets.service.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping(path = "/employee")


public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public void addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("departmentId") Integer departmentId,
                                @RequestParam("salary") double salary) {

        employeeService.addEmployee(firstName, lastName, departmentId, salary);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam("id") Integer id) {

        return employeeService.removeEmployee(id);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam("id") Integer id) {
        return employeeService.findEmployee(id);
    }

    @GetMapping(path = "/allEmployees")
    public Collection<Employee> printEmployeesInfo() {
        return employeeService.printEmployeesInfo();
    }
}
