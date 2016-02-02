public class P1LoopEven
{
  public static void main(String[] args)
  {
    int integers = 0;

    for(int i = 1; i<41;i++)
    {
      if ((i % 2)==0)
      {
        integers += i;
      }
    }
    System.out.print("The total sum of even integers from 1 to 40 is: ");
    System.out.println(integers);
  }
}
