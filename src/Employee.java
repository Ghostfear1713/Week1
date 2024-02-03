import java.time.LocalDate;

public class Employee {
    private String name;
    private LocalDate birthDate;

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
