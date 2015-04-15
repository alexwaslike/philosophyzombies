
import java.util.ArrayList;

/**
 * Authors: Alexandra Willis, Alex Herbert, Sarah Baldwin, Kristen Barrett
 * File: 
 * Purpose:
 * Course: CSC 3380
 * Instructor: Supratik
 */

public class Student extends User{

    public GameData gamedata;
    public QuizData quizdata;
    
    
    public Student(String n, String e, int i, Type t, String p){
        super.name = n;
        super.email = e;
        super.ID = i;
        super.type = type.STUDENT;
        super.password = p;
    }
    
    public void storeQuizData(Integer i){
        
    }
    
    public ArrayList<Integer> loadQuizData(){
        return quizdata.GetCompletedQuestions();
    }
    
    public void storeGameData(Integer i){
        
    }
    
    public ArrayList<Integer> loadGameData(){
        return gamedata.GetCompletedLevels();
    }






}