package org.example.lambda_1_Sem.Task2;

import java.util.Scanner;

public class Program {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        UMarket uMarket = new UMarket();
        System.out.println("Добро пожаловать в магазин U-Market ");

        while (true) {
            System.out.println("===================================================================");
            System.out.println("0 - Звершение работы приложения.");
            System.out.println("1 - Отобразить полный список товаров.");
            System.out.println("2 - Сформировать онлайн корзину из снэков.");
            System.out.println("3 - Сформировать онлайн корзину из полуфабрикатов.");
            System.out.println("4 - Сформировать онлайн корзину из продуктов для приготовле.");
            System.out.println("5 - Сформировать онлайн корзину из любых продовольственных товаров.");
            System.out.println("Выберите пункт меню.");


            if (scanner.hasNextInt()) {
                int no = scanner.nextInt();
                scanner.nextLine();
                switch (no) {
                    case 0 -> {
                        System.out.println("Завершение работы");
                        return;
                    }
                    case 1 -> {
                        System.out.println("Список товаров");
                        uMarket.printThings(Food.class);
                    }
                    case 2 -> CreateCart(Snack.class, uMarket);
                    case 3 -> CreateCart(SemFinishedFood.class, uMarket);
                    case 4 -> CreateCart(HealthyFood.class, uMarket);
                    case 5 -> CreateCart(Food.class, uMarket);
                    default -> System.out.println("Некорректный пункт меню.");

                }
            } else {
                System.out.println("Некорректный пункт меню.");
                scanner.nextLine();
            }

        }
    }

    static <T extends Food> void CreateCart(Class<T> clazz, UMarket uMarket) {
        Cart<T> cart = new Cart<>(clazz, uMarket);
        while (true) {
            System.out.println("Список доступных товаров ");
            System.out.println("[0] - Заверщение формирование корзины + балансировка  ");
            uMarket.printThings(clazz);
            System.out.println("Укажите номер товара для добавления");
            if (scanner.hasNextInt()) {
                int no = scanner.nextInt();
                if (no == 0) {
                    cart.cartBalansinng();
                    System.out.println("Ваша корзина содержит продукты");
                    cart.printFoodstuffs();
                    return;
                } else {
                    T thing = uMarket.getThingByIndex(clazz, no);
                    if (thing == null) {
                        System.out.println("Некорректный номер товара");
                        continue;
                    }
                    cart.getFoodstuffs().add(thing);
                    System.out.println("Товар успешно добавлен в корзину");
                    System.out.println("Выша корзина содержит продукты.");
                    cart.printFoodstuffs();
                }

            }else{
                System.out.println("Некорректный пункт меню");
                scanner.nextLine();
            }
        }

    }
}
