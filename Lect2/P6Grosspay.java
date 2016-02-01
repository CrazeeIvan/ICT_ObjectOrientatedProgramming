import java.util.Scanner;

public class P6Grosspay {
  public static void main(String[] args)
  {
    Scanner input = new Scanner (System.in);

    double hourlyRate;
    double numOfHours;
    double grossPay;

    System.out.println("Input the hourly rate in euros.");
    hourlyRate = input.nextDouble();
    System.out.println("Input the number of hours worked.");
    numOfHours = input.nextDouble();
    grossPay = hourlyRate * numOfHours;
    System.out.printf("The gross pay is: %.2f.\n", grossPay);
    System.out.println(51 % 4 * 37 + 4 % 12 + 4);
  }
}
