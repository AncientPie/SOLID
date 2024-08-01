public class SalaryCalculator {


    private EmployeeManager employeeManager;

    public SalaryCalculator(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }

    public double calculateSalary(String name) {
        return employeeManager.calculateSalary(name);
    }
}

