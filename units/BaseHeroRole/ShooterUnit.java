
import java.util.ArrayList;
import java.util.List;

import BaseHero.BaseHero;

public abstract class ShooterUnit extends BaseHero {
    public int shots;

    protected ShooterUnit(String heroID, int hp, int maxHp, int attack, int protection, int[] damage, int speed,
            int shots, int team, int x, int y) {
        super(heroID, hp, maxHp, attack, protection, damage, speed, team, x, y);
        this.shots = 32;
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
        // return;

    }

    private int getVictim(List<BaseHero> enemys) {
        int victim = 0;
        double minDistance = position.distance(enemys.get(0).getPosition());
        for (BaseHero i : enemys) {
            if (minDistance >= position.distance(i.getPosition())) {
                minDistance = position.distance(i.getPosition());
                victim = enemys.indexOf(i);
            }
        }
        return victim;
    }

    private void listEnemy(List<BaseHero> twoTeam, List<BaseHero> enemy) {

        for (BaseHero i : twoTeam) {
            if (i.getStatus() != "Die" && i.getTeam() != team) {
                enemy.add(i);
            }

        }
    }

    public String GetInfo() {
        return String.format("%s  Shots: %d", super.GetInfo(), this.shots);
    }
}
