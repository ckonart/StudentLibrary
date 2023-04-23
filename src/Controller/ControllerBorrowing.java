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
import java.io.FileWriter;
import java.io.IOException;
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
        if (emp.getBook().equals(book) && emp.isAvailable() == false) {   //check if the book is available         
            
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
    // if the book is available, we set the start date for today using the method LocalDate.now()
    LocalDate date = LocalDate.now();
    meuEmp.setStartDate(date.toString());
    meuEmp.setDueDate(date.plusDays(7).toString()); //we decided to set the deadline to return the book in 7 days
    meuEmp.setBook(book);
    meuEmp.setStudent(student);
    meuEmp.setAvailable(false);
    listBorrowings.add(meuEmp); //the object meuEmp is add to the list of borrowings, representing a that a new loan was completed
    
    
    // creating a new list of Arrays to storage our record of loans in a .csv file right below
    List<String[]> dataLines = new ArrayList<>();
    String[] loanData = {student.getId(), student.getFirstName(), student.getLastName(), book.getTitle() + "," + meuEmp.getStartDate()};
    dataLines.add(loanData);

    try {
    FileWriter writer = new FileWriter("src\\BORROWINGS.csv"); //Using the File Writer, here we defines the path where we want to save our data

    for (String[] data : dataLines) {                                 
        writer.write(String.join(",", data));   //method to join the elements of the array into a single String separated by commas. It'will create a single line of data in the CSV file.
        writer.write("\n");
    }

    writer.close(); //closes the writer and save our information
    } catch (IOException e) {
        e.printStackTrace();
    }
    return meuEmp;
    }    
    
    public Borrowing returnBook() {
        
        //create objects to manage the data about Books and Students
        ControllerBooks meuLivro = new ControllerBooks();
        ControllerStudents meuStd = new ControllerStudents();
        Borrowing myemp = new Borrowing(); //instanciate a new Borrow object that we'll use it later on to set the parameters of the book that we are returning

        System.out.print("Enter the name of the student who is returning the book: ");
        Scanner myKB = new Scanner(System.in); //using scanner to get the user input for the student
        String studentName = myKB.nextLine(); 
        Students student = meuStd.searchByName(studentName, ControllerStudents.students); //code to use method that we already developed in Student class for search the student name
        if (student != null) {  //if the result of the search is different than "null", show the student that was found and his details
            System.out.println("Student found: ");
            System.out.println(student.getFirstName() + " \t|\t" + student.getLastName() + " \t|\t" + student.getAddress() + " \t|\t" + student.getId());
            System.out.println("\n");
        } else {
            System.out.println("Student not found"); //if null, returns this message of error
        }

        System.out.println("Enter the name of the book being returned:");
        String title = myKB.nextLine();
        Books book = meuLivro.searchByTitle(title, ControllerBooks.book);  //code to use method that we already developed in Book class for search the book title
        if (book != null) {  //if the result of the search is different than "null", show the book that was found and his details
            System.out.println("Book found: ");
            System.out.println(book.getTitle() + " \t\t| " + book.getfName() + " \t\t| " + book.getlName() + " \t\t| " + book.getGenre());
            System.out.println("\n");
        } else {
            System.out.println("Book not found"); //if null, returns this message of error
        }

        for (Borrowing Borrowing : listBorrowings) {  //for loop for our list of borrowed books
            if (Borrowing.getStudent().getId() == student.getId() && Borrowing.getBook().getTitle().equals(book) && Borrowing.isAvailable() == false) { //condition to confirm that the book was really borrowed
                Borrowing.setEndDate(LocalDate.now().toString()); //set our date of devolution for the day we call the method returnBook()
                Borrowing.setAvailable(true); // defines as true to set our book available again to future loans
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