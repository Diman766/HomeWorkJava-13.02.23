package units;

public class Monk extends MagicianUnit {
    public Monk(String heroID, int x, int y) {
        super(heroID, 30,30, 12, 7, new int[] { -4, -4 }, 5,1, x, y);
    }

}