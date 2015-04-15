/**
 * Authors: Alexandra Willis, Alex Herbert, Sarah Baldwin, Kristen Barrett
 * File: 
 * Purpose: SINGLETON
 * Course: CSC 3380
 * Instructor: Supratik
 */

import java.util.ArrayList;

public class DataManager{
    
    private static DataManager instance;
    
    public ArrayList<Student> students;
    public Professor professor;
    
    private DataManager(){
        
    }
    
    public DataManager instance(){
        if(instance == null)
            instance = new DataManager();
        return instance;
    }
    
    public ArrayList<Student> getStudents(){
        return students;
    }

    public ArrayList<Integer> getStudentData(int ID){return null;}
    
    public double getAverageGrade(){ return 0.0; }

    public double getGradeBySection(int sectionNum){ return 0.0; }

    
}