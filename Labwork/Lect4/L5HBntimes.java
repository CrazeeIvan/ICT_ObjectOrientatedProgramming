import java.util.Scanner;

public class L5HB
{
  public static void main (String[] args)
  {
    Scanner input = new Scanner (System.in);

    String name;
    int age;

    System.out.println("This program prints out Happy Birthday to a person you select, ");
    System.out.println("as many times as you want!");
    System.out.print("\nWho would you like to wish Happy Birthday to? ");
    name = input.nextLine();

    System.out.printf("What age is %s?", name);
    age = input.nextInt();
    happyBirthday(name, age);
  }
  public static void happyBirthday(String x, int y)
  {
    for(int i = y;i>0;i--)
    {
      System.out.printf("%d: Happy Birthday, to %s!\n", i, x);
    }
    return;
  }
}
