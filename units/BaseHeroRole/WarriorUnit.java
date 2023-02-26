
import BaseHero.BaseHero;

public abstract class WarriorUnit extends BaseHero {
    public WarriorUnit(String heroID, int hp,int maxHp, int attack, int protection, int[] damage, int speed,int team, int x, int y) {
        super(heroID, hp,maxHp, attack, protection, damage, speed,team, x, y);
    }
}
