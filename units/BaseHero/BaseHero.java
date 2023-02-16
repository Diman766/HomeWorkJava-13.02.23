package BaseHero;

public abstract class BaseHero implements Interface{
    protected String heroID;
    protected int number;
    protected int hp;
    protected int attack;
    protected int protection;

    public BaseHero(String heroID, int hp,int attack,int protection) {
        this.heroID = heroID;
        this.hp = hp;
        this.attack = attack;
        this.protection = protection;
        // this.number = number;
    }

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
        return String.format("Name: %s  Hp: %d  Role: %s",
        this.heroID, this.hp, this.getClass().getSimpleName());
    }
    
    public void Step() {

    }

}

