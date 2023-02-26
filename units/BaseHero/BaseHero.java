package BaseHero;

import java.util.List;

public abstract class BaseHero implements Interface {
    protected String heroID;
    public int hp;
    protected int attack;
    protected int protection;
    protected int[] damage = new int[2];
    protected int speed;
    protected Point2D position;
    public int team;
    public int maxHp;
    public String state;

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

    // public BaseHero(String heroID, int hp,int attack,int protection,int
    // damage,int speed) {
    // this.heroID = heroID;
    // this.hp = hp;
    // this.attack = attack;
    // this.protection = protection;
    // this.damage[0] = damage;
    // this.damage[1] = damage;
    // this.speed = speed;
    // }

    public void attack(float i) {

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

    public void healing() {

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

}
