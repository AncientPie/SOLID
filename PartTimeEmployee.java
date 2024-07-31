public class PartTimeEmployee extends Employee {
    
    public PartTimeEmployee(String name, String department) {
        super(name, department);
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException();
    }
}