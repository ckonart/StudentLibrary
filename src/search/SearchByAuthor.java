/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package search; 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Books;

/**
 *
 * @author felipe
 */
public class SearchByAuthor {
    
    public void SearchByAuthor() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the Author first name to search: ");
            String name = reader.readLine();
            List<Books> records = loadData();
            Books book = linearSearch(records, name);
            if (book != null) {
                System.out.println("\nRecord found:");
                System.out.println("ID: " + book.getId());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getfName() + " " + book.getlName());
                System.out.println("Genre: " + book.getGenre() + "\n");
                
            } else {
                System.out.println("Record not found");
            }
        } catch (IOException ex) {
            Logger.getLogger(SearchByAuthor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Books> loadData() {

        List<Books> records = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/MOCK_DATA.csv"));
            String contentLine = br.readLine(); // ler a primeira linha que contém os cabeçalhos das colunas

            String[] data;
            String id,fName,lName, title,genre;

            while (contentLine != null) {

                data = contentLine.split(",");
                id = data[0];
                fName = data[1];
                lName = data[2];
                title = data[3];
                genre = data[4];

                records.add(new Books(id, fName, lName, title, genre));
                contentLine = br.readLine();
            }

        } catch (IOException ex) {
            Logger.getLogger(SearchByAuthor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return records;
    }

    public Books linearSearch(List<Books> array, String name) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getfName().equalsIgnoreCase(name)) {
                return array.get(i);
            }
            
            if (array.get(i).getlName().equalsIgnoreCase(name)) {
                return array.get(i);
            }
        }
        return null; 
    }

}
