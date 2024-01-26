// Creating paycehck class from part1 

public class Paycheck {
    private String employeeName;
    private int employeeId;
    private double rate;
    private double hoursWorked;
    private double totalPay;

    public Paycheck(Employee employee) {
        if (employee == null) {
            throw new NullPointerException("Employee object cannot be null");
        }
        this.employeeName = employee.getName();
        this.employeeId = employee.getEmployeeId();
        this.rate = employee.getPayRate();
        this.hoursWorked = employee.getHoursWorked();
        calculateTotalPay();
    }

    private void calculateTotalPay() {
        if (hoursWorked <= 40) {
            totalPay = rate * hoursWorked;
        } else {
            totalPay = (40 * rate) + ((hoursWorked - 40) * rate * 1.5); // Overtime calculation
        }
    }

    public Paycheck() {
        // Empty constructor, take nothing does nothing
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public double getTotalPay() {
        return totalPay;
    }

    public void loadCheck(Employee employee) {
        if (employee == null) {
            throw new NullPointerException("Attempted a check load with a null employee object");
        }
        this.employeeName = employee.getName();
        this.employeeId = employee.getEmployeeId();
        this.rate = employee.getPayRate();
        this.hoursWorked = employee.getHoursWorked();
        calculateTotalPay();
    }

    //A toString method for BOTH classes
    @Override
    public String toString() {
        return String.format("Paycheck{employeeName='%s', employeeId=%d, totalPay=$%.2f}", employeeName, employeeId, totalPay);
    }

}
