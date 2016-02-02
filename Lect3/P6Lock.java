public class P6Lock
{
  public static void main(String[] args)
  {
    System.out.println("This program prints out all possible combinations for a 3-digit combination lock, where the numbers range from 0 to 36.");

    for(int i = 0; i<=36;i++)
    {
      for(int j = 0; j<=36;j++)
      {
        for(int k = 0; k<=36;k++)
        {
          System.out.printf("%d, %d, %d\n\r", i, j, k);
        }
      }
    }
  }
}
