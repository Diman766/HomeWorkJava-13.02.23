package units;

public class Point2D {
    public int x;
    public int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point2D enemy) {
        return Math.sqrt(Math.pow(this.x - enemy.x, 2) + Math.pow(this.y - enemy.y, 2)); 
    }

    protected Point2D getWai(Point2D enemy){
        return new Point2D(x - enemy.x, y - enemy.y);
    }
    
}
