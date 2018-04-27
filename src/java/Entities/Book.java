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
public class Book {
    private String name;
    private String author;
    private String isbn;
    private String release_date;

    public Book(String name, String author, String isbn, String release_date) {
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.release_date = release_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }
    
}
