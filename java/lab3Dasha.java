import java.util.*;
public class lab3Dasha {
    public static void main(String[] args) {
        System.out.println("""
                Лабораторная работа №3\s

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

                    1. Сортировка строк матрицы по возростанию наименьших элементов
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
                    int[][] matrix = new int[rows][columns];

                    // Заполняем массив значениями из ввода консоли
                    System.out.println("Введите элементы массива построчно:");
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < columns; j++) {
                            System.out.print("arr[" + i + "][" + j + "] = ");
                            matrix[i][j] = in.nextInt();
                        }
                    }
                    int[] minValues = new int[matrix.length];

                    for (int i = 0; i < matrix.length; i++) {
                        int minVal = Integer.MAX_VALUE;
                        for (int j = 0; j < matrix[i].length; j++) {
                            if (matrix[i][j] < minVal) {
                                minVal = matrix[i][j];
                            }
                        }
                        minValues[i] = minVal;
                    }

                    for (int i = 0; i < matrix.length; i++) {
                        for (int j = i + 1; j < matrix.length; j++) {
                            if (minValues[i] > minValues[j]) {
                                int[] temp = matrix[i];
                                matrix[i] = matrix[j];
                                matrix[j] = temp;

                                int minValue = minValues[i];
                                minValues[i] = minValues[j];
                                minValues[j] = minValue;
                            }
                        }
                    }

                    System.out.println(Arrays.deepToString(matrix));
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
