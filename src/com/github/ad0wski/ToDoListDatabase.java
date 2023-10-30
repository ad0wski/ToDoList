package com.github.ad0wski;

import com.github.ad0wski.category.CategoryID;
import com.github.ad0wski.difficulty.DifficultyID;
import com.github.ad0wski.priority.PriorityID;
import jdk.jshell.Snippet;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.chrono.MinguoDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class ToDoListDatabase {
    public static Connection createConnection() {
        try {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/mysql";
            String userName = "root";
            String password = "";
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Database connected");
            return connection;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public static void addTask(Connection connection, int index, Task task) {
        try {
            Statement statement = connection.createStatement();
            String query = "INSERT INTO ToDoList(ID, EndDate, CategoryID, PriorityID, DifficultyID, Title)" +
                    "VALUES (" + index + ", \'" + task.getEndDate() + "\', " + task.getCategoryID().index + ", " + task.getPriorityID().index + ", " + task.getDifficultyID().index + ", \'" + task.getTitle() + "\');";
            System.out.println(query);
            statement.executeUpdate(query);
//            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static int showAllTasks(Connection connection) {
        int index = 0;
        try {
            LocalDate currentDate = LocalDate.now();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM ToDoList";
            System.out.println(query);
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                LocalDate taskDate = LocalDate.parse(resultSet.getString("EndDate"));
                long diff = DAYS.between(currentDate, taskDate);
                if(diff < 3){
                    System.out.println(ConsoleColors.YELLOW);
                }
                System.out.println(resultSet.getString("ID") + " " + resultSet.getString("EndDate") + " " + CategoryID.values()[Integer.parseInt(resultSet.getString("CategoryID")) - 1] + " " + PriorityID.values()[Integer.parseInt(resultSet.getString("PriorityID")) - 1] + " " + DifficultyID.values()[Integer.parseInt(resultSet.getString("DifficultyID")) - 1] + " " + resultSet.getString("Title"));
                System.out.println(ConsoleColors.RESET);
                int currentIndex = resultSet.getInt("ID");
                if (index < currentIndex) {
                    index = currentIndex + 1;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return index;
    }

    public static void editTask(Connection connection, int index, Task task) {
        try {
            Statement statement = connection.createStatement();
            String query = "UPDATE ToDoList SET EndDate = \'" + task.getEndDate() + "\', CategoryID = " + task.getCategoryID().index + ", PriorityID = " + task.getPriorityID().index + ", DifficultyID = " + task.getDifficultyID().index + ", Title = \'" + task.getTitle() + "\' WHERE ID = " + index;
            System.out.println(query);
            statement.executeUpdate(query);
            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static Task getSpecificTask(Connection connection, int index) {
        Task task = null;
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM ToDoList WHERE ID = " + index + ";";
            System.out.println(query);
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            task = new Task(LocalDate.parse(resultSet.getString("EndDate")), CategoryID.values()[resultSet.getInt("CategoryID") - 1], PriorityID.values()[resultSet.getInt("PriorityID") - 1], DifficultyID.values()[resultSet.getInt("DifficultyID") - 1], resultSet.getString("Title"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return task;
    }

    public static void removingTask(Connection connection, int index) {
        try{
            Statement statement = connection.createStatement();
            String query = "DELETE FROM ToDoList WHERE ID = " + index + ";";
            statement.executeUpdate(query);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
