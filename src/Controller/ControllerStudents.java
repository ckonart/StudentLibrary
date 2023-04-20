/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import studentlibrary.Students;

public class ControllerStudents {
    
    static List<Students> students = new ArrayList<>();
    
    public List<Students> readStudents(String fileName) throws IOException {
        
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        boolean firstLine = true;
        
        while ((line = br.readLine()) != null) {
            if (firstLine) { // skip the first line
            firstLine = false;
            continue;
        }
            String[] data = line.split(",");
            String id = data[0];
            String firstName = data[1];
            String lastName = data[2];
            String address = data[3];
            Students std = new Students(id, firstName, lastName, address);
            students.add(std);
        }
        br.close();
        return students;
    }
    
    /*
      listAllbyNme Method:
      The listAll method is used list information about Students sorted by firstname and lastname . 
      it receive List as parameter thats contains informations for display foran user  
     */
    public void listAllByName(List<Students> students) {
        //  sort a list of book by firstname e second name
        students.sort(Comparator.comparing(Students::getFirstName).thenComparing(Students::getLastName));
               
        //  loop read all the information of student and display for user
        for (Students student: students) {
            System.out.println("NAME: " + student.getFirstName() + " " + student.getLastName());
            System.out.println("ADDRESS: " + student.getAddress());
            System.out.println("ID: " + student.getId());
            System.out.println(" ");
        }
        System.out.println("\n");
        
}
    /*  
      searchByAuthor:
      the method searchByAuthor is used to search a book by author firstname and display for user informations about it
      it receive String Author and List of books as parameter 
     */
    
    public Students searchByName(String name, List<Students> students) {
        
        for (Students student : students) {
            if (student.getFirstName().equalsIgnoreCase(name) || student.getLastName().equalsIgnoreCase(name)) {
                System.out.println(" ");
                return student;
            }
        }
        return null;
    
    }
}
