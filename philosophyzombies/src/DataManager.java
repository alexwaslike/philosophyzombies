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
        professor = new Professor();
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
    public void StoreData(User u, ArrayList<Integer> data){
        
        // convert data to byte array
        byte[] bray = new byte[data.size()];
        for(int i=0; i<data.size(); i++)
            bray[i] = data.get(i).byteValue();
        
        // file name = username.txt
        Path p = Paths.get("./" + u.name + ".txt");
        
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
    public ArrayList<Integer> LoadData(User u){
        
        ArrayList<Integer> data = new ArrayList<Integer>();
        
        Path file = Paths.get("./" + u.name + ".txt");
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