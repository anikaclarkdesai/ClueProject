
import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

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
import java.util.LinkedList;
import java.awt.event.*; 

public class Game  extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener{

private BufferedImage back; 
private int key, x, y;
private int amountofplayers, diceOne, diceTwo, diceCombo; //how many people are playing
private int cardbasicx, cardbasicy, cardbasicw, cardbasich;//sets the x and y of the basic card
private int icon1x, icon1y, icon1w, icon1h;//sets the x and y of the basic card
private HashMap <String, ArrayList <Cards>> cards;
private LinkedList <String> moves; //List of player movements
public ArrayList <Cards> deck;
public HashMap <Rectangle, Cards> pickChar;
private Cards tempCard; //speaks to the card class so I can access, tempCard gets the top card 
private ImageIcon Bg, CardBackground, defaultImage, AOC, Bernie, Donald, Kamala, Putin, Ted, Tim;
private boolean cardpicked;//checks if u clicked the caards at the beginnng of the game
private boolean cardclicked; //checks if you clicked the cards on the board
private boolean joincards;//checks if the center has been clicked and shuffles the cards accordingly
private boolean playerschosen, shuffled, CharacterPicked;//checks if player has selected how many players //shuffled is to prevent reshuffling
private boolean ongoingTurn, diceRolled, drawMoveSpaces, drawClickDice, rollOnlyOnce;//checks if player one is going or not //checks for teh dice roll
private boolean Up, down, left, right, wentAboveOGValue; //handles for the movement of characters
private Rectangle rectforchoice;//rectangle for the character choice

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
			moves = new LinkedList<String>();//creates a linked list of moves made by a character


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
			defaultImage= new ImageIcon("SuspectImages\\AOC.jpg");
			

			//character imagese
			AOC= new ImageIcon("SuspectImages\\AOC.jpg");
			Bernie= new ImageIcon("SuspectImages\\Bernie.jpg");
			Donald= new ImageIcon("SuspectImages\\Donald.jpg");
			Kamala= new ImageIcon("SuspectImages\\Kamala.jpg");
			Putin= new ImageIcon("SuspectImages\\Putin.jpg");
			Ted= new ImageIcon("SuspectImages\\Ted.jpg");
			Tim= new ImageIcon("SuspectImages\\TimWalz.jpg");

			CharacterPicked=false;
			pickChar= new HashMap<Rectangle, Cards>();
			//no moves have been made
			right=false; //says that down just moved
			//these are not the move just made
			Up=false;
			left= false;
			down=false;
		

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

		//g2d.drawImage(defaultImage.getImage(), 100, 100, 500, 500, this);
		g2d.setFont( new Font("Baskerville Old Face", Font.BOLD, 50));
		
		if(CharacterPicked==false)
			g2d.drawString("Pick a Character", 83,345 );
			choosePlayer(g2d);//chooses the player

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
					g2d.drawString("Place Charcter "+ (diceCombo)+ " Spaces" , x, y);
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
public void choosePlayer(Graphics g2d){
	int xval = 0;
	int yval=100;
	for(Cards suspect: setSuspects()){//for each suspect in the suspects arraylist
		g2d.setColor(Color.gray);//sets the color
		g2d.fillRoundRect(xval, yval-20, 100, 120,20,20);//draws a rectangle
		
		rectforchoice = new Rectangle(xval, yval, 100, 100);//creates new rectangle

		g2d.drawImage(suspect.getImage(), xval, yval, 100, 100, this);//draws the suspect in the top left corner
		
		
		pickChar.put(rectforchoice, suspect);//puts the suspect in the rectangle

		xval+=100;

	}
	//System.out.println(pickChar);


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
	
	ClueSheet(g2d);

}
public void rollDice(Graphics g2d){
	 diceOne = (int) ((Math.random()* 6)+1); //rolls a dice number between 1 and 6
	 diceTwo = (int) ((Math.random()* 6)+1); //rolls a second dice number between 1 and 6
	
	
	moves.clear();
	System.out.println("Dice 1: "+diceOne+ " Dice 2: "+diceTwo);
	diceCombo=diceOne+diceTwo;
		
	diceRolled=false;

		
		}

public void ClueSheet(Graphics g2d){
	//draw the suspects
	int xval= 1005, yval=45, yvaltext=100;
	int xval1= 1005+140, yval1=45;
	int xval2= 1005+140+140, yval2=45;
	Color Chestnut = new Color(96,60,20);
	Color PeachCream = new Color(246,233,191);

	g2d.setColor(Chestnut);
	g2d.setFont( new Font("Baskerville Old Face", Font.BOLD, 50));
	g2d.drawString("Notebook", 1065, 35);

	for(Cards suspect: setSuspects()){//for each suspect draw a rectangle and write their name
		g2d.setColor(Chestnut);
		g2d.fillRoundRect(xval,yval,100, 45, 20,20);

		g2d.setColor(PeachCream);
		g2d.setFont( new Font("Baskerville Old Face", Font.BOLD, 15));
		g2d.drawString(suspect.getName(), xval, yval+30);
		yval+=50;
	}

	
	for(Cards weapon: setWeapons()){//for each weapon draw a rectangle and write their name
		g2d.setColor(Chestnut);
		g2d.fillRoundRect(xval1,yval1,100, 45, 20,20);

		g2d.setColor(PeachCream);
		g2d.setFont( new Font("Baskerville Old Face", Font.BOLD, 15));
		g2d.drawString(weapon.getName(), xval1, yval1+30);
		yval1+=50;
	}
		
	for(Cards rooms: setRooms()){//for each room draw a rectangle and write their name
		g2d.setColor(Chestnut);
		g2d.fillRoundRect(xval2,yval2,100, 45, 20,20);

		g2d.setColor(PeachCream);
		g2d.setFont( new Font("Baskerville Old Face", Font.BOLD, 15));
		g2d.drawString(rooms.getName(), xval2, yval2+30);
		yval2+=50;
	}




	g2d.setColor(Color.black);
	g2d.setFont( new Font("Baskerville Old Face", Font.BOLD, 50));
}
	 
	 private void makeMove(Graphics g2d) {
		// TODO Auto-generated method stub
	boolean moveMade;
	moveMade=false;
	int i= diceCombo;//sets integer = to the initial dice combo
	
	g2d.drawImage(defaultImage.getImage(), icon1x, icon1y, icon1w, icon1h, this);
	
	if(diceCombo==0){//no more dice value
			//drawMoveSpaces=false;
			ongoingTurn=false;
	}

	WithinRoomBounds(g2d);
	/* 
	if(diceCombo>=i){//if dice combo goes above the original dice combo value
		wentAboveOGValue=true;
	}*/

}

public void WithinRoomBounds(Graphics g2d){
	/* 
	//for amazon warehouse
	if((icon1x>= 247) &&(icon1x>=255) && (icon1x+icon1w<= 280 ) &&(icon1y+icon1h>=280)){
		System.out.println("entered amazon warehouse");
	}
	//for pennsylvania
	if(((icon1x>= 305) &&(icon1x>=470) && (icon1x+icon1w<= 343) &&(icon1y+icon1h>=505))||
	 ((icon1x>= 245) &&(icon1x>=587) && (icon1x+icon1w<= 301) &&(icon1y+icon1h>=625))){
		System.out.println("entered  pennsylvania");
	}
	//for school nurse
	if((icon1x>= 270) &&(icon1x>=740) && (icon1x+icon1w<= 308 ) &&(icon1y+icon1h>=763)){
		System.out.println("school nurse");
	}
	//for border wall
	if(((icon1x>= 443) &&(icon1x>=674) && (icon1x+icon1w<= 567) &&(icon1y+icon1h>=706))||
	 ((icon1x>= 612) &&(icon1x>=727) && (icon1x+icon1w<= 656) &&(icon1y+icon1h>=759))){
		System.out.println("entered the border");
	}
	//for the captial; did not fin
*/
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
	
	
	/* 
	down=false;
	Up=false;
	left= false;
	right=false;
*/
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
//	wentAboveOGValue=false; //did not originally go over original value
	if (key==38) {       //up arrow  
		//System.out.println(ongoingTurn);       
		icon1y -= 50;
		diceCombo-=1;
		
		Up=true; //says that down just moved
		//these are not the move just made
		down=false;
		left= false;
		right=false;
		moves.add("up");

	} else if(key==40) {  //down arrow              
		icon1y += 50;
		diceCombo-=1;

		down=true; //says that down just moved
		//these are not the move just made
		Up=false;
		left= false;
		right=false;
		moves.add("down");
	} else if(key==37) {    //left arrow            
		icon1x -= 50;
		diceCombo-=1;

		left=true; //says that down just moved
		//these are not the move just made
		Up=false;
		down= false;
		right=false;
		moves.add("left");
	} else if(key==39) {  //right arrow              
		icon1x += 50;
		diceCombo-=1;

		right=true; //says that down just moved
		//these are not the move just made
		Up=false;
		left= false;
		down=false;
		moves.add("right");
	} 
	
	System.out.println("up is"+ Up);
   //while(diceCombo<diceTwo+diceOne){//makes sure that dicecombo cannot go above its original value
/*if(wentAboveOGValue==false)	{
   if (Up==true&&key==8) {       //up arrow  
				//System.out.println(ongoingTurn);       
				icon1y += 50;
				diceCombo+=1;
	} else if(down==true&&key==8) {  //down arrow              
				icon1y -= 50;
				diceCombo+=1;
	} else if(left==true&&key==8) {    //left arrow            
				icon1x += 50;
				diceCombo+=1;
	} else if(right==true&&key==8) {  //right arrow              
			icon1x -= 50;
				
			diceCombo+=1;
		}
   }*/

   if (key == 8) {//backspace key
	if (!moves.isEmpty()) {//if there are moves in the move list; so if dicecombo is max there will be nothing in the list
		String lastmove = moves.pop();//remove the most recent move
		if (lastmove.equals("up")) {//
			icon1y += 50;
			diceCombo+=1;
		} else if (lastmove.equals("down")) {
			icon1y -= 50;
			diceCombo+=1;
		} else if (lastmove.equals("left")) {
			icon1x += 50;
			diceCombo+=1;
		} else if (lastmove.equals("right")) {
			icon1x -= 50;
			diceCombo+=1;
		}
	}
   }

}
//}
	



if(shuffled==true && key==32 && ongoingTurn ==true && diceRolled==false && rollOnlyOnce==false ){ //if the cards have already been shuffled, space bar was pressed, it is player ones turn and they have not rolled the dice
	diceRolled=true;//the dice has been rolled
	//drawClickDice=false;
	drawMoveSpaces=true;//draw the spaces 
	rollOnlyOnce=true;//make sure it only rolls one time
	
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
	Rectangle MouseRect = new Rectangle(x, y, 1, 1);

	if(pickChar.get(rectforchoice).intersects(MouseRect)){//checks if the mouse is over the card
		CharacterPicked=true;
	}
}



@Override
public void mouseClicked(MouseEvent arg0) {
	// TODO Auto-generated method stub
	System.out.println("x="+arg0.getX()+ " y=" +arg0.getY());
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
