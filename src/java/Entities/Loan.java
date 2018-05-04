/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author linusdufol
 */
public class Loan {

    private Date retirement_date;
    private Date deliver_date;
    private Book isbn;
    private Loan id_loan;
    private Partner email;

    public Loan(Date retirement_date, Date deliver_date, Partner email, Book isbn, Loan id_loan) {

        this.retirement_date = retirement_date;
        this.deliver_date = deliver_date;
        this.email = email;
        this.isbn = isbn;
        this.id_loan = id_loan;
    }

    

    public Loan(String retirement_date, String deliver_date, String email, String bn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Date getRetirement_date() {
        return retirement_date;
    }

    public void setRetirement_date(Date retirement_date) {
        this.retirement_date = retirement_date;
    }

    public Date getDeliver_date() {
        return deliver_date;
    }

    public void setDeliver_date(Date deliver_date) {
        this.deliver_date = deliver_date;
    }

    public Partner getEmail() {
        return email;
    }

    public void setEmail(Partner email) {
        this.email = email;
    }

    public Book getIsbn() {
        return isbn;
    }

    public void setIsbn(Book isbn) {
        this.isbn = isbn;
    }

    public Loan getId_loan() {
        return id_loan;
    }

    public void setId_loan(Loan id_loan) {
        this.id_loan = id_loan;
    }

}
