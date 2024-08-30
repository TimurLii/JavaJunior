package org.example.Serialization_Sem.Task2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ClassNotFoundException {
        List<ToDo> tasks;
        File f = new File(ToDoListApp.FILE_JSON);
        if (f.exists() && !f.isDirectory()) {
            tasks = ToDoListApp.loadTaskFromFile(ToDoListApp.FILE_JSON);
        } else {
            tasks = prepareTask();
            ToDoListApp.saveTasksToFile(ToDoListApp.FILE_JSON, tasks);
            ToDoListApp.saveTasksToFile(ToDoListApp.FILE_XML, tasks);
            ToDoListApp.saveTasksToFile(ToDoListApp.FILE_BIN, tasks);
        }

        ToDoListApp.displayTask(tasks);
        Scanner scanner = new Scanner(System.in);
          while(true){
              System.out.println("ВЫберите действие ");
              System.out.println("1. Добавить новую задачу");
              System.out.println("2. Отметить задачу как выполненую.");
              System.out.println("3. Выйти ");

              String chose = scanner.nextLine();

              switch (chose){
                  case "1":
                      ToDoListApp.addNewTask(scanner , tasks);
                      break;
                  case "2" :
                      ToDoListApp.markTaskDone(scanner, tasks);
                      break;
                  case "3" :
                      ToDoListApp.saveTasksToFile(ToDoListApp.FILE_JSON, tasks);
                      ToDoListApp.saveTasksToFile(ToDoListApp.FILE_XML, tasks);
                      ToDoListApp.saveTasksToFile(ToDoListApp.FILE_BIN, tasks);
                      System.out.println("Список задачь сохранён. ");
                      scanner.close();
                  default:
                      System.out.println("Некорректный выбор. Попробуйте снова.");
              }
              ToDoListApp.displayTask(tasks);
          }
    }

    static List<ToDo> prepareTask() {
        ArrayList<ToDo> list = new ArrayList<>();
        list.add(new ToDo("Сходить в магазин"));
        list.add(new ToDo("Погулять с собакой "));
        list.add(new ToDo("Заменить ломапочку"));
        return list;
    }
}
