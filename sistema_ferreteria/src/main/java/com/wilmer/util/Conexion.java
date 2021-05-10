/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wilmer.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author wilmer
 */
public abstract class Conexion {

    private static String url = "jdbc:mysql://localhost:3306/ferreteria?serverTimezone=UTC";
    private static String user = "root";
    private static String password = "1995Aser";
    private static Connection conn;

    public static Connection getInstance() throws SQLException {
        if (conn == null) {
            conn = DriverManager.getConnection(url, user, password);
        }
        return conn;
    }
}
