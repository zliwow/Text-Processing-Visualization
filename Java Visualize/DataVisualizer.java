import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DataVisualizer {

    public static void displayData(Employee[] employees) {
        // Create the frame
        JFrame frame = new JFrame("Employee Payroll Data");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Column Names
        String[] columnNames = {"Employee Name", "Employee ID", "Pay Rate", "Hours Worked", "Total Pay"};

        // Using DefaultTableModel to hold table data
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Fill the model with data
        for (Employee employee : employees) {
            Paycheck paycheck = employee.getWeeklyPay();
            Object[] row = new Object[5];
            row[0] = employee.getName();
            row[1] = employee.getEmployeeId();
            row[2] = employee.getPayRate();
            row[3] = employee.getHoursWorked();
            row[4] = paycheck.getTotalPay();
            model.addRow(row);
        }

        // Create the table
        JTable table = new JTable(model);

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);

        // Display the frame
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Example employees array
        Employee[] employees = {
            new Employee("John", 20),
            new Employee("Max", 17),
            new Employee("Gary", 13.75)
        };

        // Add some hours to simulate payroll data
        employees[0].addHoursWorked(40);
        employees[1].addHoursWorked(45); // Includes overtime
        employees[2].addHoursWorked(30);

        // Display the data
        displayData(employees);
    }
}
