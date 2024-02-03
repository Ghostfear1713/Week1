import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    interface ArithmeticOperation {
        int perform(int a, int b);
    }

    interface MyTransformingType{
        int transform(int input);
    }

    interface MyValidationType{
        boolean validate(int validateNumber);
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


    private static MyTransformingType doublingNumbers = x -> x*2;
    private static MyTransformingType multiplySameNumberWithItself = x -> x*x;
    private static MyValidationType divideableBy3 = x -> x % 3 == 0;
    private static MyValidationType checkIfNumberIsEven = x -> x % 2 == 0;

    public static void main(String[] args) {

//        System.out.println(operate(5, 20, addition));
//        System.out.println(doublingNumbers.transform(25));
//        System.out.println(multiplySameNumberWithItself.transform(100));
//        System.out.println(divideableBy3.validate(5));
//        System.out.println(checkIfNumberIsEven.validate(9));


        //Collection of books
        List<Book> books = new ArrayList<>(Arrays.asList(
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
        System.out.println("The average rating of all books are: " + averageRating);




        //ASSIGNMENT 3.1
        ArrayList<Integer> randomNumbers = new ArrayList<>(Arrays.asList(
                234, 567, 89, 432, 765, 123, 876, 321, 654, 98,
                789, 543, 210, 876, 345, 678, 912, 456, 789, 234));

        Predicate<Integer> isEvenWith7 = number -> number % 7 == 0;

        List<Integer> filteredListOfNumbersThatCanBeDividedBy7 = randomNumbers.stream()
                .filter(isEvenWith7)
                .collect(Collectors.toList());
        System.out.println(filteredListOfNumbersThatCanBeDividedBy7);

        //ASSIGNMENT 3.2
        //List of names
        List<String> names = Arrays.asList("John", "Jane", "Jack", "Joe", "Jill");
        //Supplier to create Employee objects based on names
        Supplier<Employee> employeeSupplier = () -> new Employee(names.get(0));

        //Create a list of Employee objects
        List<Employee> employeeList = names.stream()
                .map(name -> employeeSupplier.get())
                .collect(Collectors.toList());
        System.out.println(employeeList);


        //ASSIGNMENT 4.1
        List<LocalDate> birthDates = Arrays.asList(

        );



    }
}