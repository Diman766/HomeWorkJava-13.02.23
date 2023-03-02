package units;

import java.util.List;

public abstract class BaseHero implements Interface {
    protected String heroID;
    public int hp;
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

    // public BaseHero(String heroID, int hp, int attack, int protection, int damage, int speed, int team,
    //         int x, int y) {
    //     this.BaseHero( heroID,  hp,  maxHp,  attack,  protection,  damage,  speed,  team,
    //      x,  y);
        
    //     this.damage[0] = damage;
    //     this.damage[1] = damage;
        
    // }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                // " H:" + Math.round(hp) +
                " H:" + hp +
                // " D:" + protection +
                " A:" + attack +
                " Dmg:" + Math.round(Math.abs((damage[0]+damage[1])/2)) +
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
        return String.format("%11s  Hp: %2d  A: %2d  Dmg: %2s:  %7s",this.state,this.hp,
                 this.attack, this.hp, Math.round(Math.abs((this.damage[0]+this.damage[1])/2)), this.state);
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

}
