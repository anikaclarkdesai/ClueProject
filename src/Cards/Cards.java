package Cards;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Cards {

    public String type;
    public int x,y,w,h;
    public ImageIcon img;
    private ArrayList <Cards> cardtype;
    private String name;
    private ArrayList<int[]> entries;


        public Cards() {
            //sets the basic values of the card
            x= 411;
            y= 363;
            w= 186;
            h= 243;
            name= "void";
            type = "void";
            img= new ImageIcon("CardBackground.jpeg");
            ArrayList<int[]> entries = new ArrayList<>();

        }

        public Cards(int x, int y, String name, String typeofCard, ImageIcon i){ //imports the type of card
            this.x = x;
            this.y = y;
            w= 100;
            h= 100;
            this.name = name;//name of the character, weapon, or room
            this.type = typeofCard; //imports the type of card it is
            this.img= i; //imports the image 
        }
      
        /*    public void setType(Cards type){//acts to set the type of cards
            cardtype.add(type);//adds the type of class the card inherets from into an arraylist
    
        } */
        public Cards(int x, int y, int width, int height, String name, ArrayList<int[]> entries){ //imports the type of card
            this.x = x;
            this.y = y;
            this.w = width;
            this.h = height;
            this.name = name;//name of the character, weapon, or room
            this.entries = entries;

        }

    public Cards(String s){
            name =s;
    }

    public String getName(){
            return name;
    }
    public String toString(){
        return name;
    }
       

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }


    public Image getImage() {
        // TODO Auto-generated method stub
        return img.getImage();
    }
    public void setImage(ImageIcon img) {
        // TODO Auto-generated method stub
        this.img = img;
    }




    public void drawCard(Graphics g2d){
        g2d.drawImage(img.getImage(), x, y, w, h, null);//gets the image and put it the blank card space
        g2d.setFont( new Font("Baskerville Old Face", Font.PLAIN, 30));
        g2d.drawString(name, x+50, y+200);
        g2d.drawString(type, x+ 50, y+280);
    }

}



