import java.util.Scanner;
public class A1093315_0224_1
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String temp="";
        int num=0;
        boolean check=false;
        while(check==false)
        {
            System.out.print("Enter a number to judge\nif it's an odd or an even number:");
            temp=input.next();
            try
            {
                num=Integer.valueOf(temp);
                check=true;
            }
            catch(NumberFormatException e)
            {
                System.out.println("Invalid input.Please enter an integer.");
            }
        }
        String kind= num%2!=0 ? "odd" : "even" ;
        System.out.printf("%d is an %s number.\n",num,kind);
    }
}