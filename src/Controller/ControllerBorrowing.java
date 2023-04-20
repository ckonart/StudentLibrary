/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import studentlibrary.Books;
import studentlibrary.Borrowing;
import studentlibrary.Students;

/**
 *
 * @author Caio Konart and Felipe Teixeira
 */

public class ControllerBorrowing {

    public static List<Borrowing> listEmprestimos = new ArrayList<>();

    public Borrowing borrowBook() {

        ControllerBooks mybook = new ControllerBooks();
        ControllerStudents myStd = new ControllerStudents();

        System.out.println("Enter the name of the book");
        Scanner myKB = new Scanner(System.in);
        String title = myKB.nextLine();
        Books book = mybook.searchByTitle(title, ControllerBooks.book);
        if (book != null) {

            System.out.println("Book found: ");
            System.out.println(book.getTitle() + " \t\t| " + book.getfName() + " \t\t| " + book.getlName() + " \t\t| " + book.getGenre());
            System.out.println("\n");

        } else {
            System.out.println("Book not found");
        }

        System.out.print("Enter the name of the student: ");
        myKB.nextLine();
        String studentName = myKB.nextLine();
        Students student = myStd.searchByName(studentName, ControllerStudents.students);
        if (student != null) {
            System.out.println("Student found: ");
            System.out.println(student.getFirstName() + " \t|\t" + student.getLastName() + " \t|\t" + student.getAddress() + " \t|\t" + student.getId());
            System.out.println("\n");
        } else {
            System.out.println("Student not found");
        }

        Borrowing meuEmp = new Borrowing();

        LocalDateTime date = LocalDateTime.now();
        meuEmp.setAvailable(false);
        meuEmp.setStartDate(date);
        meuEmp.setBook(book);
        meuEmp.setStudent(student);
        listEmprestimos.add(meuEmp);

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

        for (Borrowing Borrowing : listEmprestimos) {
            if (Borrowing.getStudent().getId() == student.getId() && Borrowing.getBook().getTitle().equals(book) && Borrowing.isAvailable() == false) {
                LocalDate endDate1 = LocalDate.now();
                Borrowing.setEndDate(endDate1);
                Borrowing.setAvailable(true);
                myemp = Borrowing;
                break;
            }
        }
    }
}
