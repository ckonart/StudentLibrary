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
import Model.Students;


/**
 *
 * @author Caio Konart and Felipe Teixeira
 */

public class ControllerStudents {

    static List<Students> students = new ArrayList<>();

    /*
      ReadStudents Method:
      The method readStudents is used to read a file.csv and store in a list of objects of type Students.
      it receives as a parameter a String filePath that mains path of the file to be read a 
      and throws a FileNotFoundException is a type exception if the file is not found.
     */
    public List<Students> readStudents(String fileName) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        boolean firstLine = true;

        while ((line = br.readLine()) != null) {
            if (firstLine) { // skip the first line
                firstLine = false;
                continue;
            }
            String[] data = line.split(",");  //splits our data using the comma to later add each value in your respective value
            String id = data[0];
            String firstName = data[1];
            String lastName = data[2];
            String address = data[3];
            Students std = new Students(id, firstName, lastName, address); //instanciate new object of a Student with the values that we predefined
            students.add(std);
        }
        br.close(); //close the reader
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
        for (Students student : students) {
            System.out.println("Student found: ");
            System.out.println("NAME: " + student.getFirstName() + " " + student.getLastName());
            System.out.println("ADDRESS: " + student.getAddress());
            System.out.println("ID: " + student.getId());
            System.out.println(" ");
        }
        System.out.println("\n");
    }

    /*  
      searchByName:
      the method searchByName is used to search a srudents by name and display for user informations about it
      it receive String name and List of Students as parameter 
     */
    public Students searchName(String name, List<Students> students) {
        //loop read file and try to find in first name or last name the user request
        for (Students student : students) {
            if (student.getFirstName().equalsIgnoreCase(name) || student.getLastName().equalsIgnoreCase(name)) {
                System.out.println(" ");
                return student;
            }
        }
        return null;

    }

    /*  
      searchByID:
      the method searchByID is used to search a srudents by ID and display for user informations about it
      it receive String id and List of Students as parameter 
     */
    public Students searchID(String id, List<Students> students) {
        //loop read file and try to find id that the user request
        for (Students student : students) {
            if (student.getId() == student.getId()) {
                System.out.println(" ");
                return student;
            }
        }
        return null;

    }
}
