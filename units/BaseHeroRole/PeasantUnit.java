

import BaseHero.BaseHero;


public abstract class PeasantUnit extends BaseHero {

    protected int delivery;

    public PeasantUnit(String heroID) {
        super( heroID,  1, 1, 1,new int[]{1, 1},3);
        
        this.delivery = 1;
    }
   
}
