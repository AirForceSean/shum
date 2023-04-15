import java.util.*;

public class lab5Dasha {

    public static void main(String[] args) {
        System.out.println("""
                Лабораторная работа №5\s

                Задача:
                Написать текстовое меню для решения задачи\s

                Выполнила: Злобина Дарья\s

                Нажмите ENTER чтобы начать""");
        Scanner in = new Scanner(System.in);
        in.nextLine();
        while(true) {
            System.out.println("""
                    \033[H\033[2J
                    Меню

                    1. Нахождение суммы матрицы
                    2. Выход
                    Выберите пункт меню:""");
            String item = in.nextLine();
            switch (item) {
                case ("1") -> {
                    System.out.print("Введите количество строк: ");
                    int rows = in.nextInt();
                    System.out.print("Введите количество столбцов: ");
                    int columns = in.nextInt();

                    // Создаем двумерный массив
                    int[][] arr = new int[rows][columns];

                    // Заполняем массив значениями из ввода консоли
                    System.out.println("Введите элементы массива построчно:");
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < columns; j++) {
                            System.out.print("arr[" + i + "][" + j + "] = ");
                            arr[i][j] = in.nextInt();
                        }
                    }
                    int sum = sum_of_matrix(arr);
                    System.out.println("Сумма элементов двумерного массива = " + sum);
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

    static int sum_of_matrix(int[][] arr){
        int sum = 0;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                sum += anInt;
            }
        }
        return sum;
    }
}
