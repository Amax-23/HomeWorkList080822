import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add(0, "Молоко");
        list.add(1, "Хлеб");
        list.add(2, "Сахар");
        list.add(3, "Гречка с хлебом");
        list.add(4, "Мука -Хлебная-");
        List<String> operation = new ArrayList<>();
        operation.add(0, "Список операций:");
        operation.add(1, "1. Добавить товар в список покупок.");
        operation.add(2, "2. Показать список покупок.");
        operation.add(3, "3. Удалить товар из списка покупок.");
        operation.add(4, "4. Поиск в списке покупок по ключевым словам:");
        List<String> basket = new ArrayList<>();
        //basket.add("Список покупок:");
        for (String s : operation) {
            System.out.println(s);
        }
        while (true) {
            System.out.println("Выберите операцию или введи end для завершения:");
            System.out.println();
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equals("end")) {
                System.out.println("Вы завершили работу программы.");
                break;
            }
            if (Integer.parseInt(input) > 4 || Integer.parseInt(input) < 1) {
                System.out.println("Вы ввели неверные данные!");
                continue;
            }
            if (Integer.parseInt(input) == 1) {
                System.out.println("Какой товар ходите добавить в список покупок?");
                for (String l : list) {
                    System.out.println((list.indexOf(l) + 1) + ". " + l);
                }
                while (true) {
                    int product = scanner.nextInt();
                    if (product < 1 || product > 5) {
                        System.out.println("Такого товара не существует!");
                        continue;
                    }
                    product = product - 1;
                    if (!basket.contains(list.get(product))) {//проверяем на отсутствие такого значения в листе
                        basket.add(list.get(product));
                    }

                    System.out.println("Вы выбрали " + list.get(product));
                    System.out.println("Итого в списке покупок: " + basket.size());
                    break;

                }
            }

            if (Integer.parseInt(input) == 2) {
                System.out.println("Ваш список покупок:");
                for (String s : basket) {
                    System.out.println((basket.indexOf(s) + 1) + ". " + s);
                }
            }
            if (Integer.parseInt(input) == 3) {
                System.out.println("Ваш список покупок:");
                int quan = 0;
                for (String s : basket) {
                    System.out.println((basket.indexOf(s) + 1) + ". " + s);
                }
                System.out.println("Что хотите удалить? Введите номер или название.");
                while (true) {
                    Scanner scan = new Scanner(System.in);
                    if (scan.hasNextInt()) {
                        int number = scan.nextInt() - 1;
                        System.out.println("Вы удалили: " + basket.get(number) + ", теперь список покупок такой:");
                        basket.remove(number);
                        for (String c : basket) {
                            System.out.println((basket.indexOf(c) + 1) + ". " + c);
                            continue;
                        }
                        break;
                    } else {
                        String name = scan.nextLine();
                        if (basket.contains(name)) {// закончил тут
                            System.out.println("Вы удалили: " + name + ", теперь список покупок такой:");
                            basket.remove(basket.indexOf(name));
                            for (String c : basket) {
                                System.out.println((basket.indexOf(c) + 1) + "." + c);
                            }
                            break;
                        } else {
                            System.out.println("Такого товара нет в Вашем списке! Введите верное название!");
                            continue;
                        }
                    }
                }
            }
            if (Integer.parseInt(input) == 4) {
                System.out.println("Введите текст для поиска:");
                while (true) {
                    Scanner scanner1 = new Scanner(System.in);
                    String name = scanner1.nextLine();
//                        char[] chars = name.toCharArray();
//                        for (int i = 0; i < chars.length; i++) {
//                            char c = chars[i];
//                            if (Character.isLowerCase(c)) {
//                                chars[i] = Character.toLowerCase(c);
//                            } else if (Character.isUpperCase(c)) {
//                                chars[i] = Character.toLowerCase(c);
//                            }
//                        }
//                        String word = new String(chars);
                    //System.out.println(name.toLowerCase());
                    System.out.println("Найдено в списке:");
                    for (int i = 0; i < basket.size(); i++) {
                        String word = basket.get(i).toLowerCase();
                        //System.out.println(word);
                        if (word.contains(name.toLowerCase())) {
                            System.out.println((basket.indexOf(basket.get(i)) + 1) + ". " + basket.get(i));

                        }
                    }
                    break;
                }
            }
        }
    }
}



