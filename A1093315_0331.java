import java.util.Scanner;
class animal
{
    public String name;
    public double height;
    public int weight;
    public int speed;

    animal(String name, double height, int weight, int speed)
    {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.speed = speed;
    }
    public void show()
    {
        System.out.printf("%6s, %f, %d, %d\n", name, height, weight, speed);
    }
    public double distance(double x, double y)
    {
        return x * y * speed;
    }
    public double distance(double x)
    {
        return x * speed;
    }
    public String getName()
    {
        return name;
    }
    public static void showinfo()
    {
        System.out.println("歡迎進入冰雪奇緣系統");
    }
}
class human extends animal
{
    String gender;
    human(String name, double height, int weight, String gender, int speed)
    {
        super(name, height, weight, speed);
        this.gender = gender;
    }
    @Override
    public void show()
    {
        System.out.printf("%6s, %f, %d, %s, %d\n", name, height, weight, gender, speed);
    }
}
class snow extends human
{
    String freeze;
    snow(String name, double height, int weight, String gender, String freeze, int speed)
    {
        super(name, height, weight, gender, speed);
        this.freeze = freeze;
    }
    @Override
    public void show()
    {
        System.out.printf("%6s, %f, %d, %s, %s, %d\n", name, height, weight, gender, freeze, speed);
    }
    @Override
    public double distance(double x, double y)
    {
        return x * y * speed * 2;
    }
    @Override
    public double distance(double x)
    {
        return x * speed * 2;
    }
}
public class A1093315_0331
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        animal.showinfo();
        //-------------------------------------------------------
        animal[] chara_list= new animal[6];
        chara_list[0] = new animal("雪寶", 1.1, 52, 100);
        chara_list[1] = new animal("驢子", 1.5, 99, 200);
        chara_list[2] = new human("阿克", 1.9, 80, "男", 150);
        chara_list[3] = new human("阿克", 1.8, 78, "男", 130);
        chara_list[4] = new human("安那", 1.7, 48, "女", 120);
        chara_list[5] = new snow("愛沙", 1.7, 50, "女", "Yes", 120);
        for(int i=0; i<chara_list.length; i++)
            chara_list[i].show();
        //-------------------------------------------------------
        double[] chara_dist = new double[chara_list.length]; //供最後統一輸出用
        String x, y;            //供紀錄輸入用
        double x_t = 0, y_a = 0;        //供計算用
        boolean accept = false; //紀錄數字是否合理
        boolean no_a = false;   //紀錄是否不具加速度
        for(int i=0; i<chara_list.length; i++)
        {
            System.out.print("請輸入"+chara_list[i].getName()+"的跑步時間: ");
            //                                                                 x(時間)的邏輯式開始
            x = input.nextLine();
            try
            {
                x_t = Double.parseDouble(x);
                accept = x_t >= 0 ? true : false;
            }
            catch(NumberFormatException e)
            {
                accept = false;
            }
            //                                                                 x(時間)的邏輯式結束
            while(!accept)//                                                   不合邏輯就強迫重輸
            {
                System.out.print("時間不合理，請重新輸入: ");
                x = input.nextLine();
                try
                {
                    x_t = Double.parseDouble(x);
                    accept = x_t >= 0 ? true : false;
                }
                catch(NumberFormatException e)
                {
                    accept = false;
                }
            }
            //-------------------------------------------------------
            System.out.print("請輸入"+chara_list[i].getName()+"的跑步加速度: ");
            //                                                                 y(加速度)的邏輯式開始
            y = input.nextLine();
            if(y.isEmpty())
            {
                no_a = true;
                accept = true;
            }
            else
            {
                try
                {
                    y_a = Double.parseDouble(y);
                    accept = true;
                    no_a = y_a == 0 ? true : false;
                }
                catch(NumberFormatException e)
                {
                    accept = false;
                }
            }
            //                                                                 y(加速度)的邏輯式結束
            while(!accept)//                                                   不合邏輯就強迫重輸
            {
                System.out.print("加速度不合理，請重新輸入: ");
                y = input.nextLine();
                if(y.isEmpty())
                {
                    no_a = true;
                    accept = true;
                }
                else
                {
                    try
                    {
                        y_a = Double.parseDouble(y);
                        accept = true;
                        no_a = y_a == 0 ? true : false;
                    }
                    catch(NumberFormatException e)
                    {
                        accept = false;
                    }
                }
            }
            //-------------------------------------------------------
            if(no_a)
                chara_dist[i] = chara_list[i].distance(x_t);
            else
                chara_dist[i] = chara_list[i].distance(x_t, y_a);
        }
        for(int i=0; i<chara_list.length; i++)
            System.out.println(chara_list[i].getName()+"的奔跑距離為"+chara_dist[i]+"公尺");
    }
}