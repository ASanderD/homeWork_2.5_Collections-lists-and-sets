package skyprocollectionslistsandsets.employees;


import java.util.Objects;

public class Employee {
    private String serviceNumber;
    private String firstName;
    private String lastName;

    public Employee(String serviceNumber, String firstName, String lastName) {
        this.serviceNumber = serviceNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public Employee() {
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getServiceNumber() {
        return serviceNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
