

import BaseHero.BaseHero;

public abstract class WarriorUnit extends BaseHero{
    public WarriorUnit(String heroID, int hp,int attack,int protection,int[] damage,int speed) {
        super(heroID, hp, attack, protection, damage, speed);
    }
}
