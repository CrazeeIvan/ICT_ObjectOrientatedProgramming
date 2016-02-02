import java.util.Scanner;

public class P2Average {
  public static void main(String[] args)
  {
    Scanner input = new Scanner (System.in);

    int averageSales = 0;

    System.out.println("Please enter your sales figures for this week. ");
    System.out.print("Please enter your sales figures for Monday: ");
    averageSales += input.nextInt();
    System.out.print("Please enter your sales figures for Tuesday: ");
    averageSales += input.nextInt();
    System.out.print("Please enter your sales figures for Wednesday: ");
    averageSales += input.nextInt();
    System.out.print("Please enter your sales figures for Thursday: ");
    averageSales += input.nextInt();
    System.out.print("Please enter your sales figures for Friday: ");
    averageSales += input.nextInt();
    averageSales = averageSales /5;
    System.out.printf("Your Average sales for this week was %d.\n", averageSales);

  }
}
