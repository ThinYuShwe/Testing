package com.db_test;

import java.sql.Connection;
import java.sql.DriverManager;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private String ip = "localhost";
    private String port = "3306"; //It is the default port
    private String dbname = "test_db";
    private String username = "root";
    private String password = "";

    //only should use java.sql to not get error
    // it is better to write seperate parameters
    protected Connection get_Db_Connection() {
        Connection con = null; // to give return
        try {
            //need to careful there are no spaces between doublequotes
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/" + dbname, username, password);
            System.out.println("Successful Connection.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return con;
    }

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Main m = new Main();
        Connection con = m.get_Db_Connection();

        //need to add closing connection to get more marks

        try {
            if (con != null) {
                con.close(); //it will be better to check whether or not there is connection and then close
                System.out.println("Connection is closed.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}