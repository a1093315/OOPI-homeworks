import java.util.Scanner;
import java.util.ArrayList;
class Animal
{
    String name = "";
    double height = 0;
    int weight = 0;
    int speed = 0;

    public Animal(String name, double height, int weight, int speed)
    {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.speed = speed;
    }
    public double distance(int time, double acceleration)
    {
        return time * acceleration * speed;
    }
    public int distance(int time)
    {
        return time * speed;
    }
}

public class A1093315_0324_1
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        ArrayList<Animal> animalList = new ArrayList<Animal>();
        int[] timeList = {0, 0, 0, 0};
        double[] accelerationList = {0, 0, 0, 0};
        animalList.add(new Animal("雪寶", 1.1, 52, 100));
        animalList.add(new Animal("驢子", 1.5, 99, 200));
        animalList.add(new Animal("安那", 1.7, 48, 120));
        animalList.add(new Animal("愛沙", 1.7, 50, 120));
        int count = 0;
        for(Animal i : animalList)
        {
            System.out.print(i.name + "的跑步時間(無則輸入0): ");
            timeList[count] = input.nextInt();
            System.out.print(i.name + "的跑步加速度(無則輸入0): ");
            accelerationList[count] = input.nextDouble();
            count++;
            System.out.println("---------------------------------");
        }
        count = 0;
        for(Animal i : animalList)
        {
            if(accelerationList[count] == 0)
                System.out.println(i.name + "的奔跑距離是" + i.distance(timeList[count]) + "公尺。");
            else
                System.out.println(i.name + "的奔跑距離大約是" + String.format("%.2f", i.distance(timeList[count], accelerationList[count])) + "公尺。");
            count++;
        }
    }
}