import java.time.LocalDate;
import java.time.Period;

public class Employee {
    private String name;
    private int age;
    private LocalDate birthDate;

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Employee(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public Employee(String name, int age, LocalDate birthDate) {
        this.name = name;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee " +
                "name " + name + '\'' +
                ", age = " + age +
                ", birthDate = " + birthDate +
                '}';
    }


    public int calculateAge(){
        //This will be our current date from the PC we use
        LocalDate currentDate = LocalDate.now();
        //This will calculate the period between birthdate and current date
        Period period = Period.between(birthDate, currentDate);
        //This will return us the value from that period, giving us the age
        return period.getYears();
    }




}
