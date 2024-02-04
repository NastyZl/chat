package org.example.data;

public final class DataBase {

    private DataBase() {

    }

    public static void init() {
        System.out.println("Установка соединения с Базой Данных");
    }


    public static void close() {
        System.out.println("Закрытие соединения с Базой Данных");
    }
}
