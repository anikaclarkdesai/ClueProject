
import javax.swing.*;

import Cards.Cards;
import Cards.People.AOC;
import Cards.People.Bernie;
import Cards.People.Donald;
import Cards.People.KamalaHarris;
import Cards.People.Putin;
import Cards.People.Suspects;
import Cards.People.TedCruz;
import Cards.People.TimWalz;
import Cards.Rooms.Capital;
import Cards.Rooms.Pennsylvania;
import Cards.Rooms.PlannedParenthood;
import Cards.Rooms.Rooms;
import Cards.Rooms.SchoolNurse;
import Cards.Rooms.TheBorder;
import Cards.Rooms.WallStreet;
import Cards.Weapons.Auditor;
import Cards.Weapons.EmailRecords;
import Cards.Weapons.Fillibuster;
import Cards.Weapons.Indictments;
import Cards.Weapons.Inflation;
import Cards.Weapons.Propaganda;
import Cards.Weapons.VoterFraud;
import Cards.Weapons.Weapons;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.awt.event.*; 


public class Game  extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener{

	
	private BufferedImage back; 
	private int key, x, y;
	private HashMap <String, ArrayList <Cards>> cards;
	private ImageIcon Bg;
	
	
		
		public Game() {
			new Thread(this).start();	
			this.addKeyListener(this);
			this.addMouseListener(this);
			this.addMouseMotionListener(this);
			key =-1; 
			x=0;
			y=0;
			
			Bg = new ImageIcon("Clue.png"); 


			cards = setCards();	//calls the all the cards in the hashmap



			JoinCards();
		 
		
	}
	public HashMap <String, ArrayList <Cards>> setCards(){
		HashMap <String, ArrayList<Cards>> temp = new HashMap<>();
			temp.put("Suspects", setSuspects()); //sets the supsect type cards
			temp.put("Weapons", setWeapons());
			temp.put("Rooms", setRooms());
					
			return temp;
			}
						
					
					
	private ArrayList<Cards> setSuspects() { //writes the suspect arraylists from the classes of suspects
			// TODO Auto-generated method stub
		ArrayList <Cards> temp = new ArrayList<Cards>();
			temp.add(new Donald());
			temp.add(new AOC());
			temp.add(new Bernie());
			temp.add(new KamalaHarris());
			temp.add(new Putin());
			temp.add(new TedCruz());
			temp.add(new TimWalz());
			return temp;
		}

	private ArrayList<Cards> setWeapons() { //writes the weapons into arraylist from the types of weapons
		ArrayList<Cards> Weapons = new ArrayList<Cards>();
			Weapons.add(new Auditor());
			Weapons.add(new EmailRecords());
			Weapons.add(new Fillibuster());
			Weapons.add(new Indictments());
			Weapons.add(new Inflation());
			Weapons.add(new Propaganda());
			Weapons.add(new VoterFraud());
		return Weapons;
	}

	private ArrayList<Cards> setRooms(){//writes the rooms into arraylist from the types of rooms
	ArrayList<Cards> Rooms = new ArrayList<Cards>();
			Rooms.add(new Capital());
			Rooms.add(new Pennsylvania());
			Rooms.add(new PlannedParenthood());
			Rooms.add(new SchoolNurse());
			Rooms.add(new TheBorder());
			Rooms.add(new WallStreet());
		return Rooms;
	}


			public void run()
	   {
	   	try
	   	{
	   		while(true)
	   		{
	   		   Thread.currentThread().sleep(5);
	            repaint();
	         }
	      }
	   		catch(Exception e)
	      {
	      }
	  	}
	

	
	
	
	public void paint(Graphics g){
		
		Graphics2D twoDgraph = (Graphics2D) g; 
		if( back ==null)
			back=(BufferedImage)( (createImage(getWidth(), getHeight()))); 
		

		Graphics g2d = back.createGraphics();
	
		g2d.clearRect(0,0,getSize().width, getSize().height);
		g2d.drawImage(Bg.getImage(), 0,0, getSize().width , getSize().height, this );


		g2d.setFont( new Font("Broadway", Font.BOLD, 50));
		
		g2d.drawString("Hello!" , x, y);
		
		
	
		twoDgraph.drawImage(back, null, 0, 0);

	}

	public void JoinCards(){
		
		
		ArrayList <Cards> allCards = new ArrayList<>(); //creates arraylist of all cards
			
		
		//adds the sets of cards to all of the cards
		allCards.addAll(cards.get("Suspects"));
		allCards.addAll(cards.get("Weapons"));
		allCards.addAll(cards.get("Rooms"));

		
		Collections.shuffle(allCards);//shuffels all the cards put together
				System.out.println(allCards);
		
		Cards tempCard =allCards.remove(0); // removes the first card
		CheckForTempValue(tempCard);
	}


	public void CheckForTempValue(Cards c){
		if(cards.get("Rooms").contains(c)){ //checks if room card contains teh tempCard value
			//ad player
			System.out.println("Rooms contain Temp Value");
	}
	}
	

	//DO NOT DELETE
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}




//DO NOT DELETE
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		key= e.getKeyCode();
		System.out.println(key);
		
		
		
	
	}


	//DO NOT DELETE
	@Override
	public void keyReleased(KeyEvent e) {
		
		
		
		
	}



	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		x=arg0.getX();
		y=arg0.getY();
	}



	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("entered");
	}



	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("exited");
	}



	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		System.out.println("you clicked at"+ arg0.getY());
		x=arg0.getX();
		y=arg0.getY();
		
	}



	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	

	
}
