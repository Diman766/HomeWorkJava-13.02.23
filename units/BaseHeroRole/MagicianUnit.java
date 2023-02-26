
import BaseHero.BaseHero;

public abstract class MagicianUnit extends BaseHero {
    private int magic;

    public MagicianUnit(String heroID, int hp,int maxHp, int attack, int protection, int[] damage, int speed,int team, int x, int y) {
        super(heroID, hp,maxHp, attack, protection, damage, speed, team, x, y);
        this.magic = 1;
    }

    public void healing() {

    }

}
