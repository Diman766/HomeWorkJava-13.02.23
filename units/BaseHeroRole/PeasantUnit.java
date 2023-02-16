

import BaseHero.BaseHero;


public abstract class PeasantUnit extends BaseHero {

    protected int food;

    public PeasantUnit(String heroID) {
        super( heroID,  100, 10, 10);
        
        this.food = 5;
    }
   
}
