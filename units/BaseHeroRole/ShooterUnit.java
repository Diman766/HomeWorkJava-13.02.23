

import BaseHero.BaseHero;

public abstract class ShooterUnit extends BaseHero {
    protected int shots;
    public ShooterUnit(String heroID, int hp,int attack,int protection,int[] damage,int speed, int shots) {
        super(heroID, hp,attack,protection,damage,speed);
        this.shots = shots;
    }
    
}
