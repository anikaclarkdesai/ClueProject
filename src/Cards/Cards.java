package Cards;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Cards {
    
    public static String type;
    public ImageIcon img;
    private ArrayList <Cards> cardtype;


    public Cards() {
        type = "void";
        img= new ImageIcon("CardBackground.jpeg");

    }

    public Cards(String typeofCard, ImageIcon i){ //imports the type of card
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