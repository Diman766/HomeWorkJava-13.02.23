package units;

import java.util.ArrayList;
import java.util.List;

public abstract class WarriorUnit extends BaseHero {
    public WarriorUnit(String heroID, int hp, int maxHp, int attack, int protection, int[] damage, int speed, int team,
            int x, int y) {
        super(heroID, hp, maxHp, attack, protection, damage, speed, team, x, y);
    }

    @Override
    public void Step(List<BaseHero> twoTeam) {
        if (state != "Die") {
            List<BaseHero> enemy = new ArrayList<>();
            listEnemy(twoTeam, enemy);

            BaseHero victim = enemy.get(getVictim(enemy));

            if (position.distance(victim.position) < 2) {
                int damageMin = damage[0];
                int damageMax = damage[1];
                float damage = (victim.getProtection() - attack) > 0 ? damageMin
                        : (victim.getProtection() - attack) < 0 ? damageMax : (damageMin + damageMax) / 2;

                victim.damage(damage);
            } else {
                Point2D tempvc = position.getWai(victim.position);
                if (Math.abs(tempvc.x) < Math.abs(tempvc.y) && position.getWai(victim.position).y > 0 &&
                        freeStep(position, twoTeam, 4)) {
                    position.y--;
                } else if (Math.abs(tempvc.x) < Math.abs(tempvc.y) && position.getWai(victim.position).y < 0 &&
                        freeStep(position, twoTeam, 3)) {
                    position.y++;
                } else if (position.getWai(victim.position).x > 0 &&
                        freeStep(position, twoTeam, 2)) {
                    position.x--;
                } else if (position.getWai(victim.position).x < 0 &&
                        freeStep(position, twoTeam, 1)) {
                    position.x++;
                } else return;
              
            }
        }

    }

    public boolean freeStep(Point2D position, List<BaseHero> twoTeam, int direction) {
        for (int i = 0; i < twoTeam.size(); i++) {
            switch (direction) {
                case 1:
                    if (position.x + 1 == twoTeam.get(i).position.x && twoTeam.get(i).state != "Die"
                            && position.y == twoTeam.get(i).position.y) {
                        i = twoTeam.size();
                        return false;
                    }
                    break;
                case 2:
                    if (position.x - 1 == twoTeam.get(i).position.x && twoTeam.get(i).state != "Die"
                            && position.y == twoTeam.get(i).position.y) {
                        i = twoTeam.size();
                        return false;
                    }
                    break;
                case 3:
                    if (position.y + 1 == twoTeam.get(i).position.y && twoTeam.get(i).state != "Die"
                            && position.x == twoTeam.get(i).position.x) {
                        i = twoTeam.size();
                        return false;
                    }
                    break;
                case 4:
                    if (position.y - 1 == twoTeam.get(i).position.y && twoTeam.get(i).state != "Die"
                            && position.x == twoTeam.get(i).position.x) {
                        i = twoTeam.size();
                        return false;
                    }
                    break;

            }

        }

        return true;
    }

}
