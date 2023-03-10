package units;

import java.util.ArrayList;
import java.util.List;

public abstract class ShooterUnit extends BaseHero {
    public int shots;

    protected ShooterUnit(String heroID, int hp, int maxHp, int attack, int protection, int[] damage, int speed,
            int shots, int team, int x, int y) {
        super(heroID, hp, maxHp, attack, protection, damage, speed, team, x, y);
        this.shots = 32;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                " H:" + Math.round(hp) +
                " A:" + attack +
                " Dmg:" + Math.round(Math.abs((damage[0] + damage[1]) / 2)) + " " +
                state + " Shots:" + shots + " ";
    }

    @Override
    public void Step(List<BaseHero> twoTeam) {
        if (state != "Die" && shots > 0) {
            List<BaseHero> enemy = new ArrayList<>();
            listEnemy(twoTeam, enemy);

            BaseHero victim = enemy.get(getVictim(enemy));
            int damageMin = damage[0];
            int damageMax = damage[1];
            float damage = (victim.getProtection() - attack) > 0 ? damageMin
                    : (victim.getProtection() - attack) < 0 ? damageMax : (damageMin + damageMax) / 2;

            victim.damage(damage);

            for (BaseHero i : twoTeam) {
                if (i.GetInfo().toString().split(":")[4].equals("       Farmer") & i.team == team
                        & i.state.equals("Stand")) {
                    i.state = "Busy";
                    return;
                } else if (i.GetInfo().toString().split(":")[4].equals("      Peasant") & i.team == team
                        & i.state.equals("Stand")) {
                    i.state = "Busy";
                    return;
                } 
            }
            shots--;
        }
   
    }

    public String GetInfo() {
        return String.format("%s  Shots: %d", super.GetInfo(), this.shots);
    }
}
