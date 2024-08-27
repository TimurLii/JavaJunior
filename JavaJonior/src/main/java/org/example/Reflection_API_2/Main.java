package org.example.Reflection_API_2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> car = Class.forName("org.example.Reflection_API_2.Car");
        Constructor<?>[] constructors = car.getConstructors();

        Object gaz = constructors[0].newInstance("ГАЗ");
        System.out.println(gaz);

        Field[] fields = gaz.getClass().getFields();
        int temp = fields[fields.length -1].getInt(gaz);
        fields[fields.length-1].setInt(gaz, temp *2);


        System.out.println(gaz);
        Method[] methods = gaz.getClass().getDeclaredMethods();
        for(Method el : methods){
            System.out.println(el);
        }
    }
}
