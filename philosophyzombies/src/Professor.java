/**
 * Authors: Alexandra Willis, Alex Herbert, Sarah Baldwin, Kristen Barrett
 * File: 
 * Purpose:
 * Course: CSC 3380
 * Instructor: Supratik
 */

public class Professor extends User{

    public Professor(){
        super.name = "empty";
        super.email = "empty";
        super.ID = -1;
        super.type = type.PROFESSOR;
        super.password = "empty";
    }
    
    public Professor(String n, String e, int i, Type t, String p){
        super.name = n;
        super.email = e;
        super.ID = i;
        super.type = type.PROFESSOR;
        super.password = p;
    }

}