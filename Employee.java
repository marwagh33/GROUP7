
/**
 * Write a description of class Employee here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Employee
{   // TODO: Add private attributes here
    private String employeeId;
    private String fullName;
    private String department;
    private double basicSalary;
    private int yearsOfService;
    
     // TODO: Add default constructor
    private Employee(){
        this.employeeId = " ";
        this.fullName = " ";
        this.department = " ";
        this.basicSalary = 500000;
        this.yearsOfService = 0;
    }
    
    // TODO: Add parameterized constructor
    private Employee(String employeeId, String fullName, String department, double basicSalary,int yearsOfService){
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.department = department;
        this.basicSalary = basicSalary;
        this.yearsOfService = yearsOfService;
    }
    
    // TODO: Add getters
    public String getemployeeId(){
        return employeeId;
    }
    public String getfullName(){
        return fullName;
    }
    public String getdepartment(){
        return department;
    }
    public double getbasicSalary(){
        return basicSalary;
    }
    public int getyearsOfService(){
        return yearsOfService;
    }
    
    
    // TODO: Add setters with validation
    public void setbasicSalary(double basicSalary){
        if(basicSalary >= 500000){
            this.basicSalary=basicSalary;
        }
        else{
            System.out.println("Salary must be least 500,000");
        }
    }
    public void setyearsOfService(int yearsOfServices){
        if (yearsOfService >= 0){
            this.yearsOfService=yearsOfService;
        }
        else{
            System.out.println("Years of service cannot be negative");
            
        }
    }
    
    
     // TODO: Add calculateBonus() method
    public double calculateBonus() {
        double bonusPercentage = Math.min(yearsOfService * 0.10, 0.50);
        return basicSalary * bonusPercentage;
    }
    
    // TODO: Add calculateNetSalary() method
    public double calculateNetSalary() {
        double gross = basicSalary + calculateBonus();
        double tax = gross * 0.15;
        return gross - tax;
    }
    
     // TODO: Add promote() method
    public void promote(String newDepartment, double salaryIncrease) {
        this.department = newDepartment;
        setbasicSalary(this.basicSalary + salaryIncrease);
    }
    
     // TODO: Add displayPayslip() method
    public void displayPayslip() {
        System.out.println("====================================");
        System.out.println("Employee ID   : " + employeeId);
        System.out.println("Full Name     : " + fullName);
        System.out.println("Department    : " + department);
        System.out.println("Basic Salary  : " + basicSalary);
        System.out.println("Years of Service : " + yearsOfService);
        System.out.println("Bonus         : " + calculateBonus());
        System.out.println("Net Salary    : " + calculateNetSalary());
        System.out.println("====================================\n");
    }
    
     // TODO: Create employee1 - "EMP001", "Ali Hassan", "IT", 1500000
    // TODO: Create employee2 - "EMP002", "Fatma Said", "HR", 1200000
    public static void main(String[] args) {
        Employee emp1 = new Employee("E001", "Ali Hassan", "IT", 600000,5);
        Employee emp2 = new Employee("E002", "Fatma said", "HR", 600000,6);
        
         // TODO: Display payslip for both employees
        System.out.println("Initial Payslip:");
        emp1.displayPayslip();
        
        // TODO: Promote employee1 to "Senior IT" with 300000 salary increase
        emp1.promote("Senior IT", 300000);
        
        emp1.setyearsOfService(6);
        
        // TODO: Display employee1 payslip after promotion
        System.out.println("Payslip after Promotion and Service Update:");
        emp1.displayPayslip();
        
        System.out.println("\n=== Exercise Complete ===");
    }
}      
        
        
        
        
    