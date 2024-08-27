package org.example.Reflection_API_Sem.Task2;

import java.lang.reflect.Field;

public class Program {
    public static void main(String[] args) throws IllegalAccessException {
        Car car = new Car("Toyota", "Blue" , 2022);
        task2(car);

    }

//создание метода для работы с разными типами
    private static <T> void task2(T obj) throws IllegalAccessException {
        // получение класса передаваемого типа
        Class<?> objClass = obj.getClass();
        // получение полей передаваемого типа
        Field[] fields = objClass.getDeclaredFields();
        for(Field field : fields){
            field.setAccessible(true); // разрешаем доступ к закрытому полю
            System.out.printf("%s : %s  \n ", field.getName(), field.get(obj) );
        }
    }
}
