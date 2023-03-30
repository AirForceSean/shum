import java.util.Scanner;
 
public class Main
{   
 
	public static void main(String[] args) {
		System.out.println("Лабораторная работа №1 \n\nЗадача:\nНаписать программу реализующую текстовое меню \n\nВыполнил: Экбиев Руслан \n\nНажмите ENTER чтобы начать");
	    Scanner in = new Scanner(System.in);
        String ENTER = in.nextLine();
        while(true) {
            System.out.println("\033[H\033[2J\nМеню\n\n1. Пункт 1\n2. Пункт 2\n3. Пункт 3\n4. Выход\nВыберите пункт меню:");
            String item = in.nextLine();
            switch (item) {
 
               case  ("1"):
                    System.out.printf("\nВы выбрали пункт %s", item);
                    in.nextLine();
                    break;
 
               case ("2"):
                    System.out.printf("\nВы выбрали пункт %s", item);
                    in.nextLine();
                    break;
 
               case ("3"):
                    System.out.printf("\nВы выбрали пункт %s", item);
                    in.nextLine();
                    break;
 
               case ("4"):
                    System.out.println("\nВыход.");
                    in.nextLine();
                    System.exit(0);
                    break;
 
               default:
                    System.out.printf("\nОшибка при выборе пункта - пункт '%s' не найден.", item);
                    in.nextLine();
                    break;
           }
        }
	}
}
