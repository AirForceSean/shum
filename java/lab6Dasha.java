import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


public class lab6Dasha {
    public static void insertionSort(char[] sortArr) {
        int j;
        //сортировку начинаем со второго элемента, т.к. считается, что первый элемент уже отсортирован
        for (int i = 1; i < sortArr.length; i++) {
            //сохраняем ссылку на индекс предыдущего элемента
            int swap = sortArr[i];
            for (j = i; j > 0 && swap < sortArr[j - 1]; j--) {
                //элементы отсортированного сегмента перемещаем вперёд, если они больше элемента для вставки
                sortArr[j] = sortArr[j - 1];
            }
            sortArr[j] = (char) swap;
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("""
                Лабораторная работа №6

                Задача:
                Написать текстовое меню для решения задачи

                Выполнила: Злобина Дарья

                Нажмите ENTER чтобы начать""");
        Scanner in = new Scanner(System.in);
        in.nextLine();
        while(true) {
            System.out.println("""
                    \033[H\033[2J
                    Меню

                    1. Сортировка последовательности символов
                    2. Выход
                    Выберите пункт меню:""");
            String item = in.nextLine();
            switch (item) {
                case ("1") -> {
                    System.out.println("Введите последовательность символов через пробел: ");
                    String str = in.nextLine();
                    str = str.replaceAll("\\s", "");

                    char[] chars = str.toCharArray();
                    insertionSort(chars);

                    System.out.println("""
                        Выберите способ вывода отсортированной последовательности
        
                        1. В виде файла
                        2. Вывести в консоль
                        Выберите пункт меню:
                        """);
                    String item2 = in.nextLine();
                    switch (item2) {
                        case ("1") -> {
                            FileWriter fileWriter = new FileWriter("sorted_arr.txt");
                            PrintWriter printWriter = new PrintWriter(fileWriter);
                            printWriter.print(Arrays.toString(chars));
                            printWriter.close();
                            System.out.print("Файл сохранен.\n");
                        }
                        case ("2") -> {
                            System.out.printf(Arrays.toString(chars));
                            in.nextLine();
                        }
                        default -> {
                            System.out.printf("\nОшибка при выборе пункта - пункт '%s' не найден.", item);
                            in.nextLine();
                        }
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
