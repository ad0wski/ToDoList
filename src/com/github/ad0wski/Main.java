package com.github.ad0wski;

import com.github.ad0wski.category.Category;
import com.github.ad0wski.category.CategoryID;
import com.github.ad0wski.difficulty.DifficultyID;
import com.github.ad0wski.priority.PriorityID;

import java.sql.Connection;
import java.time.ZonedDateTime;

public class Main {

    public static void main(String[] args) {
        System.out.println("My Application ToDoList");

        System.out.println("Witaj!");
        System.out.println("1 - wyświetl wszystko");
        System.out.println("2 - dodaj zadanie");
        System.out.println("3 - edytuj zadanie");
        System.out.println("4 - usuń zadanie");

        Connection connection = ToDoListDatabase.createConnection();
        ToDoListDatabase.addTask(connection, 2, new Task(ZonedDateTime.parse("2023-10-11T01:00:00+01:00"), CategoryID.HOME, PriorityID.LOW, DifficultyID.EASY, "Sprzatanie"));

    }
}
