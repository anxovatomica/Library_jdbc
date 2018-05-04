/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import entities.*;
import Exception.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.LibraryDAO;
import Entities.Book;
import Entities.Loan;
import Entities.Partner;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author linusdufol
 */
@WebServlet(name = "NewLoan", urlPatterns = {"/NewLoan"})
public class NewLoan extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        LibraryDAO libraryDAO = new LibraryDAO();
        Date retirement_date = new Date(request.getParameter("retirment_date"));
        Date deliver_date = new Date(request.getParameter("deliver_date"));
        String email = request.getParameter("email");
        String isbn = request.getParameter("isbn");
        String id_loan = request.getParameter("id_loan");
        Loan l = new Loan(retirement_date, deliver_date, email, getBookByIsbn(isbn), id_loan);
        try {
            libraryDAO.insertLoan(l);
            request.setAttribute("status", "Book Created! :)");
            request.setAttribute("back", "index.html");
        } catch (LibraryException | SQLException ex) {
            request.setAttribute("status", ex.getMessage());
        }
        
        request.getRequestDispatcher("/final.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    try {
        processRequest(request, response);
    } catch (Exception ex) {
        Logger.getLogger(NewLoan.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    try {
        processRequest(request, response);
    } catch (Exception ex) {
        Logger.getLogger(NewLoan.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet de Alta Empleado";
    }// </editor-fold>

}
