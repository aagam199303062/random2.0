import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SortingElementsAlphabetically
{
    public static void main(String[] args)
    {
        ArrayList<Character> unordedList = new ArrayList<Character>();
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();

        for(int i = 0; i < word.length(); i ++)
        {
            unordedList.add(word.charAt(i));
        }
        System.out.println("Un-ordered: " + unordedList);
        Collections.sort(unordedList);
        System.out.println("Ordered: " +unordedList);
    }
}