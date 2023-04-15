import java.util.*;

public class lab4Dasha {
    public static void main(String[] args) {
        System.out.println("""
                Лабораторная работа №4\s

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

                    1. Поменять первую и последнюю букву слова и смешать слова через одну букву
                    2. Выход
                    Выберите пункт меню:""");
            String item = in.nextLine();
            switch (item) {
                case ("1") -> {
                    String firstWord = in.nextLine();
                    String secondWord = in.nextLine();

                    String middleLetters = "";
                    for(int i=0; i<Math.max(firstWord.length(), secondWord.length()); i+=1){
                        if (i < firstWord.length()) {
                            if (i==0){
                                middleLetters += Character.toString(firstWord.charAt(firstWord.length()-1));
                            } else if (i==firstWord.length()-1) {
                                middleLetters += Character.toString(firstWord.charAt(0));
                            } else {
                                middleLetters += Character.toString(firstWord.charAt(i));
                            }
                        }
                        if (i < secondWord.length()) {
                            if (i==0){
                                middleLetters += Character.toString(secondWord.charAt(secondWord.length()-1));
                            } else if (i==secondWord.length()-1) {
                                middleLetters += Character.toString(secondWord.charAt(0));
                            } else {
                                middleLetters += Character.toString(secondWord.charAt(i));
                            }

                        }
                    }

                    System.out.println(middleLetters);
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
