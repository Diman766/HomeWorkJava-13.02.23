
import java.util.List;

import BaseHero.BaseHero;

public abstract class PeasantUnit extends BaseHero {

    private int delivery;

    public PeasantUnit(String heroID,int team, int x, int y) {
        super(heroID, 1,1, 1, 1, new int[] { 1, 1 }, 3, team, x, y);

        this.delivery = 1;
    }

    @Override
    protected void Step(List<BaseHero> twoTeam) {
        if (state != "Die") state = "Stand";
        
    }

}
