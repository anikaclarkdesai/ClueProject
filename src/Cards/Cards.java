package Cards;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Cards {
    
    public String type;
    public int x,y,w,h;
    public ImageIcon img;
    private ArrayList <Cards> cardtype;


    public Cards() {
        //sets the basic values of the card
        x= 800;
        y= 400;
        w= 200;
        h= 200;
        type = "void";
        img= new ImageIcon("CardBackground.jpeg");

    }

    public Cards(String typeofCard, ImageIcon i){ //imports the type of card
        x= 800;
        y= 400;
        w= 200;
        h= 200;
        type = typeofCard; //imports the type of card it is
        img= i; //imports the image 
    }
    /*    public void setType(Cards type){//acts to set the type of cards
        cardtype.add(type);//adds the type of class the card inherets from into an arraylist

    } */

 

    public String type(){
        return "void";
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }
}