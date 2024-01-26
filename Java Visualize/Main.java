public class Main
{
   public static void main(String[] args) {
       //Create three employee objects
       Employee employee1 = new Employee("John", 20);
       Employee employee2 = new Employee("Max", 17);
       Employee employee3 = new Employee("Gary", 13.75);
       
       //Exception test 1
       Employee employee4 = new Employee("Jane", 98.78);
       Paycheck paycheck = new Paycheck();
       paycheck.loadCheck(employee4);
       
       //If these lines are in use they should throw the associated errors:
       
       //Exception in thread "main" java.lang.NullPointerException: Attempted pay generation with a null check object
    //    employee4.getWeeklyPay(null); // works
       
       //Exception in thread "main" java.lang.NullPointerException: Attempted a check load with a null employee object
    //    paycheck.loadCheck(null); // this one works for me
       
       //Exception test 2
       //If this line is in use it should throw :
       //"Exception in thread "main" java.lang.IllegalArgumentException: Invalid Pay Rate.
    //    Employee badEmployee = new Employee("Bob", -34.98); // works
       
       //Demonstrate the successful construction of the three employees
       System.out.println("Printing Employees After Construction :");
       System.out.printf(employee1 + "\n" + employee2 + "\n" +  employee3 + "\n");
       
       //Demonstrate changing the hours and pay rate fields of an employee
       employee1.addHoursWorked(50);
       
       //Exception test 3
       //If this line is in use it should throw :
       //"Exception in thread "main" java.lang.IllegalArgumentException: You cannot add negative hours.""
    //    employee1.addHoursWorked(-20); // works for me
       
       employee1.payRaise(10);
       
       //Exception test 4
       //If this line is in use it should throw :
       //"Exception in thread "main" java.lang.IllegalArgumentException: You cannot give a negative raise. Use pay cut."
    //    employee1.payRaise(-10); // works for me
       
       System.out.println("Employee 1, with 50 hours and a 10% pay raise :");
       System.out.printf(employee1 + "\n");
       
       //Demonstrate construction & printing the paychecks 
       //of the three employees
       Paycheck paycheck1 = employee1.getWeeklyPay();
       Paycheck paycheck2 = employee2.getWeeklyPay();
       Paycheck paycheck3 = employee3.getWeeklyPay();
       
       System.out.println("Employee Weekly Paychecks :");
       System.out.printf(paycheck1 + "\n\n" + paycheck2 + "\n\n" +  paycheck3 + "\n\n");
       
       //Demonstrate that the employee objects reset their hoursWorked field
       //after they called the getWeeklyPay method
       System.out.println("Employee 1 with newly reset hours :");
       System.out.printf(employee1 + "\n");
   }
}