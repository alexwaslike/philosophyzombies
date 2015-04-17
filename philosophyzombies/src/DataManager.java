/**
 * Authors: Alexandra Willis, Alex Herbert, Sarah Baldwin, Kristen Barrett
 * File: 
 * Purpose: SINGLETON
 *          DataManager follows the SINGLETON design pattern so that only one of
 *          it exists at any point during the running of the program, so that 
 *          only one set of students and one professor exists at a time.
 *          
 *          The DataManager is used for storing and retrieving data about
 *          student's performance in the game and on quizzes. This project
 *          currently saves to a local file for simulation purposes, but in
 *          real life, would save class data to a remote database, perhaps
 *          through the class's web portal, like Moodle.
 * 
 * Course: CSC 3380
 * Instructor: Supratik
 */

import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.*;
import java.nio.file.*;
import java.io.*;
import java.util.Scanner;

public class DataManager{
    
    // *SINGLETON* - only instance of DataManager private
    private static DataManager instance;
    
    private ArrayList<Student> students;
    private Professor professor;
    public State state;
    
    public Quiz quiz1;
    
    // *SINGLETON* - constructor is private
    private DataManager(){
        
        students = new ArrayList<Student>();
        // search in directory for all students and pull their data
        // we're going to hard-code in some students for the purposes of
        // simulation; we don't actually have a database to pull from
        // and searching for all of the save files 
        // is outside the scope of this project
        Student alexandra = new Student("Alexandra", "asdf", 1, "lol");
        alexandra.gameData = new ArrayList<Integer>();
        alexandra.gameData.add(1);
        alexandra.gameData.add(2);
        alexandra.gameData.add(3);
        alexandra.quizData = new ArrayList<Integer>();
        alexandra.quizData.add(1);
        alexandra.quizData.add(2);
        alexandra.quizData.add(3);
        
        Student oli = new Student("Oli", "asdfff", 2, "lol");
        oli.gameData = new ArrayList<Integer>();
        oli.gameData.add(1);
        oli.gameData.add(2);
        oli.gameData.add(3);
        oli.quizData = new ArrayList<Integer>();
        oli.quizData.add(1);
        oli.quizData.add(2);
        oli.quizData.add(3);
        
        students.add(alexandra);
        students.add(oli);
        
        // similarly hard-coding the prof
        professor = new Professor("Bob", "merp@merp.com", 10, "lolza");
        
        // creating a quiz for simulation purposes
        Question q1 = new Question("What year is Alexandra's birthday?",
                                    "1991", "1992", "1993", "1994", "1994");
        Question q2 = new Question("What is Alexandra's favorite color?",
                                    "blue", "red", "green", "white", "red");
        ArrayList<Question> qs = new ArrayList<Question>();
        qs.add(q1);
        qs.add(q2);
        quiz1 = new Quiz(qs);
        
        // setting inital state; always display title screen first
        state = state.TITLE;
    }
    
    // *SINGLETON* - only way for other classes to access the DataManager
    //                  is through this method
    //                  it checks to see if the insance already exists
    //                  before creating a new one;
    //                  either way, it returns instance
    public static DataManager instance(){
        if(instance == null)
            instance = new DataManager();
        return instance;
    }
    
    
    /*
     * DATA PROCESSING METHODS
     *
     *
     */
    
    
    // Stores data to a user
    public void StoreData(User u, DataType type, ArrayList<Integer> data){
        
        ArrayList<Integer> prevData;
        if(type == DataType.GAME){
            students.get(students.indexOf(u)).gameData.addAll(data);
        }
        else if(type == DataType.GAME){
            students.get(students.indexOf(u)).quizData.addAll(data);
        }
    
    }
    
    // Returns ALL data from a specific user
    public ArrayList<Integer> LoadData(User u, DataType type){
        
        if(type == DataType.GAME){
            return students.get(students.indexOf(u)).gameData;
        }
        else if(type == DataType.GAME){
            return students.get(students.indexOf(u)).quizData;
        }
        
        return null;
    }
    
    // Returns a list of all the students
    public ArrayList<Student> getStudents(){
        return students;
    }
    
    public double getAverageGrade(){ return 0.0; }

    public double getGradeBySection(int sectionNum){ return 0.0; }

    
}