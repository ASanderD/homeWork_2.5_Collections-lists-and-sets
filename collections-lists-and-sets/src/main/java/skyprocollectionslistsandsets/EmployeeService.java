package skyprocollectionslistsandsets;


import java.util.List;

public interface EmployeeService {

    void addEmployee(Employee employee);

    Employee removeEmployee(Employee employee);

    Employee findEmployee(Employee employee);

    List<Employee> printEmployeesInfo();
}
