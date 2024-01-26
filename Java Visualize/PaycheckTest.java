//// part2 testing paycheck

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PaycheckTest {
    private Employee employee;
    private Paycheck paycheck;

    @Before
    public void setUp() {
        // Initialize an Employee with overtime hours and create a Paycheck from the Employee
        employee = new Employee("Jane Doe", 20.0);
        employee.addHoursWorked(45); // Includes overtime
        paycheck = new Paycheck(employee);
    }

    @Test
    public void testPaycheckFromEmployee() {
        // Verify the Paycheck is initialized correctly from an Employee object
        assertEquals("Jane Doe", paycheck.getEmployeeName()); // Ensure the name matches
        assertEquals(950.0, paycheck.getTotalPay(), 0.01); // 40 * 20 + 5 * 30 for overtime
    }

    @Test(expected = NullPointerException.class)
    public void testLoadCheckWithNullEmployee() {
        // Attempt to load a Paycheck with a null Employee and expect a NullPointerException
        Paycheck newPaycheck = new Paycheck();
        newPaycheck.loadCheck(null);
    }

    @Test
    public void testToString() {
        // Verify the toString method returns the expected string representation of the Paycheck
        String expected = String.format("Paycheck{employeeName='Jane Doe', employeeId=%d, totalPay=$950.00}", employee.getEmployeeId());
        assertEquals(expected, paycheck.toString());
    }
}
