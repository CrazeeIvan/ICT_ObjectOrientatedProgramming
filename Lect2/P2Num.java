import java.util.Scanner;

public class P2Num {
  public static void main(String[] args)
  {
    Scanner input = new Scanner (System.in);

    int userNumber;

    System.out.println("Please enter a number: ");
    userNumber = input.nextInt();
    System.out.printf("Your number was %d.\n", userNumber);

  }
}
