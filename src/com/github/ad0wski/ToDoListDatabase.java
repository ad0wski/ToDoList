package com.github.ad0wski;

import com.github.ad0wski.attributes.CategoryID;
import com.github.ad0wski.attributes.DifficultyID;
import com.github.ad0wski.attributes.PriorityID;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

import static java.time.temporal.ChronoUnit.DAYS;

public class ToDoListDatabase {
    public static Connection createConnection() {
        try {
            final String driver = "com.mysql.jdbc.Driver";
            final String url = "jdbc:mysql://localhost:3306/mysql";
            final String userName = "root";
            final String password = "";
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
                if (diff < 3 && diff > -1) {
                    System.out.print(ConsoleColors.YELLOW);
                } else if (diff < 0) {
                    System.out.print(ConsoleColors.RED_BACKGROUND);
                }

                if (resultSet.getInt("ID") == 0) {
                    System.out.print(ConsoleColors.RESET);
                    System.out.print(ConsoleColors.GREEN_BOLD);
                }
                System.out.println(resultSet.getString("ID") + " " + resultSet.getString("EndDate") + " " + CategoryID.values()[Integer.parseInt(resultSet.getString("CategoryID")) - 1] + " " + PriorityID.values()[Integer.parseInt(resultSet.getString("PriorityID")) - 1] + " " + DifficultyID.values()[Integer.parseInt(resultSet.getString("DifficultyID")) - 1] + " " + resultSet.getString("Title"));
                System.out.print(ConsoleColors.RESET);
                int currentIndex = resultSet.getInt("ID");
                if (index <= currentIndex) {
                    index = currentIndex + 1;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return index;
    }

    public static void showSpecificTaskType(Connection connection, int choice) {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM ToDoList";
            ResultSet resultSet = statement.executeQuery(query);
            ArrayList<Task> tasks = new ArrayList<>();
            while (resultSet.next()) {
                tasks.add(new Task(resultSet.getInt("ID"), LocalDate.parse(resultSet.getString("EndDate")), CategoryID.values()[resultSet.getInt("CategoryID") - 1], PriorityID.values()[resultSet.getInt("PriorityID") - 1], DifficultyID.values()[resultSet.getInt("DifficultyID") - 1], resultSet.getString("Title")));
            }
            if (choice == 1) {
                for (Task task : tasks) {
                    LocalDate today = LocalDate.now();
                    long diff = DAYS.between(today, task.getEndDate());
                    if (diff > 3 && task.getId() != 0) {
                        System.out.println(task);
                    }
                }
            }
            if (choice == 2) {
                for (Task task : tasks) {
                    LocalDate today = LocalDate.now();
                    long diff = DAYS.between(today, task.getEndDate());
                    if (diff <= 3 && task.getId() != 0 && (today.isBefore(task.getEndDate()) || today.isEqual(task.getEndDate()))) {
                        System.out.print(ConsoleColors.YELLOW);
                        System.out.println(task);
                    }
                }
                System.out.println(ConsoleColors.RESET);
            }

            if (choice == 3) {
                for (Task task : tasks) {
                    LocalDate today = LocalDate.now();
                    long diff = DAYS.between(today, task.getEndDate());
                    if (diff < 0 && task.getId() != 0) {
                        System.out.println(ConsoleColors.RED);
                        System.out.println(task);
                    }
                }
                System.out.println(ConsoleColors.RESET);
            }
            if (choice == 4) {
                for (Task task : tasks) {
                    if (task.getId() == 0) {
                        System.out.println(ConsoleColors.GREEN);
                        System.out.println(task);
                    }
                }
                System.out.println(ConsoleColors.RESET);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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
        try {
            Statement statement = connection.createStatement();
            String query = "DELETE FROM ToDoList WHERE ID = " + index + ";";
            statement.executeUpdate(query);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void filterTasks(Connection connection, int choiceCategory) {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM ToDoList WHERE CategoryID = " + choiceCategory + ";";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("ID") + " " + resultSet.getString("EndDate") + " " + CategoryID.values()[Integer.parseInt(resultSet.getString("CategoryID")) - 1] + " " + PriorityID.values()[Integer.parseInt(resultSet.getString("PriorityID")) - 1] + " " + DifficultyID.values()[Integer.parseInt(resultSet.getString("DifficultyID")) - 1] + " " + resultSet.getString("Title"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void markAsCompleted(Connection connection, int index) {
        try {
            Statement statement = connection.createStatement();
            String query = "UPDATE ToDoList SET ID = " + 0 + " WHERE ID = " + index;
            statement.executeUpdate(query);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
