

package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import Model.Books;

/**
 *
 * @author Caio Konart and Felipe Teixeira
 */

public class ControllerBooks {

    static List<Books> book = new ArrayList<>();

    /*
      ReadBooks Method:
      The method readBooks is used to read a file.csv and store in a list of objects of type Books.
      it receives as a parameter a String filePath that mains path of the file to be read a 
      and throws a FileNotFoundException is a type exception if the file is not found.
     */
    public List<Books> readLivros(String filePath) throws FileNotFoundException {  
        // read a new file
        try ( Scanner myKB = new Scanner(new File(filePath))){
            
            // condition to skip the first line 
            if (myKB.hasNextLine()) {
                myKB.nextLine();
            }
            
            // loop read each line from filePath
            // Read a individual value, using comma as separator
            while (myKB.hasNextLine()) {
                String linha = myKB.nextLine();
                String[] valores = linha.split(",");
                Books newBook = new Books(valores[0], valores[1], valores[2], valores[3], valores[4]);
                book.add(newBook);
            }
            
        // exception if happens a error to read filePath
        } catch (Exception e){
            System.out.println("error to read a file");
        }
        return book;
    }

    /*
      listAll Method:
      The listAll method is used list informations about book sorted by title . 
      it receive List as parameter thats contains informations that need to be display  
     */
    public void listAll(List<Books> books) {
        //  sort a list of book by title
        books.sort(Comparator.comparing(Books::getTitle)); // ordena os livros pelo título
        System.out.println("All books by title: \n");

        //  loop read all the information of books and display for user
        for (Books book : books) {
            System.out.println("TITLE: " + book.getTitle());
            System.out.println("NAME: " + book.getfName() + " " + book.getlName());
            System.out.println("GENRE: " + book.getGenre());
            System.out.println("ID: " + book.getId() + "\n");
        }
        System.out.println("\n");
    }

    /*  
      searchByTitle:
      the method searchByTitle is used to search a book by title and display for user informations about it
      it receive as parameter String title and List of books
     */
    public Books searchTitle(String title, List<Books> books) {

        for (Books book : books) {
            //condition if user insert a title of book, they will return all the infomations about it
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("");
                return book;
            }
        }
        // if doesnt find a book will return null
        return null;
    }
    
    
    /*  
      searchByAuthor:
      the method searchByAuthor is used to search a book by author firstname and display for user informations about it
      it receive String Author and List of books as parameter 
     */
    public Books searchAuthor(String Author, List<Books> books) {

        for (Books book : books) {
            //condition if user insert an author firstname, they will return all the infomations about it
            if (book.getfName().equalsIgnoreCase(Author)) {
                System.out.println(" ");
                return book;
            }
        }
        // if doesnt find an author firstname will return null
        return null;
    }
}
