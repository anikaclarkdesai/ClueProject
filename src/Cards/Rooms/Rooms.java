package Cards.Rooms;
import Cards.Cards;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Rooms extends Cards{
    
    public Rooms(int i, int j, int k, int l, String string, ArrayList<int[]> entrypoint) {
        super(i, j, k, l, string, entrypoint);
    }
    
    public Rooms(String name,  ImageIcon i){
        super(100, 100 ,name,  "Rooms", i);
    }

    




}