/**
 * Authors: Alexandra Willis, Alex Herbert, Sarah Baldwin, Kristen Barrett
 * File: Professor.java
 * Purpose: Contains information for the Professor. (Model)
 * Course: CSC 3380
 * Instructor: Supratik
 */

public class Professor extends User{

    public Professor(String n, String e, int i, String p){
        super.name = n;
        super.email = e;
        super.ID = i;
        super.type = type.PROFESSOR;
        super.password = p;
    }

}