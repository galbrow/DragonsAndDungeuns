package Bussines;

import javax.swing.text.StyledEditorKit;
import java.util.List;

public class Levels {
    private List<List<String>> Levels;
    private int NextLevel;
    public Levels(List<List<String>> Levels){
        this.Levels=Levels;
        NextLevel=0;
    }
    //checks if the game ended
    public boolean GameEnd(){
        if(Levels.size()<=NextLevel)
            return true;
        return false;
    }

    //gets the next level string
    public List<String> NextLevel(int size) {
        if (size == 0) {
            if (!GameEnd())
                return Levels.get(NextLevel++);
            else {
                throw new NullPointerException("You won!");
            }
        }
        return Levels.get(NextLevel);
    }
}
