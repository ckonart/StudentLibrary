package studentlibrary;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author felipe
 */
public class Students {
    
   public String ID;
    public String Student_first_name;
    public String Student_last_name;
    public String Adreess;

    // Constructor
    public Students(String ID, String Student_first_name, String Student_last_name, String Adreess) {
        this.ID = ID;
        this.Student_first_name = Student_first_name;
        this.Student_last_name = Student_last_name;
        this.Adreess = Adreess;
    }

    // Getters and setters
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getStudent_first_name() {
        return Student_first_name;
    }

    public void setStudent_first_name(String Student_first_name) {
        this.Student_first_name = Student_first_name;
    }

    public String getStudent_last_name() {
        return Student_last_name;
    }

    public void setStudent_last_name(String Student_last_name) {
        this.Student_last_name = Student_last_name;
    }

    public String getAdreess() {
        return Adreess;
    }

    public void setAdreess(String Adreess) {
        this.Adreess = Adreess;
    }
    

    
}

