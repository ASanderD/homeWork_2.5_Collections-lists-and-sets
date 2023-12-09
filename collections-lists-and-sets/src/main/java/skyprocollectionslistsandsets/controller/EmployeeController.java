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
    public Employee addEmployee(@RequestParam("id") Integer id,
                                @RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastname,
                                @RequestParam("departmentId")Integer departmentId,
                                @RequestParam("salary")double salary) {
        Employee employee = new Employee(
                id,
                firstName,
                lastname,
                departmentId,
                salary);
        employeeService.addEmployee(employee);
        return employee;
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
