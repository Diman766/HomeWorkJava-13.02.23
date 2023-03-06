package units;

import java.util.List;

public abstract class BaseHero implements Interface {
    protected String heroID;
    protected int hp;
    protected int attack;
    protected int protection;
    protected int[] damage = new int[2];
    protected int speed;
    protected Point2D position;
    protected int team;
    protected int maxHp;
    protected String state;

    public BaseHero(String heroID, int hp, int maxHp, int attack, int protection, int[] damage, int speed, int team,
            int x, int y) {
        this.heroID = heroID;
        this.hp = hp;
        this.attack = attack;
        this.protection = protection;
        this.damage = damage;
        this.speed = speed;
        this.position = new Point2D(x, y);
        this.team = team;
        this.maxHp = maxHp;
        this.state = "Stand";
    }

    public BaseHero(String heroID, int hp, int maxHp, int attack, int protection, int i, int speed, int team, int x,
            int y) {
        this(heroID, hp, maxHp, attack, protection, new int[] { i, i }, speed, team, x, y);

    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
        // " H:" + Math.round(hp) +
                " H:" + hp +
                // " D:" + protection +
                " A:" + attack +
                " Dmg:" + Math.round(Math.abs((damage[0] + damage[1]) / 2)) +
                " " + state;
    }

    public void damage(float damage) {
        if (this.hp - damage > 0) {
            if (this.hp - damage > this.maxHp) {
                this.hp = this.maxHp;
            } else {
                this.hp -= damage;
            }

        } else {
            this.hp = 0;
            state = "Die";
        }
    }

    public String GetInfo() {
        return String.format("Name: %7s  Speed: %2d  Hp: %2d  Role: %12s:  Status: %7s",
        this.heroID, this.speed, this.hp, this.getClass().getSimpleName(),this.state);
        
    }

    public void Step(List<BaseHero> twoTeam) {

    }

    public int getSpeed() {
        return speed;
    }

    public int getHp() {
        return hp;
    }

    public int getTeam() {
        return team;
    }

    public Point2D getPosition() {
        return position;
    }

    public String getStatus() {
        return state;
    }

    public int getProtection() {
        return protection;
    }

    protected void listEnemy(List<BaseHero> twoTeam, List<BaseHero> enemy) {

        for (BaseHero i : twoTeam) {
            if (i.getStatus() != "Die" && i.getTeam() != team) {
                enemy.add(i);
            }

        }
    }

    protected int getVictim(List<BaseHero> enemys) {
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

}
