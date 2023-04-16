import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lab5 {
    public static void main(String[] args) {
        System.out.println("""
                Лабораторная работа №5
                Задача:
                Написать текстовое меню для решения задачи
                Выполнил: Экбиев Руслан""");
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.println("""
                    \033[H\033[2J
                    Меню
                    1. Подсчет количества вхождений заданной буквы, заданной подстроки, и числа согласных букв в слове
                    2. Выход
                    Выберите пункт меню:""");
            String item = in.nextLine();
            switch (item) {
                case ("1") -> {
                    char[] consonants = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't',
                            'v', 'w', 'x', 'z'};

                    System.out.println("Введите слово, в котором будет производиться поиск: ");
                    String str = in.nextLine();

                    System.out.println("Введите букву для поиска: ");
                    String chr = in.nextLine();

                    System.out.println("Введите подстроку для поиска: ");
                    String substr = in.nextLine();

                    int count_chr = count(str, chr);
                    int count_substr = count(str, substr);
                    int count_consonants = 0;
                    for (char consonant : consonants) {
                        count_consonants += count(str, String.valueOf(consonant));
                    }
                    System.out.printf("%s-%s-%s", count_chr, count_substr, count_consonants);
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

    static int count(String str, String target){
        int count = 0;
        int startIndex = 0;

        Pattern p = Pattern.compile(target, Pattern.LITERAL);
        Matcher m = p.matcher(str);

        while(m.find(startIndex)){
            count++;
            startIndex = m.start() + 1;
        }
        return count;
    }
}
