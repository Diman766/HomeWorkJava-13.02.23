

import BaseHero.BaseHero;


public abstract class PeasantUnit extends BaseHero {

    int food = 5;

    public PeasantUnit(String heroID, int hp,int attack,int protection,int food) {
        super( heroID,  hp, attack, protection);
        super.heroID = "1";
        super.hp = 100;
        super.attack = 10;
        super.protection = 10;
        this.food = 5;
    }
   
}
