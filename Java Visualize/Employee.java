// Creating employee class from part1 

public class Employee {
    private static int EmployeeNum = 0; // Track the number of employees using static

    private String name;
    private double workingHours; // Double to accommodate half hours
    private int employeeID;
    private double pay; // For calculating overtime pay

    public Employee(String name, double pay) {
        // Code added after reading driver, pay check added here to detect negative pay rate
        if (pay < 0) {
            throw new IllegalArgumentException("Invalid Pay Rate.");
        }

        this.name = name;
        this.pay = pay;
        this.workingHours = 0; // Initialize to 0
        this.employeeID = ++EmployeeNum; // Assign ID based on the number of employees
    }

    public void addHoursWorked(double hours) {
        if (hours < 0) {
            throw new IllegalArgumentException("Hours cannot be negative");
        }
        this.workingHours += hours;
    }

    public void resetHourWorked() {
        this.workingHours = 0;
    }

    public Paycheck getWeeklyPay() {
        Paycheck paycheck = new Paycheck(this); // Use the Employee-based constructor
        resetHourWorked(); // Reset hours after generating the paycheck
        return paycheck;
    }

     // Making two getWeeklyPay here becasue trying to accompany the driver code. checks for null, and updates it
     public Paycheck getWeeklyPay(Paycheck paycheck) {
        if (paycheck == null) {
            throw new NullPointerException("Attempted pay generation with a null check object");
        }
        paycheck.loadCheck(this); // Update the provided Paycheck
        resetHourWorked(); // Reset hours worked to 0
        return paycheck;
    }

    public void payRaise(double percentage) {
        if (percentage < 0) {
            throw new IllegalArgumentException("Pay raise percentage cannot be negative");
        }
        this.pay *= (1 + percentage / 100);
    }

    public static int getNumEmployees() {
        return EmployeeNum;
    }

    // Getters for Paycheck class to use
    public String getName() {
        return name;
    }

    public int getEmployeeId() {
        return employeeID;
    }

    public double getPayRate() {
        return pay;
    }

    public double getHoursWorked() {
        return workingHours;
    }
    //A toString method for BOTH classes
    @Override
    public String toString() {
        return String.format("Employee{name='%s', id=%d, payRate=%.2f}", name, employeeID, pay);
    }
}
