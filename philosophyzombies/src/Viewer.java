
import javax.swing.JFrame;

/**
 * Authors: Alexandra Willis, Alex Herbert, Sarah Baldwin, Kristen Barrett
 * File: 
 * Purpose:
 * Course: CSC 3380
 * Instructor: Supratik
 */

public class Viewer {

    public static void main(String[] args) throws InterruptedException{
        Controller frame = new Controller();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        if (true) {
        	frame.run();
        	frame.render();
        	Thread.sleep(20); //20
        }
        
    }
    
    
}
