public class FullTimeEmployee implements Employee{

    String name;
    String departament;

    public FullTimeEmployee(String name, String department) {
        this.name = name;
        this.departament = department;
    }
    public String getName() {
        return name;
    }
    public String getDepartament() {
        return departament;
    }
}
