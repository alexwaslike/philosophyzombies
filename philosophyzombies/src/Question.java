/**
 * Authors: Alexandra Willis, Alex Herbert, Sarah Baldwin, Kristen Barrett
 * File: Quiz.java
 * Purpose: When instantiated, a Quiz stores all of the questions and correct
 *          answers for a quiz.
 * Course: CSC 3380
 * Instructor: Supratik
 */

public class Question{
    
    public String question;
    public String a;
    public String b;
    public String c;
    public String d;
    // correctAnswer should be the number corresponding to the correct answer
    // 0 = a
    // 1 = b
    // 2 = c
    // 3 = d
    String correctAnswer;
    
    public Question(String q, String a, String b, String c, String d, String ca){
        question = q;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        correctAnswer = ca;
    }
    
    
    
}