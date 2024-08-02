public class SalaryCalculator {
    private SalaryManager salaryManager;

    public SalaryCalculator(SalaryManager salaryManager) {
        this.salaryManager = salaryManager;
    }

    public double calculateSalary(String name) {
        return salaryManager.calculateSalary(name);
    }
}

