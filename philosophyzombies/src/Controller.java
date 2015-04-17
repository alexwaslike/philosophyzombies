/**
 * Authors: Alexandra Willis, Alex Herbert, Sarah Baldwin, Kristen Barrett
 * File: 
 * Purpose:
 * Course: CSC 3380
 * Instructor: Supratik
 */

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Controller extends JFrame implements MouseListener{
    
    private JFrame frame;
    JButton studentButton;
    JButton professorButton;
    
    
    public Controller(){
        this(800, 600);
    }
    
    public Controller(int w, int h){
        addMouseListener(this);
        
        frame = new JFrame("Game Skeleton");
        frame.setSize(w, h);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        studentButton = new JButton("Student");
        studentButton.setBounds(50,30,200,25);
	frame.add(studentButton);
        professorButton = new JButton("Professor");
        professorButton.setBounds(50,60,200,25);
	frame.add(professorButton);
 
        studentButton.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                        final JFrame frame = new JFrame("Hello Student!");
                        frame.setSize(300, 150);
                        frame.setVisible(true);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        JButton playButton = new JButton("Play Game");
                        playButton.setBounds(50, 30, 200, 25);
                        frame.add(playButton);
                        JButton exitButton = new JButton("Exit");
                        exitButton.setBounds(50, 60, 200, 25); // Why is the exit button so large???
                        frame.add(exitButton);
                        playButton.addActionListener(
                            new ActionListener(){
                            public void actionPerformed(ActionEvent e) {
                            frame.dispose();
                            final JFrame frame = new JFrame("Playing the Game!");
                            frame.setSize(300, 150);
                            frame.setVisible(true);
                            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            JLabel gameLabel = new JLabel("Do the thing!");
                            JButton quizButton = new JButton("Take the quiz!"); // and the quiz button???
                            quizButton.setBounds(50, 30, 200, 25);
                            frame.add(quizButton);
                            quizButton.addActionListener(
                                new ActionListener(){
                                public void actionPerformed(ActionEvent e) {
                                frame.dispose();
                                final JFrame frame = new JFrame("Taking the Quiz!");
                                frame.setSize(300, 150);
                                frame.setVisible(true);
                                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                JLabel gameLabel = new JLabel("Quiz takin'");
                                JButton submitButton = new JButton("Submit the Quiz!"); // and the quiz button???
                                submitButton.setBounds(50, 30, 200, 25);
                                frame.add(submitButton);
                                submitButton.addActionListener(
                                    new ActionListener(){
                                    public void actionPerformed(ActionEvent e) {
                                    frame.dispose();
                                    final JFrame frame = new JFrame("Taking the Quiz!");
                                    frame.setSize(300, 150);
                                    frame.setVisible(true);
                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                    JLabel gameLabel = new JLabel("Score: A! Please close!");
                                    }});
                                }});
                            }});
                            exitButton.addActionListener(
                            new ActionListener(){
                            public void actionPerformed(ActionEvent e) {
                            System.exit(0);
                            }});
                        }});
        
        professorButton.addActionListener(
                new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                        final JFrame frame = new JFrame("Hello Professor!");
                        frame.setSize(300, 150);
                        frame.setVisible(true);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        JButton classButton = new JButton("Check Class Data");
                        classButton.setBounds(50, 30, 200, 25);
                        frame.add(classButton);
                        JButton exitButton = new JButton("Exit");
                        exitButton.setBounds(50, 60, 200, 25); // Why is the exit button so large???
                        frame.add(exitButton);
                        classButton.addActionListener(
                                new ActionListener(){
                                    public void actionPerformed(ActionEvent e) {
                                    frame.dispose();
                                    final JFrame frame = new JFrame("Class Scores");
                                    frame.setSize(300, 150);
                                    frame.setVisible(true);
                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                    JLabel gameLabel = new JLabel("Scores and stuff!");
                                    JButton exitButton = new JButton("Exit");
                                    exitButton.setBounds(50, 60, 200, 25); // Why is the exit button so large???
                                    frame.add(exitButton);
                                    exitButton.addActionListener(
                                            new ActionListener(){
                                                public void actionPerformed(ActionEvent e){
                                                    System.exit(0);
                                                }});
                                                }});
                        exitButton.addActionListener(
                                new ActionListener(){
                                public void actionPerformed(ActionEvent e){
                                System.exit(0);
                                }});
                             }});
                                
 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);

    }

    public void run(){
        State st = DataManager.instance().state;
        if(st == State.TITLE)
            renderTitle();
        else if(st == State.MENU)
            renderMenu();
        else if(st == State.GAME)
            renderGame();
        else if(st == State.QUIZ)
            renderQuiz();
        else if(st == State.RESULTS)
            renderResults();
        else if(st == State.CLASSDATA)
            renderData();
    }

    public void render(){
        frame.setVisible(true);
    }
    
    private void renderTitle(){
        
    }
    
    private void renderMenu(){
        
    }
    
    private void renderGame(){
        
    }
    
    private void renderQuiz(){
        
    }
    
    private void renderResults(){
        
    }
    
    private void renderData(){
        
    }
    
    public void mousePressed(MouseEvent e){}
    
    
    // We don't need these for this program, but need to define them
    // in order to implement MouseListener
    public void mouseReleased(MouseEvent e){}
    public void mouseClicked(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}

    
}
