package org.example.Reflection_API_Sem.Task1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Program {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException {

        Class<?> person = Class.forName("org.example.Reflection_API_Sem.Task1.Person");
        System.out.println(person);
        Field[] fields = person.getDeclaredFields();
        for(Field field : fields){
            System.out.println("Field " + field.getName());
        }
        Method[] methods = person.getDeclaredMethods();
        for(Method method: methods){
            System.out.println("Method " + method.getName());
        }

        Constructor[] constructors = person.getConstructors();

        for (Constructor constructor: constructors){
            System.out.println("Constructor " + constructor.getName() );
        }

        Object personObject = constructors[0].newInstance(null);


        Field nameField = person.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(personObject,"Alice");

        Field ageField = person.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(personObject,30 );

        Method displayInfoMethod = person.getDeclaredMethod("displayInfo");
        displayInfoMethod.invoke(personObject);
    }

}
