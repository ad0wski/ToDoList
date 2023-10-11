package com.github.ad0wski;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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

    public static void addTask(Connection connection, int index, Task task){
        try{
            Statement statement = connection.createStatement();
            String query = "INSERT INTO ToDoList(ID, EndDate, CategoryID, PriorityID, DifficultyID, Title)" +
                    "VALUES (" + index + ", \'" + task.getEndDate() + "\', " + task.getCategoryID().index + ", " + task.getPriorityID().index + ", " + task.getDifficultyID().index + ", \'" + task.getTitle() + "\');";
            System.out.println(query);
            statement.executeUpdate(query);
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
