package Cards;

import javax.swing.ImageIcon;

public class Cards {
    
    public String type;
    public ImageIcon img;


    public Cards() {
        type = "void";

    }

    public Cards(String typeofCard, ImageIcon i){ //imports the type of card
        type = typeofCard; //imports the type of card it is
        img= i; //imports the image 
    }

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