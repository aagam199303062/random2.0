import java.util.Scanner;
public class JavaArea {

    private static int breadth;
    private static int lenght;

    public static  void main (String arg[]) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the lenght:");
        lenght = scanner.nextInt();
        System.out.println("Enter the Breadth: ");
        breadth = scanner.nextInt();

        System.out.println(calculateArea());
    }

    private static int calculateArea() {
        return lenght*breadth;
    }
}
