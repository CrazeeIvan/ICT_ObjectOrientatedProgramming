import java.util.Scanner;

public class L5SmallNum
{
  public static void main (String[] args)
  {
    Scanner input = new Scanner (System.in);

    int number1;
    int number2;

    System.out.println("This program calculates the smallest of two values entered by the user: ");
    System.out.print("Enter first integer: ");
    number1 = input.nextInt();

    System.out.print("Enter second integer: ");
    number2 = input.nextInt();

    System.out.printf("The smallest of the two values (%d and %d) you have entered is: %d", number1, number2, minimumValue(number1, number2));
  }
  public static int minimumValue(int x, int y)
  {
    if (x>y)
    {
      return y;
    }
    else if (y>x)
    {
      return x;
    }
    else if (y==x)
    {
      return 0;
    }
    else
    {
      System.out.println("Program error.");
      return -1;
    }
  }
}
