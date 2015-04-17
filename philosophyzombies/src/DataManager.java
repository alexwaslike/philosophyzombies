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
    
    public ArrayList<Student> students;
    public Professor professor;
    public State state;
    
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
        
        
        // similarly hard-coding the prof
        professor = new Professor("Bob", "merp@merp.com", 10, "lolza");
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
     * DATA STORING (SAVING)/ LOADING METHODS
     */
    
    // Stores data into a user's file
    public void StoreData(User u, DataType type, ArrayList<Integer> data){
        
        // convert data to byte array
        byte[] bray = new byte[data.size()];
        for(int i=0; i<data.size(); i++)
            bray[i] = data.get(i).byteValue();
        
        // file name = username.txt
        Path p = Paths.get("./" + u.name + type + ".txt");
        
        // write data to user's file
        // if file exists, appends to end of file
           // otherwise, creates new file
        try (OutputStream out = new BufferedOutputStream(
            Files.newOutputStream(p, CREATE, APPEND))) {
            out.write(bray, 0, bray.length);
        } catch (IOException x) {
            System.err.println(x);
        }
    }
    
    // Returns ALL data from a user's file
    public ArrayList<Integer> LoadData(User u, DataType type){
        
        ArrayList<Integer> data = new ArrayList<Integer>();
        
        Path file = Paths.get("./" + u.name + type + ".txt");
        try (InputStream in = Files.newInputStream(file);
            BufferedReader reader =
            new BufferedReader(new InputStreamReader(in))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                Scanner s = new Scanner(line);
                while(s.hasNextInt())
                    data.add(s.nextInt());
            }
        } catch (IOException x) {
            System.err.println(x);
        }
        
        return data;
    }
    
    
    /*
     * DATA PROCESSING METHODS
     *
     *
     */
    
    // Returns a list of all the students
    public ArrayList<Student> getStudents(){
        return students;
    }
    
    public double getAverageGrade(){ return 0.0; }

    public double getGradeBySection(int sectionNum){ return 0.0; }

    
}