package com.github.ad0wski;

import com.github.ad0wski.category.CategoryID;
import com.github.ad0wski.difficulty.DifficultyID;
import com.github.ad0wski.priority.PriorityID;

import java.sql.*;

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
//            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void showAllTasks(Connection connection){
        try{
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM ToDoList";
            System.out.println(query);
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                System.out.println(resultSet.getString("ID") + " " + resultSet.getString("EndDate") + " " + CategoryID.values()[Integer.parseInt(resultSet.getString("CategoryID"))-1] + " " + PriorityID.values()[Integer.parseInt(resultSet.getString("PriorityID"))-1] + " " + DifficultyID.values()[Integer.parseInt(resultSet.getString("DifficultyID"))-1] + " " + resultSet.getString("Title"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}