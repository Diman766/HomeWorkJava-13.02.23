package units;

public class Monk extends MagicianUnit {
    public Monk(String heroID, int x, int y) {
        super(heroID, 30,30, 12, 12, new int[] { -5, -5 }, 5,1, x, y);
    }

}