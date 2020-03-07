import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {

	public Window(int width, int height, String title, Game game) {  //constructor of window takes in dimensions
		JFrame frame = new JFrame(title);  //create a new jframe object
		
		frame.setPreferredSize(new Dimension(width,height)); //set dimensions
		frame.setMaximumSize(new Dimension(width,height));
		frame.setMinimumSize(new Dimension(width,height));
		
		frame.add(game); //adds game class to the frame
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //ensures that the game stops running when window is closed
		frame.setLocationRelativeTo(null); //ensures that window is in center of screen when the game is launched
		frame.setVisible(true); //ensures that frame can be seen
	}
}
