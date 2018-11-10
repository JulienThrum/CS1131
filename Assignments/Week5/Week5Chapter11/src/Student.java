public class Student extends Person{
    private String major;

    public Student(int name, int birthYear, String major) {
        super(name, birthYear);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "major='" + major + '\'' +
                '}';
    }
}
