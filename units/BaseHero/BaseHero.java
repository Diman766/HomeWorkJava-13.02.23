package BaseHero;

public abstract class BaseHero implements Interface {
    protected String heroID;
    protected int hp;
    protected int attack;
    protected int protection;
    protected int[] damage = new int[2];
    protected int speed;

    public BaseHero(String heroID, int hp, int attack, int protection, int[] damage, int speed) {
        this.heroID = heroID;
        this.hp = hp;
        this.attack = attack;
        this.protection = protection;
        this.damage = damage;
        this.speed = speed;
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

    public void attack() {

    }

    public void damage(int damage) {
        if (this.hp - damage > 0) {
            this.hp -= damage;
        }
        // else { die(); }

    }

    public void healing() {

    }

    public String GetInfo() {
        return String.format("Name: %7s  Speed:  %2d  Hp: %d  Role: %s",
                this.heroID, this.speed, this.hp, this.getClass().getSimpleName());
    }

    public void Step() {

    }

    public int getSpeed() {
        return speed;
    }

    public int getHp() {
        return hp;
    }

}
