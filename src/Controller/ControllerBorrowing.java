/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import static Controller.ControllerBooks.book;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Model.Books;
import Model.Borrowing;
import Model.Students;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Caio Konart and Felipe Teixeira
 */

public class ControllerBorrowing {

    public static List<Borrowing> listBorrowings = new ArrayList<>();
    public Queue<Borrowing> waitingList = new LinkedList<>();

    public Borrowing borrowBook() {
        
        ControllerBooks mybook = new ControllerBooks();
        ControllerStudents myStd = new ControllerStudents();
        
        System.out.println("Enter the name of the book");
        Scanner myKB = new Scanner(System.in);
        String title = myKB.nextLine();
        Books book = mybook.searchByTitle(title, ControllerBooks.book);

        System.out.print("Enter the name of the student: ");
        String studentName = myKB.nextLine();
        Students student = myStd.searchByName(studentName, ControllerStudents.students);

        // Check if book and student exist
        if (book == null || student == null) {
            System.out.println("data not found");
            return null;
        }
        
        Borrowing meuEmp = new Borrowing();
  
        for (Borrowing emp : listBorrowings) {
        if (emp.getBook().equals(book) && emp.isAvailable() == false) {                
            
        // Add student to waiting list
        meuEmp.setStartDate(null);
        meuEmp.setBook(book);
        meuEmp.setStudent(student);
        meuEmp.setAvailable(false);
        waitingList.add(meuEmp);
        System.out.println("The book is not available. You have been added to the waiting list.");
          return null;
            }
        }
    
    LocalDate date = LocalDate.now();
    meuEmp.setStartDate(date.toString());
    meuEmp.setDueDate(date.plusDays(7).toString());
    meuEmp.setBook(book);
    meuEmp.setStudent(student);
    meuEmp.setAvailable(false);
    listBorrowings.add(meuEmp);
           
        return meuEmp;
    }
        
    
    public Borrowing returnBook() {

        ControllerBooks meuLivro = new ControllerBooks();
        ControllerStudents meuStd = new ControllerStudents();
        Borrowing myemp = new Borrowing();

        System.out.print("Enter the name of the student who is returning the book: ");
        Scanner myKB = new Scanner(System.in);
        String studentName = myKB.nextLine();
        Students student = meuStd.searchByName(studentName, ControllerStudents.students);
        if (student != null) {
            System.out.println("Student found: ");
            System.out.println(student.getFirstName() + " \t|\t" + student.getLastName() + " \t|\t" + student.getAddress() + " \t|\t" + student.getId());
            System.out.println("\n");
        } else {
            System.out.println("Student not found");
        }

        System.out.println("Enter the name of the book being returned:");
        String title = myKB.nextLine();
        Books book = meuLivro.searchByTitle(title, ControllerBooks.book);
        if (book != null) {
            System.out.println("Book found: ");
            System.out.println(book.getTitle() + " \t\t| " + book.getfName() + " \t\t| " + book.getlName() + " \t\t| " + book.getGenre());
            System.out.println("\n");
        } else {
            System.out.println("Book not found");
        }

        for (Borrowing Borrowing : listBorrowings) {
            if (Borrowing.getStudent().getId() == student.getId() && Borrowing.getBook().getTitle().equals(book) && Borrowing.isAvailable() == false) {
                Borrowing.setEndDate(LocalDate.now().toString());
                Borrowing.setAvailable(true);
                myemp = Borrowing;
                break;
            }
        }
        return myemp;
    }
    
        
    /*public List<Borrowing> readBorrowList(String filePath) throws FileNotFoundException {  
        // read a new file
        try ( Scanner myKB = new Scanner(new File(filePath))){
            
            // condition to skip the first line 
            if (myKB.hasNextLine()) {
                myKB.nextLine();
            }
            
            // loop read each line from filePath
            // Read a individual value, using comma as separator
            while (myKB.hasNextLine()) {
                String line = myKB.nextLine();
                String[] values = line.split(",");
                Borrowing newBorrow = new Borrowing(values[0], values[1], values[2], values[3]);
                listBorrowings.add(newBorrow);
            }
            
        // exception if happens a error to read filePath
        } catch (Exception e){
            System.out.println("error to read a file");
        }
        return book;
    }*/
    
    public void printWaitList() {
        System.out.println("Waiting list:");
        
            System.out.println(waitingList);
}
}