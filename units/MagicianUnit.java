package units;

import java.util.List;

public abstract class MagicianUnit extends BaseHero {
    private int magic;

    public MagicianUnit(String heroID, int hp, int maxHp, int attack, int protection, int[] damage, int speed, int team,
            int x, int y) {
        super(heroID, hp, maxHp, attack, protection, damage, speed, team, x, y);
        this.magic = 1;
    }

    @Override
    public void Step(List<BaseHero> twoTeam) {
        if (state.equals("Die") || magic <= 0) {
            return;
        } else if (findVeryIll(twoTeam) != -1){
            BaseHero victim = twoTeam.get(findVeryIll(twoTeam));
            victim.damage(damage[0]);
        }else return;
       
    }

    protected int findVeryIll(List<BaseHero> twoTeam) {
        double minHp = 0;
        int index = -1;
        for (int i = 0; i < twoTeam.size(); i++) {
            // BaseHero pers = twoTeam.get(i);
            if (minHp < twoTeam.get(i).maxHp - twoTeam.get(i).hp && twoTeam.get(i).team == team
                    && twoTeam.get(i).getStatus() != "Die") {
                index = i;
                minHp = twoTeam.get(i).maxHp - twoTeam.get(i).hp;
            }
        }
        return index;
    }

}
