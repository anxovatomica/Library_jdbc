/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Entities.*;
import Exception.LibraryException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author linusdufol
 */
public class LibraryDAO {
    Connection conexion;
    /********************** Search By x *****************************/
    public void partnerByEmail(String email) throws SQLException{
        String select = "select isbn from partner where email='" + email + "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);
        boolean exist = false;
        if(rs.next()){
            exist = true;
        }
        rs.close();
        st.close();
    }
   public Book getBookByIsbn(String isbn) throws SQLException, LibraryException{
        Book aux = new Book(isbn);
        if(!bookExist(aux)){
            throw new LibraryException("ERROR: There aren't any book with that isbn");
        }
        String select = "select * from book where isbn='" + isbn + "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);
        Book i = new Book();
        if(rs.next()){
            i.setName(rs.getString("name"));
            i.setAuthor(rs.getString("author"));
            i.setIsbn(rs.getString("isbn"));
            i.setRelease_date(rs.getString("release_date"));
        }
        rs.close();
        st.close();
        return i;
    }
    
    
    /********************** Exists *****************************/
    private boolean loanExist(Loan l) throws SQLException{
        String select = "select * from book where isbn='" + l.getId_loan()+ "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);
        boolean exist = false;
        if(rs.next()){
            exist = true;
        }
        rs.close();
        st.close();
        return exist;
    }
    private boolean partnerExist(Partner p) throws SQLException{
        
        String select = "select * from partner where email='" + p.getEmail()+ "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);
        boolean exist = false;
        if(rs.next()){
            exist = true;
        }
        rs.close();
        st.close();
        return exist;
    }
    private boolean bookExist(Book b) throws SQLException{
        String select = "select * from book where isbn='" + b.getIsbn()+ "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);
        boolean exist = false;
        if(rs.next()){
            exist = true;
        }
        rs.close();
        st.close();
        return exist;
    }
    /********************** Inserts *****************************/
    public void insertLoan(Loan l) throws SQLException, LibraryException {
        connect();
        if (loanExist(l)) {
            throw new LibraryException("ERROR: A partner with that email already exists: " + l.getId_loan());
        }
        
        String insert = "insert into Partner values (?, ?, ?, ?);";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setDate(1, (java.sql.Date) l.getRetirement_date());
        ps.setDate(2, (java.sql.Date) l.getDeliver_date());
        ps.setString(3, (l.getEmail().toString()));
        ps.setString(4, (l.getIsbn().toString()));
        ps.setString(5, (l.getId_loan().toString()));
        ps.executeUpdate();
        ps.close();
        disconnect();
    }
    public void insertBook(Book b) throws SQLException, LibraryException {
        connect();
        if (bookExist(b)) {
            throw new LibraryException("ERROR: A book with that isbn already exists");
        }
        String insert = "insert into Book values (?, ?, ?, ?);";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setString(1, b.getName());
        ps.setString(2, b.getAuthor());
        ps.setString(3, b.getIsbn());
        ps.setString(4, b.getRelease_date());
        ps.executeUpdate();
        ps.close();
        disconnect();
    }
    public void insertPartner(Partner p) throws SQLException, LibraryException {
        connect();
        if (partnerExist(p)) {
            throw new LibraryException("ERROR: A partner with that email already exists: " + p.getEmail());
        }
        String insert = "insert into Partner values (?, ?, ?, ?);";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setString(1, p.getName());
        ps.setString(2, p.getSurname());
        ps.setString(3, p.getEmail());
        ps.setString(4, p.getPassword());
        ps.executeUpdate();
        ps.close();
        disconnect();
    }
    /********************** Conectar / Desconectar *****************************/
    
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
