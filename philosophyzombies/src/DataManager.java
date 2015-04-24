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

public class DataManager{
    
    // *SINGLETON* - only instance of DataManager private
    private static DataManager instance;
    
    public ArrayList<Student> students;
    public Professor professor;
    public State state;
    
    public Student studentLoggedIn;
    
    public Quiz quiz1;
    
    // *SINGLETON* - constructor is private
    private DataManager(){
        
        students = new ArrayList<Student>();
        // search in directory for all students and pull their data
        // we're going to hard-code in some students for the purposes of
        // simulation; we don't actually have a database to pull from
        // and searching for all of the save files 
        // is outside the scope of this project
        Student alexandra = new Student("Alexandra Willis", "asdf", 1, "lol");
        alexandra.gameData.add(3);
        alexandra.gameData.add(1);
        alexandra.quizData.add(3);
        alexandra.quizData.add(1);
        
        Student oli = new Student("Oli Sykes", "asdfff", 2, "lol");
        oli.gameData.add(1);
        oli.gameData.add(2);
        oli.quizData.add(3);
        oli.quizData.add(2);
        
        Student pete = new Student("Pete", "asdfsadf", 3, "lolo");
        
        
        students.add(alexandra);
        students.add(oli);
        students.add(pete);
        
        // similarly hard-coding the prof
        professor = new Professor("Prof. Tillian Pearson", "merp@merp.com", 10, "lolza");
        
        // creating a quiz for simulation purposes
        Question q1 = new Question("What was the utilitarian choice in this scenario: switching the track to hit the one person, or allowing it to hit the five?",
                                    "Switching", "Not switching", "_", "_", 0);
        Question q2 = new Question("From what you learned from this scenario, what is utility?",
                                    "Doing the right thing based on the action itself", 
                                    "Ambivalence towards suffering", 
                                    "Reducing the most amount of suffering", 
                                    "Belief that humans can not change fate", 2);
        Question q3 = new Question("True or False: Utilitarianism aims to chose moral actions based on their utility.",
                                    "True", "False", "_", "_", 0);
        ArrayList<Question> qs = new ArrayList<Question>();
        qs.add(q1);
        qs.add(q2);
        qs.add(q3);
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
    
    
    // Returns a list of all the students
    public ArrayList<Student> getStudents(){
        return students;
    }
    
    public double getAverageGrade(){
        int numStudents = students.size();
        int gradeSum = 0;
        
        for( Student s : students ){
            gradeSum += s.getGrade(quiz1);
        }
        
        return gradeSum/numStudents;
    }

    public double getGradeBySection(int sectionNum){ return 0.0; }

    
}