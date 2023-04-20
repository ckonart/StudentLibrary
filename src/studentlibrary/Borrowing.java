/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentlibrary;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author felipe e 
 */
public class Borrowing {
    
    private Books book;
    private Students student;
    private LocalDate startDate;
    private LocalDate dueDate;
    private LocalDate endDate;
    private boolean available;
    //private List<Livros> borrowedBooks;

    
    
    public Borrowing(Books book, Students student, LocalDate startDate, LocalDate endDate) {
        this.book = book;
        this.student = student;
        this.startDate = startDate;
        this.endDate = endDate;
        this.available = true;
        //this.borrowedBooks = new ArrayList<>();
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = LocalDate.now();
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = startDate.plusDays(7);
    }
    
    

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
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
        return "Emprestimos:\n" + "book=" + book + "\n student=" + student + "\n startDate=" + startDate + "\n dueDate=" + dueDate + "/n endDate=" + endDate + "/n available=" + available + '}';
    }
    
    
    
    
    
}
