import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    //Task 1
    interface ArithmeticOperation {
        int perform(int a, int b);
    }

    //Make an operator method that takes 2 numbers and an operation function
    static int operate(int a, int b, ArithmeticOperation op) {
        return op.perform(a, b);
    }

    private static ArithmeticOperation addition = (int a, int b) -> a + b;
    private static ArithmeticOperation substraction = (int a, int b) -> a - b;
    private static ArithmeticOperation multiplication = (int a, int b) -> a * b;
    private static ArithmeticOperation division = (int a, int b) -> a / b;
    private static ArithmeticOperation modulus = (int a, int b) -> a % b;
    private static ArithmeticOperation power = (int a, int b) -> (int) Math.pow(a, b);



    interface MyTransformingType{
        int transform(int input);
    }

    interface MyValidationType{
        boolean validate(int validateNumber);
    }
    private static MyTransformingType doublingNumbers = x -> x*2;
    private static MyTransformingType multiplySameNumberWithItself = x -> x*x;
    private static MyValidationType divideableBy3 = x -> x % 3 == 0;
    private static MyValidationType checkIfNumberIsEven = x -> x % 2 == 0;

    public static void main(String[] args) {

        //TASK 1 TESTING
//        System.out.println(operate(5, 20, addition));


//        System.out.println(doublingNumbers.transform(25));
//        System.out.println(multiplySameNumberWithItself.transform(100));
//        System.out.println(divideableBy3.validate(5));
//        System.out.println(checkIfNumberIsEven.validate(9));





        /*//ASSIGNMENT 3.1
        //________________
        //TEXT: Apply the functional interfaces from the java.util.function package: Predicate, Consumer, Supplier, Function:
        //Use Predicate to filter a list of integers, so only those divisible by 7 remain.

        //We start off by making an Arraylist of Integers, called randomNumbers that will have all our numbers
        ArrayList<Integer> randomNumbers = new ArrayList<>(Arrays.asList(
                234, 567, 89, 432, 765, 123, 876, 321, 654, 98,
                789, 543, 210, 876, 345, 678, 912, 456, 789, 234));

        //Predicate takes an argument and returns a boolean - in this case, it will take a number and tell us, if that number will divide with the number 7
        Predicate<Integer> isEvenWith7 = number -> number % 7 == 0;

        List<Integer> filteredList = randomNumbers.stream()
                .filter(isEvenWith7)
                .collect(Collectors.toList());
        System.out.println(filteredList);*/

       /* //ASSIGNMENT 3.2
        //______________
        //TEXT: Use Supplier to create a list of Employee objects based on a list of names like Arrays.asList("John", "Jane", "Jack", "Joe", "Jill").

        //Supplier is basically a factory that creates something for you without taking any arguments - First we want to make a list with all of our names and then a list that holds the objects

        //List of names
        List<String> names = Arrays.asList("John", "Jane", "Jack", "Joe", "Jill");
        //Supplier to create Employee objects based on names
        //<List<Employee>> is specifying the type of object that the Supplier will supply. In this case, it's a List containing Employee objects. () ->:  indicates that the lambda function takes no parameters.
        Supplier<List<Employee>> employeeListSupplier = () -> names.stream()
                .map(Employee::new) // map(Employee::new) is telling the stream to transform each element (each name in this case) by applying the Employee constructor to it. It creates a new Employee object for each name in the stream.
                .collect(Collectors.toList()); // Collect them into a List
        //This will trigger the execution of Supplier and obtain the result of a list of Employee objects
        List<Employee> employees = employeeListSupplier.get();
        //employees.forEach(System.out::println);

        //ASSIGNMENT 3.3
        //______________
        //Use Consumer to print the list of Employee objects.
        Consumer<Employee> employeeObjectsPrinted = employee -> System.out.println(employee);
        employees.forEach(employeeObjectsPrinted);

        //ASSIGNMENT 3.4
        //______________
        //Use Function to convert a list of Employee objects to a list of names.
        Function<Employee, String> employeeToNameFunction = Employee::getName;
        List<String> employeeNames = employees.stream()
                .map(employeeToNameFunction)
                .collect(Collectors.toList());
        employees.forEach(System.out::println);

        //ASSIGNMENT 3.5
        //______________
        //Use Predicate check if a given employee is older than 18.
        Predicate<Employee> isOlderThan18 = em -> em.getAge() > 18;
        //Creating the employee we want to check age on
        Employee employee1 = new Employee("Johnny", 28);
        if(isOlderThan18.test(employee1)){
            System.out.println(employee1.getName() + " is older than 18");
        } else {
            System.out.println("The employee is not above 18");
        }*/


        /*//ASSIGNMENT 4.1 - Calculate the age of each employee based on their birthdate
        //______________________________________________________________________________

        //Firstly, we will create the employees we want to work with
        Employee e1 = new Employee("Orhani", LocalDate.of(1995, 12, 6));
        Employee e2 = new Employee("Ashkhaan", LocalDate.of(1990, 8, 25));
        Employee e3 = new Employee("Lion", LocalDate.of(1982, 11, 3));

        System.out.println(e1.calculateAge());
        System.out.println(e2.calculateAge());
        System.out.println(e3.calculateAge());*/

        /*//ASSIGNMENT 4.2 - Calculate the average age of all employees
        //___________________________________________________________
        //We'll start off with creating a list with all of the employees we made in 4.1
        List<Employee> listOfEmployeeAge = new ArrayList<>(Arrays.asList(
                new Employee("Orhani", LocalDate.of(1995, 12, 6)),
                new Employee("Ashkhaan", LocalDate.of(1990, 8, 25)),
                new Employee("Lion", LocalDate.of(1982, 11, 3))
        ));

        double averageAge = listOfEmployeeAge.stream()
                //Goes through each element in the list and gets the age
                .mapToDouble(Employee::calculateAge)
                //Finds the average of the ages in the list
                .average()
                //If nothing is found, it'll return 0.0
                .orElse(0.0);

        System.out.println(averageAge);*/

        /*//ASSIGNMENT 4.3 - Filter and display employees who have birthdays in a specific month.
        //_____________________________________________________________________________________
        //We'll start off with creating a list with all of the employees we made previously in 4.1 and 4.2
        List<Employee> listOfEmployeeAge = new ArrayList<>(Arrays.asList(
                new Employee("Orhani", LocalDate.of(1995, 12, 6)),
                new Employee("Ashkhaan", LocalDate.of(1990, 8, 25)),
                new Employee("Lion", LocalDate.of(1982, 11, 3))
        ));

        //We want to specify the target month we want to find, so we'll make a variable targetMonth for December
        int targetMonth = 12;
        List<Employee> employeesInSpecificMonth = listOfEmployeeAge.stream()
                .filter(employee -> employee.getBirthDate().getMonthValue() == targetMonth)
                .collect(Collectors.toList());

        if(!employeesInSpecificMonth.isEmpty()){
            System.out.println("Employees with days in December: ");
            employeesInSpecificMonth.forEach(employee -> System.out.println(employee.getName()));
        } else {
            System.out.println("There are no employees in that month");
        }*/

        //ASSIGNMENT 4.4 - Group employees by birth month and display the count of employees in each group.
        //_________________________________________________________________________________________________
        //We'll start of by creating our listOfEmployees again
        /*List<Employee> listOfEmployees = new ArrayList<>(Arrays.asList(
                new Employee("Orhani", LocalDate.of(1995, 12, 6)),
                new Employee("Ashkhaan", LocalDate.of(1990, 8, 25)),
                new Employee("Lion", LocalDate.of(1982, 11, 3))
        ));

        //Now we want to Map employees with a given month and count how many there is in that month
        Map<Integer, Long> employeeCount = listOfEmployees.stream()
                //
                .collect(Collectors.groupingBy(
                        //employee -> We take an employee as input and want to do something with it
                        //employee.getBirthdate(): - This part accesses the birthday of the employee. Its like saying "Get the birthday of this employee"
                        //getMonthValue() - This will get the month value from the birthdate
                        //ALL put together "Group employees by their birth month, and for each group, count how many employees share that birth month."
                        employee -> employee.getBirthDate().getMonthValue(),
                        Collectors.counting()
                ));

        //employeeCount is a map, so therefor we need 2 arguments in order to use it - Right now, we're saying that for each Integer (month) we assign that a value Long (
        employeeCount.forEach((month, count) ->
                System.out.println("Month " + month + ": " + count + " employees"));*/


        //ASSIGNMENT 4.5 - List all employees who has a birthday in the current month.
        //____________________________________________________________________________
        //We'll start of by creating our listOfEmployees again
        List<Employee> listOfEmployees = new ArrayList<>(Arrays.asList(
                new Employee("Orhani", LocalDate.of(1995, 12, 6)),
                new Employee("Ashkhaan", LocalDate.of(1990, 2, 25)),
                new Employee("Lion", LocalDate.of(1982, 11, 3))
        ));

        Month currentMonth = LocalDate.now().getMonth();

        List<Employee> employeesInCurrentMonth = listOfEmployees.stream()
                .filter(employee -> employee.getBirthDate().getMonth() == currentMonth)
                .collect(Collectors.toList());
        System.out.println("Number of Employees in Current Month: " + employeesInCurrentMonth.size());

        employeesInCurrentMonth.forEach(employee -> System.out.println(employee.getName()));



        //STREAMS API - TASK 6.1

        //Collection of books
       /* List<Book> books = new ArrayList<>(Arrays.asList(
                new Book("Harry Potter", "Author1", 2000, 300, 4.5),
                new Book("The Green Lantern", "Author2", 2010, 250, 3.8),
                new Book("Skeleton King", "Author1", 2015, 400, 4.2),
                new Book("See you next summer!", "Author3", 2005, 350, 4.0)
        ));


        //Gets the rating of all the books
        //The stream() method is applied to the list of books
        double averageRating = books.stream()
                //mapToDouble is used to extract the rating of each book (Would usually use map, but
                // since rating is a number, and every book is attached with a number (rating)
                // we need mapToDouble.
                .mapToDouble(Book::getRating)
                //average() is called to calculate the average rating
                .average()
                //If there are no ratings, orElse(0.0) is used to provide a default value of 0.0.
                .orElse(0.0);
        System.out.println("The average rating of all books are: " + averageRating);*/




    }
}