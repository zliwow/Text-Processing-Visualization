// part2 testing employee

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EmployeeTest {
    private Employee employee;

    @Before
    public void setUp() {
        // Initialize an Employee object before each test
        employee = new Employee("John Doe", 25.0);
    }

    @Test
    public void testEmployeeInitialization() {
        // Verify that the Employee object is initialized with the correct name and pay rate
        assertEquals("John Doe", employee.getName());
        assertEquals(25.0, employee.getPayRate(), 0.01);
        // Verify that the hours worked are initialized to 0
        assertEquals(0, employee.getHoursWorked(), 0.01);
    }

    @Test
    public void testAddHoursWorked() {
        // Add hours to the Employee and verify the hours worked is updated correctly
        employee.addHoursWorked(8);
        assertEquals(8, employee.getHoursWorked(), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNegativeHoursWorked() {
        // Attempt to add negative hours and expect an IllegalArgumentException
        employee.addHoursWorked(-5);
    }

    @Test
    public void testResetHoursWorked() {
        // Add hours, then reset and verify that hours worked is reset to 0
        employee.addHoursWorked(10);
        employee.resetHourWorked();
        assertEquals(0, employee.getHoursWorked(), 0.01);
    }

    @Test
    public void testGetWeeklyPay() {
        // Add hours, get weekly pay, and verify the Paycheck object is created correctly
        employee.addHoursWorked(40);
        Paycheck paycheck = employee.getWeeklyPay();
        assertNotNull(paycheck);
        // Verify hours are reset after generating the paycheck
        assertEquals(0, employee.getHoursWorked(), 0.01);
    }

    @Test
    public void testPayRaise() {
        // Apply a pay raise and verify the pay rate is updated correctly
        employee.payRaise(10); // 10% raise
        assertEquals(27.5, employee.getPayRate(), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativePayRaise() {
        // Attempt to apply a negative pay raise and expect an IllegalArgumentException
        employee.payRaise(-10);
    }

    @Test
    public void testToString() {
        // Verify the toString method returns the expected string representation
        String expected = "Employee{name='John Doe', id=7, payRate=25.00}";
        assertEquals(expected, employee.toString());
    }
}
