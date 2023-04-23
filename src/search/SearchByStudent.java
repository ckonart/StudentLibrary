/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package search;

import Model.Students;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author felipe
 */
public class SearchByStudent {
    
   public void SearchByName() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter a student name to search: ");
            String name = reader.readLine();
            List<Students> records = loadData();
            Students student = linearSearch(records, name);
            if (student != null) {
                System.out.println("\nRecord found:");
                System.out.println("ID: " + student.getId());
                System.out.println("Name: " + student.getFirstName()  + " " + student.getLastName());
                System.out.println("Address: " + student.getAddress() + "\n");
                
            } else {
                System.out.println("Record not found");
            }
        } catch (IOException ex) {
            Logger.getLogger(SearchByTitle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Students> loadData() {

        List<Students> records = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/STUDENTS.csv"));
            String contentLine = br.readLine(); // ler a primeira linha que contém os cabeçalhos das colunas

            String[] data;
            String id;
            String firstName;
            String lastName;
            String address;

            while (contentLine != null) {

                data = contentLine.split(",");
                id = data[0];
                firstName = data[1];
                lastName = data[2];
                address = data[3];
            

                records.add(new Students(id, firstName, lastName, address));
                contentLine = br.readLine();
            }

        } catch (IOException ex) {
            Logger.getLogger(SearchByTitle.class.getName()).log(Level.SEVERE, null, ex);
        }

        return records;
    }

    public Students linearSearch(List<Students> array, String name) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getFirstName().equalsIgnoreCase(name)) {
                return array.get(i);
            }
            
            if (array.get(i).getLastName().equalsIgnoreCase(name)) {
                return array.get(i);
            }
        }
        return null; 
        
}
}