import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class main extends JFrame{
	private static final int WIDTH =1400;
	private static final int HEIGHT=1000;
	
	public main () {
		super("KeyListener Demo");
		setSize(WIDTH, HEIGHT);
		Game play = new Game();
		((Component) play).setFocusable(true);
		
		Color PeachCream = new Color(246,233,191);
		
		
		setBackground(PeachCream);
		
		
		getContentPane().add(play);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	

	public static void main(String[] args) {
		main run = new main();
		

	}


}
