public class PartTimeEmployee implements Employee {
    String departament;

    public PartTimeEmployee( String department) {
        this.departament = department;
    }
    public String getDepartament() {
        return departament;
    }
}