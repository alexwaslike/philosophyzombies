/**
 * Authors: Alexandra Willis, Alex Herbert, Sarah Baldwin, Kristen Barrett
 * File: Student.java
 * Purpose: When instantiated, Student stores information for a studen user.
 *             (Model)
 * Course: CSC 3380
 * Instructor: Supratik
 */

import java.util.ArrayList;

public class Student extends User{

    public ArrayList<Integer> gameData;
    public ArrayList<Integer> quizData;
    
    public Student(String n, String e, int i, String p){
        super.name = n;
        super.email = e;
        super.ID = i;
        super.type = type.STUDENT;
        super.password = p;
        
        gameData = new ArrayList<Integer>();
        quizData = new ArrayList<Integer>();
    }
    
    public Student(String n, String e, int i, String p, ArrayList<Integer> gdata, ArrayList<Integer> qdata){
        super.name = n;
        super.email = e;
        super.ID = i;
        super.type = type.STUDENT;
        super.password = p;
        
        gameData = gdata;
        quizData = qdata;
    }
    
    public double getGrade(Quiz quiz){
        
        if(quizData.isEmpty()){
            return 0;
        }

        double numQuestions = (double)quiz.correctAnswers.size();
        double numCorrect = 0;
        for( int i=0; i<quizData.size(); i++ ){
            System.out.println("quiz answer: " + quiz.correctAnswers.get(i) + "student answer: " + quizData.get(i));
            if( quiz.correctAnswers.get(i) == quizData.get(i) )
                numCorrect++;
        }
        
        return (numCorrect/numQuestions)*100;
        
    }
    
    
    
    
}