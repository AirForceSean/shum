
import java.util.Scanner;
 
public class lab2Dasha
{   
 
	public static void main(String[] args) {
		System.out.println("Лабораторная работа №2 \n\nЗадача:\nНаписать для решения задачи \n\nВыполнила: Злобина Дарья \n\nНажмите ENTER чтобы начать");
	    Scanner in = new Scanner(System.in);
        in.nextLine();
        while(true) {
            System.out.println("\033[H\033[2J\nМеню\n\n1. Определение числа на простоту\n2. Выход\nВыберите пункт меню:");
            String item = in.nextLine();
            switch (item) {
                case ("1") -> {
                    boolean flag = true;
                    System.out.print("\nВведиче число для проверки: ");
                    int n = in.nextInt();
                    int n_temp = n;
                    while (n_temp > 2) {
                        n_temp -= 1;
                        if (n % n_temp == 0) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        System.out.print("\nЧисло простое.");
                        in.nextLine();
                    } else {
                        System.out.print("\nЧисло не простое.");
                        in.nextLine();
                    }
                    in.nextLine();
                }
                case ("2") -> {
                    System.out.println("\nВыход.");
                    in.nextLine();
                    System.exit(0);
                }
                default -> {
                    System.out.printf("\nОшибка при выборе пункта - пункт '%s' не найден.", item);
                    in.nextLine();
                }
            }
        }
	}
}