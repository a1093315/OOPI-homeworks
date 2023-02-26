import java.util.Scanner;
import java.lang.Math;
public class A1093315_0224_2
{
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        String temp="";
        double fte=0.0;
        boolean check=false;
        while(check==false)
        {
            System.out.println("Enter the temperature(ex:123.4 degrees Fahrenheit)");
            System.out.print("*the number you entered will be round up to two decimal places:");
            temp=input.next();
            try
            {
                fte=Double.valueOf(temp);
                check=true;
            }
            catch(NumberFormatException e)
            {
                System.out.println("Invalid input.Please enter another number.");
            }
        }
        fte=(double)(Math.round(fte*100))/100;
        double cte=(fte-32)*5/9;
        System.out.printf("%.2f degrees Fahrenheit equals about %.2f degrees Celsius.\n", fte, cte);
    }
}