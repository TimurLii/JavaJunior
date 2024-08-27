package org.example.Reflection_API_Sem.Task3.Annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) // говорит о том, что данную аннотацию (которую мы создаем) можно применять к какому то конкретному типу
public @interface Entity {

}
