import java.util.Scanner;

public class P7DieselCheck
{
  public static void main(String [] args)
  {
    Scanner input = new Scanner (System.in);
    int totalMiles = 0;
    int secondNum = 0;
    int total = 0;

    System.out.println("This program will calculate and display the miles per gallon obtained from a tankful of diesel.");
    System.out.print("Please enter total miles driven. (or -1 to end) ");
    totalMiles = input.nextInt();
    System.out.print("Please enter total gallons used. (or -1 to end) ");
    secondNum = input.nextInt();

    for(int i = firstNum; i<=secondNum;i++)
    {
      if ((i % 2)==0)
      {
        total += i;
      }
    }
    System.out.printf("The total of all even numbers between %d and %d, is %d", firstNum, secondNum, total);
  }
}
