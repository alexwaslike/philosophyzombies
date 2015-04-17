/**
 * Authors: Alexandra Willis, Alex Herbert, Sarah Baldwin, Kristen Barrett
 * File: Quiz.java
 * Purpose: When instantiated, a Question stores the information for 
 *           questions to be stored in a quiz. (Model)
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
    int correctAnswer;
    
    public Question(String q, String a, String b, String c, String d, int ca){
        question = q;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        correctAnswer = ca;
    }
    
    
    
}