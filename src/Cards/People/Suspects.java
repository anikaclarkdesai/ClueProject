package Cards.People;
import java.awt.Graphics;

import javax.swing.ImageIcon;

import Cards.Cards;

public class Suspects extends Cards{
    private int x,y,w,h;
    
    public Suspects() {
        //TODO Auto-generated constructor stub
        super("Suspect", new ImageIcon("CardBackground"));
    } 

    public Suspects( ImageIcon i){
        super("Suspect", i);
    }

    public void drawChar(Graphics g2d) {
        g2d.drawImage(img.getImage(), x, y, w,h, null);
        
    }

    public String toString() {
        return "default Char";
    }
    public String health() {
        return "health";
    }
    public String damge() {
        return "damage: " ;
    }
    public String Weapon() {
        return "Ability: ";
    }

    
   
}