import java.util.Scanner;
public class A1093315_0317_1
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the 'n' to calculate (1~n)*(1~m):");
        int n=input.nextInt();
        while(n<1)
        {
            System.out.println("Invalid input. Please enter a number which is larger than 1.");
            System.out.print("Enter the 'n' to calculate (1~n)*(1~m):");
            n=input.nextInt();
        }
        System.out.print("Enter the 'm' to calculate (1~n)*(1~m):");
        int m=input.nextInt();
        while(m<1)
        {
            System.out.println("Invalid input. Please enter a number which is larger than 1.");
            System.out.print("Enter the 'm' to calculate (1~n)*(1~m):");
            m=input.nextInt();
        }
        int[][] arr = new int[n][m];
        for(int row=0; row<n; row++)
        {
            for(int col=0; col<m; col++)
                arr[row][col]=(row+1)*(col+1);
        }
        int countr=1;
        int countc=1;
        int maxnum=n*m;
        boolean toolarge=false;
        for(int[] row:arr)
        {
            countc=1;
            for(int col:row)
            {
                switch(digit(maxnum))
                {
                    case 1:
                        System.out.printf("%d*%d=%d", countr, countc, arr[countr-1][countc-1]);
                        break;
                    case 2:
                        System.out.printf("%2d*%2d=%2d", countr, countc, arr[countr-1][countc-1]);
                        break;
                    case 3:
                        System.out.printf("%3d*%3d=%3d", countr, countc, arr[countr-1][countc-1]);
                        break;
                    case 4:
                        System.out.printf("%4d*%4d=%4d", countr, countc, arr[countr-1][countc-1]);
                        break;
                    default:
                        System.out.println("It's difficult to show an orderly calculation table because numbers are too large.");
                        System.out.println("Maybe you should try numbers which are smaller than 100 * 100.");
                        toolarge=true;
                        break;
                }
                if(toolarge==true)
                    break;
                System.out.print(countc==m ? "\n" : "|");
                countc++;
            }
            if(toolarge==true)
                break;
            countr++;
        }
    }
    public static int digit(int num)
    {
        int i=1;
        while(num/10>0)
        {
            num/=10;
            i+=1;
        }
        return i;
    }
}