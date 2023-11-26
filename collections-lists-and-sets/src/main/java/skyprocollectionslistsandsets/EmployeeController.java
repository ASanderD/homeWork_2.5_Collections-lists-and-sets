package skyprocollectionslistsandsets;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")

public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastname
    ) {
        Employee employee = new Employee(
                firstName,
                lastname
        );
        employeeService.addEmployee(employee);
        return employee;
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastname
    ) {
        Employee employee = new Employee(
                firstName,
                lastname
        );
        employeeService.removeEmployee(employee);
        return employee;
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastname
    ) {
        Employee employee = new Employee(
                firstName,
                lastname
        );

        return employeeService.findEmployee(employee);
    }

    @GetMapping(path = "/allEmployees")
    public List<Employee> printEmployeesInfo() {
        return employeeService.printEmployeesInfo();
    }
}
