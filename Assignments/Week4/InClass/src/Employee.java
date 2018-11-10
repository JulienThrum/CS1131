public class Employee extends Person{

    public Employee(String name, int age) {
        super(name, age);
    }

    public static void main(String[] args) {
        Employee employee = new Employee("Leo Ureel", 137);
        System.out.println(employee.getName());
    }
}
