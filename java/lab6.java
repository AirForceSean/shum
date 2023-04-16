import java.util.*;
import java.io.*;



public class lab6 {

    // Метод для кодирования сообщения с помощью шифра Цезаря
    // Метод для кодирования сообщения с помощью шифра Цезаря
    public static String encodeMessage(String message, int key) {
        String encodedMessage = "";
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            // Если символ не является буквой, добавляем его в закодированное сообщение без изменения
            if (!Character.isLetter(ch)) {
                encodedMessage += ch;
                continue;
            }
            // Получаем числовое значение маленькой (a - z) или большой (A - Z) буквы
            int caseOffset = (int)ch >= 'а' ? 'а' : 'А';
            // Применяем шифр Цезаря c ключом key для получения нового числового значения буквы
            int shiftedAsciiValue = (((int)ch - caseOffset + key) % 33) + caseOffset;
            // Преобразуем числовое значение обратно в символ и добавляем в закодированное сообщение
            encodedMessage += (char)shiftedAsciiValue;
        }
        return encodedMessage;
    }

    // Метод для декодирования сообщения с помощью шифра Цезаря
    public static String decodeMessage(String message, int key) {
        // Для декодирования используем тот же алгоритм, что и для кодирования, но с противоположным ключом
        String decodedMessage = "";
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (!Character.isLetter(ch)) {
                decodedMessage += ch;
                continue;
            }
            int caseOffset = (int)ch >= 'а' ? 'а' : 'А';
            int shiftedAsciiValue = (((int)ch - caseOffset + 33 - key) % 33) + caseOffset;
            decodedMessage += (char)shiftedAsciiValue;
        }
        return decodedMessage;
    }


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
                    1. Кодирование\\декодирование текстового сообщения из файла
                    2. Выход
                    Выберите пункт меню:""");
            String item = in.nextLine();
            switch (item) {
                case ("1") -> {
                    System.out.println("Введите имя текстового файла:");

                    String file_name = in.nextLine();
                    int key = 3;

                    try {
                        // Читаем весь файл в строку
                        File file = new File(file_name + ".txt");
                        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                        String inputString = "";
                        String line;
                        while ((line = bufferedReader.readLine()) != null)
                            inputString += line + "\n";
                        bufferedReader.close();

                        System.out.println("""
                                Выберите необходимую манипуляцию
                                
                                1. Кодировать файл
                                2. Декодировать файл""");
                        String item2 = in.nextLine();
                        switch (item2) {
                            case ("1") -> {
                                String encodedString = encodeMessage(inputString, key);
                                PrintWriter printWriter = new PrintWriter(file_name + "_encoded.txt");
                                printWriter.print(encodedString);
                                printWriter.close();

                                System.out.println("Файл закодирован.");
                                in.nextLine();
                            }
                            case ("2") -> {
                                bufferedReader = new BufferedReader(new FileReader(file_name + ".txt"));
                                inputString = "";
                                while ((line = bufferedReader.readLine()) != null)
                                    inputString += line + "\n";
                                bufferedReader.close();

                                String decodedString = decodeMessage(inputString, key);
                                PrintWriter printWriter = new PrintWriter(file_name + "_decoded.txt");
                                printWriter.print(decodedString);
                                printWriter.close();

                                System.out.println("Файл декодирован.");
                                in.nextLine();
                            }
                            default -> {
                                System.out.printf("\nОшибка при выборе пункта - пункт '%s' не найден.", item);
                                in.nextLine();
                            }
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
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
