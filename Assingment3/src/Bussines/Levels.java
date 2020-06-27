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
    public boolean GameEnd(){
        if(Levels.size()<=NextLevel)
            return true;
        return false;
    }
    public List<String> NextLevel(){
        if(!GameEnd())
            return Levels.get(NextLevel++);
        return null;
    }
}
