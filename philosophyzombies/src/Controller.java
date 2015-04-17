/**
 * Authors: Alexandra Willis, Alex Herbert, Sarah Baldwin, Kristen Barrett
 * File: 
 * Purpose:
 * Course: CSC 3380
 * Instructor: Supratik
 */

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JFrame;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Controller extends JFrame implements MouseListener{
    
    private Image offscrImage;
    private Graphics offscr;
    private Graphics graphics;
    
    public Controller(){
        addMouseListener(this);
        
        offscrImage = createImage(800, 600);
    	offscr = offscrImage.getGraphics();
    	
    	graphics = getGraphics();
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
        graphics.drawImage(offscrImage, 0, 0, this);
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
