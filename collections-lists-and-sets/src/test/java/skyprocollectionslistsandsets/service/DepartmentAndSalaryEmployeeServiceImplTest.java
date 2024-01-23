package skyprocollectionslistsandsets.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import skyprocollectionslistsandsets.employees.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentAndSalaryEmployeeServiceImplTest {

    Collection<Employee> employeesTest = List.of(

            new Employee(1, "Иванов", "Иван", 1, 1000),

            new Employee(2, "Петров", "Петр", 1, 5000),

            new Employee(3, "Сидоров", "Сидор", 1, 1000),

            new Employee(4, "Андреев", "Андрей", 1, 500),

            new Employee(5, "Александров", "Александр", 2, 1000),

            new Employee(6, "Михайлов", "Михайл", 2, 3000),

            new Employee(7, "Васильев", "Василий", 3, 1000),

            new Employee(8, "Андреев", "Андрей", 4, 1000)
    );


    @Mock
    private EmployeeService employeeService;
    @InjectMocks
    private DepartmentAndSalaryEmployeeServiceImpl departmentAndSalaryEmployeeServiceImpl;

    @BeforeEach
    public void beforeEach() {
        when(employeeService.printEmployeesInfo()).thenReturn(employeesTest);
    }

    @Test
    public void findSumSalaryOfDepartmentTest() {
        double expected = 4_000;
        assertThat(departmentAndSalaryEmployeeServiceImpl.findSumSalaryOfDepartment(2)).isEqualTo(expected);
    }

    @Test
    public void findSumSalaryOfDepartmentNegativeTest() {
        assertThat(departmentAndSalaryEmployeeServiceImpl.findSumSalaryOfDepartment(5)).isEqualTo(0);
    }

    @Test
    public void findMaxSalaryOfDepartmentTest() {
        double expected = 5_000;
        assertThat(departmentAndSalaryEmployeeServiceImpl.findMaxSalaryOfDepartment(1)).isEqualTo(expected);
    }

    @Test
    public void findMaxSalaryOfDepartmentNegativeTest() {
        assertThat(departmentAndSalaryEmployeeServiceImpl.findMaxSalaryOfDepartment(5)).isNull();
    }

    @Test
    public void findMinSalaryOfDepartmentTest() {
        double expected = 1_000;
        assertThat(departmentAndSalaryEmployeeServiceImpl.findMinSalaryOfDepartment(2)).isEqualTo(expected);
    }

    @Test
    public void findMinSalaryOfDepartmentNegativeTest() {
        assertThat(departmentAndSalaryEmployeeServiceImpl.findMinSalaryOfDepartment(5)).isNull();
    }

    @Test
    public void findEmployeesOfDepartmentTest() {
        Collection<Employee> expected = List.of(
                new Employee(5, "Александров", "Александр", 2, 1000),
                new Employee(6, "Михайлов", "Михайл", 2, 3000)
        );
        assertThat(departmentAndSalaryEmployeeServiceImpl.findEmployeesOfDepartment(2)).isEqualTo(expected);
    }

    @Test
    public void findEmployeesOfAllDepartmentsTest() {
        assertThat(departmentAndSalaryEmployeeServiceImpl.findEmployeesOfAllDepartments()).containsExactlyInAnyOrderEntriesOf(
                Map.of(
                        1, List.of(new Employee(1, "Иванов", "Иван", 1, 1000), new Employee(2, "Петров", "Петр", 1, 5000), new Employee(3, "Сидоров", "Сидор", 1, 1000), new Employee(4, "Андреев", "Андрей", 1, 500)),
                        2, List.of(new Employee(5, "Александров", "Александр", 2, 1000), new Employee(6, "Михайлов", "Михайл", 2, 3000)),
                        3, List.of(new Employee(7, "Васильев", "Василий", 3, 1000)),
                        4, List.of(new Employee(8, "Андреев", "Андрей", 4, 1000))
                ));
    }
}






