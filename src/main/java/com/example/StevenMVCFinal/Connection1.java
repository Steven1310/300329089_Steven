package com.example.StevenMVCFinal;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection1 {

    public java.sql.Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        java.sql.Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost/loan", "root", "");
        return con1;
    }

}

