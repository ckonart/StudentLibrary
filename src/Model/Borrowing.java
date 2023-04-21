/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;

/**
 *
 * @author felipe e Caio Konart
 */
public class Borrowing {
    
    private Books book;
    private Students student;
    private String startDate;
    private String dueDate;
    private String endDate;
    private boolean available;
    

    
    
    public Borrowing(Books book, Students student, String startDate, String endDate) {
        this.book = book;
        this.student = student;
        this.startDate = startDate;
        this.endDate = endDate;
        this.available = true;
    }

    public Borrowing() {
    }

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Borrowing{" + "book=" + book + ", student=" + student + ", startDate=" + startDate + ", dueDate=" + dueDate + ", endDate=" + endDate + ", available=" + available + '}';
    }
    
    
}