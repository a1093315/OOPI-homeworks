import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;
import java.lang.Math;

public class A1093315_0505
{
    static int[] lot_num = {0, 0, 0, 0, 0, 0};
    static int[] user_num = {0, 0, 0, 0, 0, 0};
    static int[] got = {50, 50, 50, 50, 50, 50};
    public static void main(String[] args)
    {
        formLotteryNumber();
        userInput();
        getMatchNumber();
        int result = sortResult();
        System.out.print("Matched lottery number: ");
        if(result == 0)
            System.out.println("--");
        else
        {
            for(int res = 0; res < got.length; res++)
            {
                if(got[res] != 50)
                    System.out.print(got[res] + " ");
            }
            System.out.println();
        }
    }
    public static void formLotteryNumber()
    {
        Random rand = new Random();
        int r;
        int i = 0;
        boolean same;
        while(i < lot_num.length)
        {
            same = false;
            r = rand.nextInt(49) + 1;
            for(int j=0; j<i; j++)
            {
                if(lot_num[j] == r)
                {
                    same = true;
                    break;
                }
            }
            if(!same)
            {
                lot_num[i] = r;
                i++;
            }
        }
    }
    public static void userInput()
    {
        Scanner input = new Scanner(System.in);
        int num = 0;
        System.out.println("Welcome to lottery check system.");
        int i = 0;
        boolean same;
        while(i < user_num.length)
        {
            same = false;
            System.out.printf("Enter number here\n(%d numbers left):",user_num.length - i);
            try
            {
                num = input.nextInt();
            }
            catch(InputMismatchException e)
            {
                System.out.println("What you entered isn't an integer.");
                System.exit(0);
            }
            if(num > 0 && num <= 49)
            {
                for(int check = 0; check < i; check++)
                {
                    if(user_num[check] == num)
                    {
                        same = true;
                        break;
                    }
                }
                if(!same)
                {
                    user_num[i] = num;
                    i++;
                }
            }
        }
    }
    public static void getMatchNumber()
    {
        int count = 0;
        for(int i = 0; i < lot_num.length; i++)
        {
            for(int j = 0; j < user_num.length; j++)
            {
                if(lot_num[i] == user_num[j])
                {
                    got[count] = lot_num[i];
                    count++;
                    break;
                }
            }
        }
    }
    public static int sortResult()
    {
        int temp = 0;
        for(int b = 0; b < got.length - 1; b++)
        {
            if(got[b] > got[b + 1])
            {
                temp = got[b];
                got[b] = got[b+1];
                got[b+1] = temp;
            }
        }
        int ns = 0;
        for(int ndef = 0; ndef < got.length; ndef++)
        {
            if(got[ndef] != 50)
                ns++;
        }
        return ns;
    }
}