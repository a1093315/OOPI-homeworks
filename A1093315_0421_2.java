import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class A1093315_0421_2
{
    public static void main(String[] args)
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter the date with one of the following format:");
        System.out.println("1. YYYY/MM/DD   2. MM/DD/YYYY");
        System.out.print("Enter date here: ");
        String str = "";
        try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                System.out.println("An error occurred while reading input.");
            }
        while(!str.matches("^[1-9]\\d{3}/(0?[1-9]|1[0-2])/(0?[1-9]|[12]\\d|3[01])$") && !str.matches("^(0?[1-9]|1[0-2])/(0?[1-9]|[12]\\d|3[01])/[1-9]\\d{3}$"))
        {
            System.out.println("The format of date is invalid. Please enter another one:");
            System.out.print("Enter date here: ");
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                System.out.println("An error occurred while reading input.");
            }
        }
        String[] info = str.split("/");
        boolean ymd;
        ymd = info[0].matches("^[1-9]\\d{3}$");
        if(ymd)
            System.out.printf("Year:%s\nMonth:%s\nDate:%s\n", info[0], info[1], info[2]);
        else
            System.out.printf("Year:%s\nMonth:%s\nDate:%s\n", info[2], info[0], info[1]);
    }
}