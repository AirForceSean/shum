import java.util.*;

public class lab4 {
    public static void main(String[] args) {
        System.out.println("""
                Лабораторная работа №4\s

                Задача:
                Написать текстовое меню для решения задачи\s
                Выполнил: Экбиев Руслан\s""");
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.println("""
                    \033[H\033[2J
                    Меню
                    1. Поменять знаки '+' и '-' между собой в математическом выражении
                    2. Выход
                    Выберите пункт меню:
                    """);
            String item = in.nextLine();
            switch (item) {
                case ("1") -> {

                    System.out.println("\nВведите математическое выражение: ");
                    String arithmeticExpression = in.nextLine();
                    String modifiedExpression = arithmeticExpression;
                    StringBuilder sb = new StringBuilder(modifiedExpression);

                    for (int i = 0; i < arithmeticExpression.length(); i++) {
                        if (arithmeticExpression.charAt(i) == '-') {
                            sb.setCharAt(i, '+');
                        } else if (arithmeticExpression.charAt(i) == '+') {
                            sb.setCharAt(i, '-');

                        }
                    }
                    modifiedExpression = sb.toString();

                    System.out.printf("\nОтвет: %s", modifiedExpression);
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
