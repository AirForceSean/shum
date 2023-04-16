import java.util.*;

public class lab3 {

    public static void main(String[] args) {
        String item;
        String words;

        System.out.println("""
                Лабораторная работа №3\s
                Задача:
                Написать текстовое меню для решения задачи\s
                Выполнил: Экбиев Руслан\s

                """);
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.println("""
                    \033[H\033[2J
                    Меню
                    1. Объединение 2 отсортированных массивов в 1 отсортированный
                    2. Выход
                    Выберите пункт меню:
                    """);
            item = in.nextLine();
            switch (item) {
                case ("1") -> {
                    System.out.println("\nВведите числа первого массива чисел через пробел:");
                    words = in.nextLine();
                    int [] arr1 = new int [words.split(" ").length];
                    for(int i=0; i<words.split(" ").length; i++) {
                        arr1[i] = Integer.parseInt(words.split(" ")[i]);
                    }

                    System.out.println("\nВведите числа второго массива чисел через пробел:");
                    words = in.nextLine();
                    int [] arr2 = new int [words.split(" ").length];
                    for(int i=0; i<words.split(" ").length; i++) {
                        arr2[i] = Integer.parseInt(words.split(" ")[i]);
                    }

                    int [] result = new int [arr2.length + arr1.length];

                    int i = 0, j = 0, k = 0;

                    while (i < arr1.length && j < arr2.length) {
                        if (arr1[i] < arr2[j]) {
                            result[k++] = arr1[i++];
                        } else {
                            result[k++] = arr2[j++];
                        }
                    }

                    while (i < arr1.length) {
                        result[k++] = arr1[i++];
                    }

                    while (j < arr2.length) {
                        result[k++] = arr2[j++];
                    }
                    System.out.println("Итоговый массив: ");
                    System.out.println(Arrays.toString(result));
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
