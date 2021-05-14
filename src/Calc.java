import com.RomeNumbers;
import java.util.Scanner;


public class Calc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String task = sc.nextLine();
        String[] parts = task.split(" ");
        String part1 = parts[0];
        String part2 = parts[2];
        String arab = "0_1_2_3_4_5_6_7_8_9_10";

        if (arab.contains(part1)) {
            int a = Integer.parseInt(part1);

            if (arab.contains(part2)){
                int b = Integer.parseInt(part2);

                if (task.contains("-")) {
                    System.out.println(a - b);
                }

                if (task.contains("+")) {
                        System.out.println(a + b);
                }

                if (task.contains("*")) {
                    System.out.println(a * b);
                }

                if (task.contains("/")) {
                    try {
                        System.out.println(a / b);
                    }
                    catch (ArithmeticException e){    // e - объект класса ArithmeticException
                        System.out.println("error!! Division by 0");
                    }
                }
            } else {
                throw new IllegalArgumentException("Data entry error.");
            }
        } else {
            RomeNumbers s = new RomeNumbers(part1);  //создаем объект s класса RomeNumbers и передаем в конструктор part1
            RomeNumbers t = new RomeNumbers(part2);
            RomeNumbers result = new RomeNumbers(); // создали объект result в классе RomeNumbers и используем конструктор по умолчанию

            if (task.contains("-")) {
                result.arabic = (s.arabic - t.arabic); //  обратились к переменной(параметр) arabic объекта s и t
                System.out.println(result.ToRoman());//
            }

            if (task.contains("+")){
                result.arabic = (s.arabic + t.arabic);
                System.out.println(result.ToRoman());
            }

            if (task.contains("/")){
                result.arabic = (s.arabic / t.arabic);
                System.out.println(result.ToRoman());
            }

            if (task.contains("*")){
                result.arabic = (s.arabic * t.arabic);
                System.out.println(result.ToRoman());
            }
        }
    }
}