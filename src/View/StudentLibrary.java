

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

        try {
            List<Books> books = myC.readLivros("src\\MOCK_DATA.csv");
            List<Students> std = myEst.readStudents("src\\STUDENTS.csv");
            //List<Borrowings> brw = myEmp

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
                System.out.println("10. Add a student to the queue");
                System.out.println("11. Check next student in queue for a book");
                System.out.println("12. Quit \n");
                System.out.println("Please select an option: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("All books by title: \n");
                        myC.listAll(books);
                        break;
                    case 2:
                        System.out.print("Enter the title of the book: ");
                        scanner.nextLine();
                        String title = scanner.nextLine();
                        Books book = myC.searchByTitle(title, books);

                        if (book != null) {
                            System.out.println("Book found: ");
                            System.out.println(book.getTitle() + " \t\t| " + book.getfName() + " \t\t| " + book.getlName() + " \t\t| " + book.getGenre());
                            System.out.println("\n");
                        } else {
                            System.out.println("Book not found");
                        }

                        break;

                    case 3:
                        System.out.print("Enter the Author's first name: ");
                        scanner.nextLine();
                        String myKB = scanner.nextLine();
                        Books Authorfname = myC.searchByAuthor(myKB, books);

                        if (Authorfname != null) {
                            System.out.println("Book found: ");
                            System.out.println(Authorfname.getTitle() + " \t\t| " + Authorfname.getfName() + " \t\t| " + Authorfname.getlName() + " \t\t| " + Authorfname.getGenre());
                            System.out.println("\n");
                        } else {
                            System.out.println("Author not found");
                        }
                        break;

                    case 4:
                        System.out.println("All students: \n");
                        myEst.listAllByName(std);
                        break;

                    case 5:
                        System.out.print("Enter the name of the student: ");
                        scanner.nextLine();
                        String studentName = scanner.nextLine();
                        Students student = myEst.searchByName(studentName, std);
                        if (student != null) {
                            System.out.println("Student found: ");
                            System.out.println(student.getFirstName() + " \t|\t" + student.getLastName() + " \t|\t" + student.getAddress() + " \t|\t" + student.getId());
                            System.out.println("\n");
                        } else {
                            System.out.println("Student not found");
                        }
                        break;

                    case 6:
                        System.out.print("Enter a student ID: ");
                        scanner.nextLine();
                        String studentID = scanner.nextLine();
                        Students student1 = myEst.searchByID(studentID, std);
                        if (student1 != null) {
                            System.out.println("Student found: ");
                            System.out.println(student1.getFirstName() + " \t|\t" + student1.getLastName() + " \t|\t" + student1.getAddress() + " \t|\t" + student1.getId());
                            System.out.println("\n");
                        } else {
                            System.out.println("Student not found");
                        }
                        break;

                    case 7:
                        myEmp.borrowBook();
                        System.out.println("Book borrowed with success!");
                        break;

                    case 8:
                        System.out.println(ControllerBorrowing.listBorrowings);
                        
                        break;

                    case 9:
                        myEmp.returnBook();
                        System.out.println(ControllerBorrowing.listBorrowings);
                        break;
                    case 10:
                        break;
                    case 11:
                      //myEmp.printWaitList();
                    break;
                      
                    case 12:
                }

            } while (choice != 12);

        } catch (FileNotFoundException e) {

        }

    }
}
