/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentlibrary;

/**
 *
 * @author caio_
 */
public class Book {

   private String id, fName, lName, title, genre;

    public Book(String id, String fName, String lName, String title, String genre) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.title = title;
        this.genre = genre;
        
    }

    public Book() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", fName=" + fName + ", lName=" + lName + ", title=" + title + ", genre=" + genre + ", waitingList=" + '}';
    }
    
    
    
}