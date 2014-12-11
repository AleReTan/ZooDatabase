package net.reshetnikov.DBService;

import org.controlsfx.dialog.Dialogs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Service {

    //соединение с БД
    public static Connection connection = null;

    //подключение к БД
    public static Connection openDB() {
        String user = "root";                                   //логин
        String password = "Cs38093809";                         //пароль
        String url = "jdbc:mysql://localhost:3306/zoo";     //url адрес
        String driver = "com.mysql.jdbc.Driver";                //имя драйвера
        try {
            Class.forName(driver);//регистрация драйвера
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            //Присоединяемся и работа с БД
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            Dialogs.create()
                    .title("Error Dialog")
                    .masthead("Database Error")
                    .message("Database currently is unavailable.")
                    .showError();
            System.exit(0);
        }
        return connection;
    }

    //отключение от БД
    public static void closeDB() {
        //Закрываем все что открывали
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //получение соединения
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (connection != null && !connection.isClosed())
            return connection;
        openDB();
        return connection;
    }
}

