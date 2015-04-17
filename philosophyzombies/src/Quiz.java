/**
 * Authors: Alexandra Willis, Alex Herbert, Sarah Baldwin, Kristen Barrett
 * File: Quiz.java
 * Purpose: When instantiated, a Quiz stores all of the questions and correct
 *          answers for a quiz. (Model)
 * Course: CSC 3380
 * Instructor: Supratik
 */

import java.util.ArrayList;

public class Quiz{
    
    public ArrayList<Question> questions;
    public ArrayList<Integer> correctAnswers;
    
    public Quiz(ArrayList<Question> qs){
        questions = qs;
        
        correctAnswers = new ArrayList<Integer>();
        for( Question question : questions ){
            correctAnswers.add(question.correctAnswer);
        }
    }
    
    
    
}