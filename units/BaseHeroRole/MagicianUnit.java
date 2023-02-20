

import BaseHero.BaseHero;

public abstract class MagicianUnit extends BaseHero{
    protected int magic;
    public MagicianUnit(String heroID, int attack,int protection,int[] damage,int speed) {
        super( heroID,  30, attack, protection, damage, speed);
        this.magic = 1;
    }

    public void healing() {
        
    }
    
}
