/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author linusdufol
 */
public class LibraryDAO {
    Connection conexion;
    /********************** Conectar / Desconectar *****************************/
    public void insertUser(User u) throws SQLException, ExceptionsPokemons {
        if (userExist(u)) {
            throw new ExceptionsPokemons("ERROR: A user with that name already exists");
        }
        String insert = "insert into user values (?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setString(1, u.getUsername());
        ps.setString(2, u.getPassword());
        ps.setInt(3, u.getStucoins());
        ps.setInt(4, u.getLevel());
        ps.setString(5, u.getPlace());
        ps.setInt(6, u.getPoints());
        ps.executeUpdate();
        ps.close();
    }
    public void connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/Library";
        String user = "root";
        String pass = "root";
        conexion = DriverManager.getConnection(url, user, pass);
    }

    public void disconnect() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }
}
