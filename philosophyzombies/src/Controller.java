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
    JButton quizButton;
    JButton playButton;
    JButton submitButton;
    JButton classButton;
    JButton exitButton;
    
    int width;
    int height;
    
    public Controller(){
        this(800, 600);
    }
    
    public Controller(int w, int h){
        addMouseListener(this);
        width = w;
        height = h;
    }

    public void run(){
        State st = DataManager.instance().state;
        if(st == State.TITLE)
            renderTitle();
        else if(st == State.STUDENTMENU)
            renderStudentMenu();
        else if(st == State.PROFESSORMENU)
            renderProfessorMenu();
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
        frame = new JFrame("Game Skeleton"); // text for the title of the dialog
        frame.setSize(width, height); // the fuck is this
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // CLOSE PROGRAM WHEN YOU CLOSE THE DIALOG THIS IS IMPORTANT
        studentButton = new JButton("Student"); // button + name on button
        studentButton.setBounds(50,30,200,25); // size of button (w,h,x,y) i believe check the docs
	frame.add(studentButton); // do this to add ANYTHING to a box
        studentButton.addActionListener( // add dat listener
                new ActionListener(){ // create dat listener
                    public void actionPerformed(ActionEvent e) { // default click function
                        DataManager.instance().state = State.STUDENTMENU; // DECLARE THE STATE FIRST THING HERE
                        renderStudentMenu(); // render the state from this^
                    }
                });
        professorButton = new JButton("Professor");
        professorButton.setBounds(50,60,200,25);
	frame.add(professorButton);
        professorButton.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        DataManager.instance().state = State.PROFESSORMENU;
                        renderProfessorMenu();
                    }
                });
    }
    
    private void renderStudentMenu(){
                        // DO NOT RESTATE THE STATE IF IT WAS STATED PREVIOUSLY LIKE DAT^ or you'll have to click twice & that sucks
                        frame.dispose(); // if there is a previous button, start with dispose to remove last frame
                        final JFrame frame = new JFrame("Hello Student!");
                        frame.setSize(width, height);
                        frame.setVisible(true);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        JButton playButton = new JButton("Play Game");
                        playButton.setBounds(50, 30, 200, 25);
                        frame.add(playButton);
                        playButton.addActionListener(
                        new ActionListener(){
                            public void actionPerformed(ActionEvent e) {
                                DataManager.instance().state = State.GAME;
                                renderGame();
                            }
                        });
                        JButton exitButton = new JButton("Exit"); // any time you have an exit button, USE THIS FORMULA DOWN HERE
                        exitButton.setBounds(50, 60, 200, 25); // Why is the exit button so large???
                        frame.add(exitButton);
                        exitButton.addActionListener( // this works, press once
                        new ActionListener(){
                            public void actionPerformed(ActionEvent e) {
                                System.exit(0); // quits the program, closes the window, flees into the night, d for done, etc.
                            }
                        });
        
    }
    
    private void renderProfessorMenu(){
                        frame.dispose();
                        final JFrame frame = new JFrame("Hello Professor!");
                        frame.setSize(width, height);
                        frame.setVisible(true);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        JButton classButton = new JButton("Check Class Data");
                        classButton.setBounds(50, 30, 200, 25);
                        frame.add(classButton);
                        classButton.addActionListener(
                        new ActionListener(){
                            public void actionPerformed(ActionEvent e) {
                                DataManager.instance().state = State.CLASSDATA;
                                renderData();
                            }
                        });
                        JButton exitButton = new JButton("Exit");
                        exitButton.setBounds(50, 60, 200, 25); // Why is the exit button so large???
                        frame.add(exitButton);
                        exitButton.addActionListener(
                        new ActionListener(){
                            public void actionPerformed(ActionEvent e) {
                                System.exit(0);
                            }
                        });
    }
  
    
    private void renderGame(){
                            frame.dispose();
                            final JFrame frame = new JFrame("Playing the Game!");
                            frame.setSize(width, height);
                            frame.setVisible(true);
                            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            JLabel gameLabel = new JLabel("Do the thing!");
                            JButton quizButton = new JButton("Take the quiz!"); // and the quiz button???
                            quizButton.setBounds(50, 30, 200, 25);
                            frame.add(quizButton);
                            quizButton.addActionListener(
                            new ActionListener(){
                                public void actionPerformed(ActionEvent e) {
                                    DataManager.instance().state = State.QUIZ;
                                    renderQuiz();
                                }
                            });
    }
    
    private void renderQuiz(){
                                frame.dispose();
                                final JFrame frame = new JFrame("Taking the Quiz!");
                                frame.setSize(width, height);
                                frame.setVisible(true);
                                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                JLabel gameLabel = new JLabel("Quiz takin'");
                                JButton submitButton = new JButton("Submit the Quiz!"); // and the quiz button???
                                submitButton.setBounds(50, 30, 200, 25);
                                frame.add(submitButton);
                                submitButton.addActionListener(
                                new ActionListener(){
                                    public void actionPerformed(ActionEvent e) {
                                        DataManager.instance().state = State.RESULTS;
                                        renderResults();
                                    }
                                });
    }
    
    private void renderResults(){
                                    frame.dispose();
                                    final JFrame frame = new JFrame("Done the Quiz!");
                                    frame.setSize(width, height);
                                    frame.setVisible(true);
                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                    JLabel gameLabel = new JLabel("Score: A! Please close the window!"); // Text still not showing, look up text for buttons
    }
    
    private void renderData(){
                                    frame.dispose();
                                    final JFrame frame = new JFrame("Class Scores");
                                    frame.setSize(width, height);
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
    }
    
    public void mousePressed(MouseEvent e){}
    
    
    // We don't need these for this program, but need to define them
    // in order to implement MouseListener
    public void mouseReleased(MouseEvent e){}
    public void mouseClicked(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}

    
}
