import java.util.Scanner;

public class P5Pension
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner (System.in);

    int age;

    System.out.println("Please enter your age.");
    age = input.nextInt();
    if (age >= 65)
    {
      System.out.print("You are eligible for a pension! ");
    }
  }
}
