

import BaseHero.BaseHero;

public abstract class ShooterUnit extends BaseHero {
    public ShooterUnit(String heroID) {
        super(heroID, 150, 80, 80);
        this.arrows = 10;
    }
    protected int arrows;
}
