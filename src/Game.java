
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
private int amountofplayers, diceOne, diceTwo, diceCombo; //how many people are playing
private int cardbasicx, cardbasicy, cardbasicw, cardbasich;//sets the x and y of the basic card
private int icon1x, icon1y, icon1w, icon1h;//sets the x and y of the basic card
private HashMap <String, ArrayList <Cards>> cards;
public ArrayList <Cards> deck;
private Cards tempCard; //speaks to the card class so I can access, tempCard gets the top card 
private ImageIcon Bg, CardBackground, defaultImage;
private boolean cardpicked;//checks if u clicked the caards at the beginnng of the game
private boolean cardclicked; //checks if you clicked the cards on the board
private boolean joincards;//checks if the center has been clicked and shuffles the cards accordingly
private boolean playerschosen, shuffled;//checks if player has selected how many players //shuffled is to prevent reshuffling
private boolean ongoingTurn, diceRolled, drawMoveSpaces, drawClickDice, rollOnlyOnce;//checks if player one is going or not //checks for teh dice roll
		
public Game() {
			new Thread(this).start();	
			this.addKeyListener(this);
			this.addMouseListener(this);
			this.addMouseMotionListener(this);
			key =-1; 
			x=0;
			y=0;
			amountofplayers =0;
			playerschosen =false;
			System.out.println("enter the amount of players");


			Bg = new ImageIcon("Clue.png"); 
			CardBackground = new ImageIcon("CardBackground.jpeg");

			cards = setCards();	//calls the all the cards in the hashmap
			deck = deck(); //calls all the cards in a players hand


			cardpicked= false; //checks if the temp card has been remove and if it has then to remove it from the pile and being drawn
			shuffled=false;//checks if it has been shuffled

			//the defualt cards integers
			cardbasicx=411;
				cardbasicy=363;
				cardbasicw=186;
				cardbasich=243;
			
			icon1x=411;
			icon1y=363;
			icon1w=45;
			icon1h =37;
			defaultImage= new ImageIcon("C:\\Users\\s1777744\\OneDrive - Houston Independent School District\\Compsci HL\\Clue\\ClueProject\\SuspectImages\\Kamala.png");
			
			//default dice values
			diceOne=0;
			diceTwo=0;
			diceCombo= 0;
			//JoinCards();
			drawMoveSpaces=false; //no spaces have been moved
			//drawClickDice =false; //no one has clicked the dice
			rollOnlyOnce = false; 
		
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

	public ArrayList<Cards> deck(){
		ArrayList<Cards> temp = new ArrayList<Cards>();

	return temp;
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
	
		g2d.clearRect(0,0,1400, 1000);
		g2d.drawImage(Bg.getImage(), 0,0, 1000, 975, this );

		g2d.setFont( new Font("Baskerville Old Face", Font.BOLD, 50));
		
	
		if(cardpicked==true){//checks if the center was pressed and if first card is being drawn
			drawCard(g2d);//draws the card 
		}
		if(joincards==true && playerschosen== true &&shuffled==false ){//checks if the cards need to be drawn
			JoinCards(g2d);//puts all the cards together
			joincards=false;//stops joining and shuffling card
		}
		if(shuffled==true){//checks if the cards have been joined and distributed
			BeginGame(g2d);
			//diceRolled =false;//sets that the roll has not started
			
			if(drawClickDice==true&& drawMoveSpaces==false){//draws click space to move dice when the dice havent been
				g2d.drawString("Click Space Bar to Roll Dice", 83,345 );
			
			}	
			if( drawMoveSpaces==true){//allows to draw how much is in the dice
					g2d.drawString("Dice 1: "+diceOne+ " Dice 2: "+diceTwo, 83, 345);
					g2d.drawString("Place Brick "+ (diceCombo)+ " Spaces" , x, y);
						if(ongoingTurn==true){
							makeMove(g2d);//allow the movement of charcters
									
							}
			}
			 	
		}

		if (cardclicked == true){
		showcards(g2d);
	}

twoDgraph.drawImage(back, null, 0, 0);

}


public void JoinCards(Graphics g2d){
	ArrayList <Cards> allCards = new ArrayList<>(); //creates arraylist of all cards


	//adds the sets of cards to all of the cards
	allCards.addAll(cards.get("Suspects"));
	allCards.addAll(cards.get("Weapons"));
	allCards.addAll(cards.get("Rooms"));


	
	Collections.shuffle(allCards);//shuffels all the cards put together
	System.out.println(allCards);


	

	cardpicked=true;//draws the card at the top
	
	distributeCards(allCards);
	CheckForTempValue(deck);
	
}


public void distributeCards(ArrayList<Cards> allCards){
ArrayList <ArrayList<Cards>> MasterDeck = new ArrayList<>();

	for(int i = 0; i<amountofplayers; i++){// for each amount of players make a deck
		ArrayList <Cards> playerdeck = new ArrayList<>();// makes the deck for the player
		MasterDeck.add(playerdeck);//adds the deck to the master deck
	}
	System.out.println("MasterDeck size"+MasterDeck.size());
/*for(Cards all: allCards){

}*/

// for every card in the allCards arraylist it will take each deck add the top card, when it goes through every deck it checks if the original deck is empty, if it isnt it repeats the for loop
	while(!allCards.isEmpty()){// while the original pile is not empty
	
		for(int i=0; i<MasterDeck.size(); i++){//for each card in the master deck
			if(!allCards.isEmpty()){
				MasterDeck.get(i).add(allCards.remove(0));//for each element in Master deck (the arraylist) add the first of allCards and remove that element
			}else {
				System.out.println("ran out of cards");
			}
		}
	//}
	}
	if(allCards.isEmpty()){
		for(int j=0; j<MasterDeck.size(); j++){//for each card in the master deck
			System.out.println("Player "+(j+1) + ":"+MasterDeck.get(j));
	}
		CheckForTempValue(MasterDeck.get(0));
		shuffled=true; //says that the deck has been shuffled and cannot be shuffled again

}

}


public void CheckForTempValue(ArrayList<Cards> c ){
	//if(cards.get("Rooms").contains(c)||cards.get("Suspects").contains(c)||cards.get("Weapons").contains(c)){ //checks if room card contains teh tempCard value
	//}


	System.out.println("Player One");
	}



	//major issue will not draw the card when pressed
		
private void drawCard(Graphics g2d) {
	// TODO Auto-generated method stub
	//g2d.drawImage(CardBackground.getImage(), cardbasicx, cardbasicy, cardbasicw, cardbasich, this);

	//System.out.println("Are we drawing");

	

}


private void showcards(Graphics g2d){
	///shows all the card in ones hand
}


//start of game mechanics

public void BeginGame(Graphics g2d){
	ongoingTurn=true;//sets that a turn has starteed
	drawClickDice=true;
			
	g2d.setFont( new Font("Baskerville Old Face", Font.BOLD, 50));
	
    if(diceRolled==true){
		rollDice(g2d);//runs the code that will roll the dice}
		drawClickDice=false;
		
	}else {
		
	}
	

}
public void rollDice(Graphics g2d){
	 diceOne = (int) ((Math.random()* 6)+1); //rolls a dice number between 1 and 6
	 diceTwo = (int) ((Math.random()* 6)+1); //rolls a second dice number between 1 and 6
	
	

	System.out.println("Dice 1: "+diceOne+ " Dice 2: "+diceTwo);
	diceCombo=diceOne+diceTwo;
		
	diceRolled=false;

		
		}
	 
	 private void makeMove(Graphics g2d) {
		// TODO Auto-generated method stub
	boolean moveMade;
	moveMade=false;

	g2d.drawImage(defaultImage.getImage(), icon1x, icon1y, icon1w, icon1h, this);
	
	if(diceCombo==0){
		    //drawMoveSpaces=false;
			ongoingTurn=false;
	}
		
	 }
	 private void spaceSize(){
		//x+45; 
		//y+37
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

if(playerschosen==false){//if the player size has not been chosen
	
	 if(key==50){
		amountofplayers=2;
		playerschosen= true;
	}else if(key==51){
		amountofplayers=3;
		playerschosen= true;
	}else if(key==52){
		amountofplayers=4;
		playerschosen= true;
	} else{
		System.out.println("Invalid Amount of Players");
	}
} 

if(ongoingTurn==true){//if the turn has started
	if (key==38) {         
		System.out.println(ongoingTurn);       
		icon1y += 50;
		diceCombo-=1;
	} else if(key==40) {                
		icon1y += 50;
		diceCombo-=1;
	} else if(key==37) {                
		icon1x -= 50;
		diceCombo-=1;
	} else if(key==39) {                
		icon1x += 50;
		diceCombo-=1;
	}
}



if(shuffled==true && key==32 && ongoingTurn ==true && diceRolled==false && rollOnlyOnce==false ){ //if the cards have already been shuffled, space bar was pressed, it is player ones turn and they have not rolled the dice
	diceRolled=true;
	//drawClickDice=false;
	drawMoveSpaces=true;
	rollOnlyOnce=true;
	
}
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
	System.out.println("you clicked at"+arg0.getX()+ arg0.getY());
	x=arg0.getX();
	y=arg0.getY();


	if((x>=413 && x<= 596)&&(y>=367 && y<=610)){//checks if the center of the board
		joincards=true;//joins all the cards and shuffles them
	}
	
	if((x>= cardbasicx && x< (cardbasicx+ cardbasicw)) &&( y> cardbasicy && y < cardbasicy +cardbasich)){ //checks where the card was drawn
		cardclicked =true;
	}
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
	
	

}
@Override
public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}





}
