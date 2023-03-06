package units;

import java.util.List;

public abstract class PeasantUnit extends BaseHero {

    public PeasantUnit(String heroID,int team, int x, int y) {
        super(heroID, 10,10, 1, 5, new int[] { 1, 1 }, 3, team, x, y);
       
    }

    @Override
    public void Step(List<BaseHero> twoTeam) {
        if (state != "Die") state = "Stand";
        
    }
}
