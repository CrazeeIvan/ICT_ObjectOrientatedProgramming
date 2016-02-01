import java.util.Scanner;

public class P4Student {
  public static void main(String[] args)
  {
    Scanner input = new Scanner (System.in);

    int groupA;
    int groupB;
    int total;

    System.out.println("Please enter the total students in Group A.");
    groupA = input.nextInt();
    System.out.println("Please enter the total students in Group B.");
    groupB = input.nextInt();
    total = groupA + groupB;
    System.out.printf("The total number of students is: %d", total);
  }
}
