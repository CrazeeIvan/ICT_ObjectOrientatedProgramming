import java.util.Scanner;

public class P3LoopRange
{
  public static void main(String [] args)
  {
    Scanner input = new Scanner (System.in);
    int firstNum = 0;
    int secondNum = 0;
    int total = 0;

    System.out.println("This program will calculate the total of all even numbers between two values.");
    System.out.print("Please enter the first number: ");
    firstNum = input.nextInt();
    System.out.print("Please enter the second number: ");
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
