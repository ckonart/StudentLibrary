

package View;

import Controller.ControllerBooks;
import Controller.ControllerBorrowing;
import Controller.ControllerStudents;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import Model.Books;
import Model.Students;
import inpututils.InputUtils;
import search.SearchByAuthor;
import search.SearchById;
import search.SearchByStudent;
import search.SearchByTitle;


/**
 *
 * @author Caio Konart and Felipe Teixeira
 */
public class StudentLibrary {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        ControllerBooks myC = new ControllerBooks();
        ControllerStudents myEst = new ControllerStudents();
        ControllerBorrowing myEmp = new ControllerBorrowing();
        SearchByTitle sbt = new SearchByTitle();
        SearchByAuthor sba = new SearchByAuthor();
        SearchByStudent sbs = new SearchByStudent();
        SearchById sbi = new SearchById();
        try {
            List<Books> books = myC.readLivros("src\\MOCK_DATA.csv");
            List<Students> std = myEst.readStudents("src\\STUDENTS.csv");
            InputUtils myInput = new InputUtils();

            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                System.out.println("--------WELCOME TO OUR LIBRARY SYSTEM!!!--------- \n");
                System.out.println("1. List all books by title");
                System.out.println("2. Search for a specific book by title");
                System.out.println("3. Search for a specific book by Author's first name");
                System.out.println("4. List all Students ");
                System.out.println("5. Search Students by name");
                System.out.println("6. Search Students by ID");
                System.out.println("7. Register a student borrow");
                System.out.println("8. See information about books borrowed");
                System.out.println("9. Return a book");
                System.out.println("10. Check next student in queue for a book");
                System.out.println("11. Quit \n");
                choice = myInput.getUserInt("Please,Choose an option !");

                switch (choice) {
                    case 1:
                        System.out.println("All books by title: \n");
                        myC.listAll(books);
                        break;
                    case 2:
                        sbt.SearchByTitle();
                        break;

                    case 3:
                        sba.SearchByAuthor();
                        break;

                    case 4:
                        System.out.println("All students: \n");
                        myEst.listAllByName(std);
                        break;

                    case 5:
                        sbs.SearchByName();
                        break;

                    case 6:
                        sbi.SearchByid();
                        break;

                    case 7:
                        myEmp.borrowBook();
                        break;

                    case 8:
                        System.out.println(ControllerBorrowing.listBorrowings);
                        System.out.println("\n "
                                + "");

                        break;

                    case 9:
                        myEmp.returnBook();
                        System.out.println(ControllerBorrowing.listBorrowings);
                        break;

                    case 10:
                        myEmp.printWaitList();
                        break;

                    case 11:
                }

            } while (choice != 11);

        } catch (FileNotFoundException e) {

        }

    }
}
