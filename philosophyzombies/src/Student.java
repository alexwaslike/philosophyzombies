
import java.util.ArrayList;

/**
 * Authors: Alexandra Willis, Alex Herbert, Sarah Baldwin, Kristen Barrett
 * File: 
 * Purpose:
 * Course: CSC 3380
 * Instructor: Supratik
 */

public class Student extends User{

    public ArrayList<Integer> gameData;
    public ArrayList<Integer> quizData;
    
    public Student(String n, String e, int i, String p){
        super.name = n;
        super.email = e;
        super.ID = i;
        super.type = type.STUDENT;
        super.password = p;
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
    
    public int getGrade(Quiz quiz){
        
        int numQuestions = quiz.correctAnswers.size();
        int numCorrect = 0;
        for( int i=0; i<quizData.size(); i++ ){
            if( quiz.correctAnswers.get(i) == quizData.get(i) )
                numCorrect++;
        }
        
        return (numCorrect/numQuestions)*100;
        
    }
    
    
    
}