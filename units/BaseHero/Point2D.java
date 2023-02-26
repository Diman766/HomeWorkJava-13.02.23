package BaseHero;

public class Point2D {
    protected int x, y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point2D enemy) {
        return Math.sqrt(Math.pow(this.x - enemy.x, 2) + Math.pow(this.y - enemy.y, 2)); 
    }
    
}
