package skyprocollectionslistsandsets.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import skyprocollectionslistsandsets.employees.Employee;
import skyprocollectionslistsandsets.exceptions.DepartmentsStorageFullException;
import skyprocollectionslistsandsets.exceptions.EmployeeNotFoundException;
import skyprocollectionslistsandsets.exceptions.EmployeeStorageIsFullException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceImplTest {
    private final EmployeeServiceImpl out = new EmployeeServiceImpl();

    @BeforeEach
    public void setUp() {
        out.addEmployee("Абрамов", "Абрам", 2, 500);
        out.addEmployee("Гаврилов", "Гаврил", 2, 5000);
        out.addEmployee("Владимиров", "Владимир", 3, 50000);

    }

    @Test
    void addEmployeeCorrectTest() {
        Employee expected = new Employee(4, "Иванов", "Иван", 1, 10000);
        out.addEmployee("Иванов", "Иван", 1, 10000);
        assertThatNoException().isThrownBy(() -> out.findEmployee(4));
        assertThat(out.findEmployee(4)).isEqualTo(expected);
        assertThat(out.printEmployeesInfo()).contains(expected);
    }

    @Test
    void addEmployeeWrongDepartmentNumberTest() {
        assertThatExceptionOfType(DepartmentsStorageFullException.class).isThrownBy(() -> out.addEmployee("Иванов", "Иван", 6, 10000));
    }

    @Test
    void addEmployeeStorageIsFullTest() {
        out.addEmployee("Иванов", "Иван", 1, 10000);
        out.addEmployee("Петров", "Петр", 1, 5000);
        assertThatExceptionOfType(EmployeeStorageIsFullException.class).isThrownBy(() -> out.addEmployee("Александров", "Александр", 2, 15000));
    }

    @Test
    void removeEmployeeTest() {
        Employee expected = new Employee(4, "Иванов", "Иван", 1, 10000);
        out.addEmployee("Иванов", "Иван", 1, 10000);
        assertThat(out.printEmployeesInfo()).contains(expected);
        out.removeEmployee(4);
        assertThat(out.printEmployeesInfo()).doesNotContain(expected);
    }

    @Test
    void removeEmployeeNotFoundTest() {
        out.addEmployee("Иванов", "Иван", 1, 10000);
        out.removeEmployee(1);
        assertThatExceptionOfType(EmployeeNotFoundException.class).isThrownBy(() -> out.findEmployee(1));
        assertThatExceptionOfType(EmployeeNotFoundException.class).isThrownBy(() -> out.removeEmployee(1));
    }

    @Test
    void findEmployeeTest() {
        Employee expected = new Employee(4, "Иванов", "Иван", 1, 10000);
        out.addEmployee("Иванов", "Иван", 1, 10000);
        assertThat(out.findEmployee(4)).isEqualTo(expected);
        assertThat(out.printEmployeesInfo()).contains(expected);
    }

    @Test
    void findEmployeeNotFoundTest() {
        assertThatExceptionOfType(EmployeeNotFoundException.class).isThrownBy(() -> out.findEmployee(4));
    }

    @Test
    void printEmployeesInfoTest() {
        assertThat(out.printEmployeesInfo()).contains(
                new Employee(1, "Абрамов", "Абрам", 2, 500),
                new Employee(2, "Гаврилов", "Гаврил", 2, 5000),
                new Employee(3, "Владимиров", "Владимир", 3, 50000)
        );
    }

    @Test
    void generateIdTest() {
        int expected = 5;
        int actual = 3;
        for (int i = 0; i < 2; i++) {
            actual = out.generateId();
        }
        assertEquals(actual, expected);
    }
}
