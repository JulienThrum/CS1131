public class Person{
    private int name;
    private int birthYear;

    public Person(int name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", birthYear=" + birthYear +
                '}';
    }
}
