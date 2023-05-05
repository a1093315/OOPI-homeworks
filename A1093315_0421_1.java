import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class A1093315_0421_1
{
    public static void main(String[] args)
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter the e-mail with correct format.");
        System.out.print("Enter your e-mail here: ");
        String str="";
        try
        {
            str = br.readLine();
        }
        catch (IOException e)
        {
            System.out.println("An error occurred while reading input.");
        }
        if(str.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"))
            System.out.println("The format of this email is valid.");
        else
            System.out.println("The format of this email is invalid.");
    }
}