package Cards.Rooms;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class SupremeCourt extends Rooms{
    
    public SupremeCourt(){
        super("Supreme Court", new ImageIcon("Placeholder"));
    }

    public SupremeCourt(ArrayList<int[]> entries) {
        super(749 ,28, (989-749), (242-28), "Supreme Court", entries );
    }
}
