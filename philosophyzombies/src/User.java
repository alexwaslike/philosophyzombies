/**
 * Authors: Alexandra Willis, Alex Herbert, Sarah Baldwin, Kristen Barrett
 * File: 
 * Purpose:
 * Course: CSC 3380
 * Instructor: Supratik
 */

public abstract class User{
    
    public enum Type{
        PROFESSOR, STUDENT  
    }
    
    public String name;
    public String email;
    public int ID;
    public Type type;
    public String password;
    
}