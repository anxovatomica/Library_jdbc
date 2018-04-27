/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Entities.*;
import Exception.LibraryException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author linusdufol
 */
public class LibraryDAO {
    @PersistenceUnit EntityManagerFactory emf;
    Connection conexion;
    private boolean partnerExist(Partner p) throws SQLException{
        connect();
        String select = "select * from partner where email='" + p.getEmail()+ "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);
        boolean exist = false;
        if(rs.next()){
            exist = true;
        }
        rs.close();
        st.close();
        disconnect();
        return exist;
    }
    private boolean bookExist(Book b) throws SQLException{
        connect();
        String select = "select * from book where isbn='" + b.getIsbn()+ "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);
        boolean exist = false;
        if(rs.next()){
            exist = true;
        }
        rs.close();
        st.close();
        disconnect();
        return exist;
    }
    /********************** Conectar / Desconectar *****************************/
    public void insertBook(Book b) throws SQLException, LibraryException {
        connect();
        if (bookExist(b)) {
            throw new LibraryException("ERROR: A book with that isbn already exists");
        }
        String insert = "insert into books values (?, ?, ?, ?);";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setString(0, b.getName());
        ps.setString(1, b.getAuthor());
        ps.setString(2, b.getIsbn());
        ps.setString(3, b.getRelease_date());
        ps.executeUpdate();
        ps.close();
        disconnect();
    }
    private void connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/Library";
        String user = "root";
        String pass = "root";
        conexion = DriverManager.getConnection(url, user, pass);
    }

    private void disconnect() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }
}
