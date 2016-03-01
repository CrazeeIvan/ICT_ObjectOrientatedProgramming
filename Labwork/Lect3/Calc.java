import java.util.Scanner;

public class Calc
{
  public static void main (String[] args)
  {
    Scanner input = new Scanner (System.in);

    int number1;
    int number2;
    char operator;
    int total;

    System.out.println("Use 1-4 to select the required operation ");
    System.out.println("1. Addition + ");
    System.out.println("2. Subtraction - ");
    System.out.println("3. Multiplication * ");
    System.out.println("4. Division / ");
    operator = input.nextLine().charAt(0);

    if (operator == '1')
    {
      System.out.println("Beginning addition ");
      System.out.print("Enter first integer: ");
      number1 = input.nextInt();
      System.out.print("Enter second integer: ");
      number2 = input.nextInt();
      total = number1 + number2;
      System.out.printf("%d plus %d is %d\n", number1, number2, total);
    }
    if (operator == '2')
    {
      System.out.println("Beginning subtraction ");
      System.out.print("Enter first integer: ");
      number1 = input.nextInt();
      System.out.print("Enter second integer: ");
      number2 = input.nextInt();
      total = number1 - number2;
      System.out.printf("%d minus %d is %d\n", number1, number2, total);
    }
    if (operator == '3')
    {
      System.out.println("Beginning multiplication ");
      System.out.print("Enter first integer: ");
      number1 = input.nextInt();
      System.out.print("Enter second integer: ");
      number2 = input.nextInt();
      total = number1 * number2;
      System.out.printf("%d multiplied by %d is %d\n", number1, number2, total);
    }
    if (operator == '4')
    {
      System.out.println("Beginning Division ");
      System.out.print("Enter first integer: ");
      number1 = input.nextInt();
      System.out.print("Enter second integer: ");
      number2 = input.nextInt();
      if (number2==0)
      {
        System.out.print("Cannot divide by zero, please enter a new second integer: ");
        number2 = input.nextInt();
      }
      total = number1 / number2;
      System.out.printf("%d divided by %d is %d\n", number1, number2, total);
    }
  }
}
