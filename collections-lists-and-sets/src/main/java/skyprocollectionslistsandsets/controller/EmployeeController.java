package skyprocollectionslistsandsets.controller;

import org.springframework.web.bind.annotation.*;
import skyprocollectionslistsandsets.employees.Employee;
import skyprocollectionslistsandsets.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")


public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam("serviceNumber") String serviceNumber,
                                @RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastname
    ) {
        Employee employee = new Employee(
                serviceNumber,
                firstName,
                lastname
        );
        employeeService.addEmployee(employee);
        return employee;
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam("serviceNumber") String serviceNumber) {

        return employeeService.removeEmployee(serviceNumber);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam("serviceNumber") String serviceNumber) {
        return employeeService.findEmployee(serviceNumber);
    }

    @GetMapping(path = "/allEmployees")
    public List<Employee> printEmployeesInfo() {
        return employeeService.printEmployeesInfo();
    }
}
