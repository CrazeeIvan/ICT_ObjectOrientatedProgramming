import java.util.Scanner;

public class P3Greeting {
  public static void main(String[] args)
  {
    Scanner input = new Scanner (System.in);

    String userName;

    System.out.println("Please enter your name: ");
    userName = input.nextLine();
    System.out.println("Hello " + userName + ". How are you today? o/\n");
  }
}
