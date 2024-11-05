import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class main extends JFrame{
	private static final int WIDTH =1800;
	private static final int HEIGHT=1600;
	
	public main () {
		super("KeyListener Demo");
		setSize(WIDTH, HEIGHT);
		Game play = new Game();
		((Component) play).setFocusable(true);
		
		Color RoyalBlue = new Color(22,13,193);
		
		
		setBackground(RoyalBlue);
		
		
		getContentPane().add(play);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	

	public static void main(String[] args) {
		main run = new main();
		

	}


}
