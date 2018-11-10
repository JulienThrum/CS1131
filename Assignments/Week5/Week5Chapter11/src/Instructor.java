public class Instructor extends Person{
    private double salary;

    public Instructor(int name, int birthYear, double salary) {
        super(name, birthYear);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "salary=" + salary +
                '}';
    }
}
