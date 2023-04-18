/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import studentlibrary.Books;

/**
 *
 * @author felipe
 */


public class ControllerBooks {

    static List<Books> book = new ArrayList<>();

    /*
        ReadBooks Method:
        The method readBooks is used to read a file.csv and store in a list of objects of type Books.
        it receives as a parameter a String filePath that mains path of the file to be read a 
        and throws a FileNotFoundException is a type exception if the file is not found.
    */
    public List<Books> readBooks(String filePath) throws FileNotFoundException {
    
    // Try read a file using Scanner
        try (Scanner myKB = new Scanner(new File(filePath))) {
    // Condition if, has next line for myKB read 
            if (myKB.hasNextLine()){
                myKB.nextLine();
            }

    //   The loop while reads each line from the filePath 
    //   It is used to split the line into individual values, using a comma as a separator.      
    
          while (myKB.hasNextLine()) {
                String linha = myKB.nextLine();
                String[] valores = linha.split(",");
                Books newBook = new Books(valores[0], valores[1], valores[2], valores[3], valores[4]);
                book.add(newBook);
               } 
            
    
    //  If there is an exception while reading the file, the message displays for user.
        } catch (Exception e) {
            System.out.println("Error to read a file");
        }
        return book;

    }
    
    /*
     ListAll Method:
    The ListAll method is used to sort the list of books by title in ascending order. 
    it receive List as parameter thats contains informations that need to be display
    
    */
    public void listAll(List<Books> books) {
        
    //  sort a list ofbook by title
        books.sort(Comparator.comparing(Books::getTitle));
        
    //  loop to read all the books
        for (Books book : books) {
            System.out.println("TITLE: " + book.getTitle());
            System.out.println("NAME: " + book.getfName() + " " + book.getlName());
            System.out.println("GENRE: " + book.getGenre());
            System.out.println("ID: " + book.getId() + "\n");
        }
        System.out.println("\n");
    }

}
