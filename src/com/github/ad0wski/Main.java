package com.github.ad0wski;

import com.github.ad0wski.category.Category;
import com.github.ad0wski.category.CategoryID;
import com.github.ad0wski.difficulty.DifficultyID;
import com.github.ad0wski.priority.PriorityID;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print(ConsoleColors.BLUE);
        System.out.println("My Application ToDoList");
        System.out.println(ConsoleColors.RESET);
        System.out.println(LocalDate.now());

        Connection connection = ToDoListDatabase.createConnection();

        Scanner scanner = new Scanner(System.in).useDelimiter("\n"); //co jest końcem łańcucha tekstowego
        while (1 == 1) {
            System.out.println("Witaj! Co chcesz zrobić? ");
            System.out.println("1 - wyświetl wszystko");
            System.out.println("2 - wyświetl konkretny typ zadań");
            System.out.println("3 - dodaj zadanie");
            System.out.println("4 - edytuj zadanie");
            System.out.println("5 - usuń zadanie");
            System.out.println("6 - filtruj zadania po danej kategorii");
            System.out.println("7 - oznacz jako zrobione");
            System.out.println("8 - zakończ");
            int choice = scanner.nextInt();
            if (choice == 1) {
                ToDoListDatabase.showAllTasks(connection);

            }else if(choice == 2) {
                System.out.println("Jaki typ zadań chcesz wyświetlić: ");
                System.out.println("1. Do zrobienia \n 2. Bliskie terminu realizacji \n 3. Po terminie \n 4. Zrobione");
                int taskType = scanner.nextInt();
                ToDoListDatabase.showSpecificTaskType(connection, taskType);

            } else if (choice == 3) {
                int index = ToDoListDatabase.showAllTasks(connection);
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
                ToDoListDatabase.addTask(connection, index, new Task(LocalDate.parse(date), CategoryID.values()[category - 1], PriorityID.values()[priority - 1], DifficultyID.values()[difficulty - 1], title));
            } else if (choice == 4) {
                System.out.println("Podaj index zadania do edycji: ");
                int index = scanner.nextInt();
                Task task = ToDoListDatabase.getSpecificTask(connection, index);
                System.out.println(task);
                System.out.println("Które pole chcesz edytować?: \n 1. Data zakończenia \n 2. Kategoria \n 3. Skala ważności \n 4. Poziom trudności \n 5. Tytuł");
                int fieldChoice = scanner.nextInt();
                String newValueField;
                if (fieldChoice == 1) {
                    newValueField = scanner.next();
                    task.setEndDate(LocalDate.parse(newValueField));
                    ToDoListDatabase.editTask(connection, index, task);
                }
            } else if (choice == 5) {
                System.out.println("Które zadanie chcesz usunąć? ");
                int index = scanner.nextInt();
                ToDoListDatabase.removingTask(connection, index);

            }else if(choice == 6) {
                System.out.println("Wybierz kategorię zadań: ");
                System.out.println("1. Szkoła \n 2. Hobby \n 3. Dom");
                int choiceCategory = scanner.nextInt();
                ToDoListDatabase.filterTasks(connection, choiceCategory);

            }else if(choice == 7) {
                System.out.println("Podaj index zadania, które chcesz oznaczyć jako zrealizowane: ");
                int index = scanner.nextInt();
                ToDoListDatabase.markAsCompleted(connection, index);

            } else if (choice == 8) {
                break;
            }
        }
    }
}
