package com.github.ad0wski;

import com.github.ad0wski.category.Category;
import com.github.ad0wski.category.CategoryID;
import com.github.ad0wski.difficulty.DifficultyID;
import com.github.ad0wski.priority.PriorityID;

import java.sql.Connection;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("My Application ToDoList");

        System.out.println("Witaj!");
        System.out.println("1 - wyświetl wszystko");
        System.out.println("2 - dodaj zadanie");
        System.out.println("3 - edytuj zadanie");
        System.out.println("4 - usuń zadanie");

        Connection connection = ToDoListDatabase.createConnection();

        Scanner scanner = new Scanner(System.in).useDelimiter("\n"); //co jest końcem łańcucha tekstowego
        int choice = scanner.nextInt();
        if(choice == 1){
            ToDoListDatabase.showAllTasks(connection);
        }else if(choice == 2){
            System.out.println("Podaj datę zakończenia zadania: ");
            String date = scanner.next();
            System.out.println("Podaj kategorię zadania: ");
            System.out.println("1. SCHOOL, 2. HOBBY, 3. HOME");
            int category = scanner.nextInt();
            System.out.println("Podaj skalę ważności zadania: ");
            System.out.println("1. LOW, 2. MEDIUM, 3. HIGH");
            int priority = scanner.nextInt();
            System.out.println("Podaj poziom trudności: ");
            System.out.println("1. EASY, 2. MEDIUM, 3. HARD");
            int difficulty = scanner.nextInt();
            System.out.println("Podaj tytuł zadania: ");
            String title = scanner.next();
            ToDoListDatabase.addTask(connection, 4, new Task(ZonedDateTime.parse(date + "T01:00:00+01:00"), CategoryID.values()[category-1], PriorityID.values()[priority-1], DifficultyID.values()[difficulty-1], title));
        }else if(choice == 3){
            System.out.println("Podaj index zadania do edycji: ");
            int index = scanner.nextInt();
            Task task = ToDoListDatabase.getSpecificTask(connection, index);
            System.out.println(task);
            System.out.println("Które pole chcesz edytować?: \n 1. Data zakończenia \n 2. Kategoria \n 3. Skala ważności \n 4. Poziom trudności \n 5. Tytuł");
            choice = scanner.nextInt();
            String newValueField;
            if(choice == 1){
                newValueField = scanner.next();
                task.setEndDate(ZonedDateTime.parse(newValueField));
                ToDoListDatabase.editTask(connection, index, task);
            }
        }else if(choice == 4){

        }
    }
}
