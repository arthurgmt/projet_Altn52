import java.util.TreeSet;

public class Forme { 

    TreeSet<Point> points; 

    public Forme(){
        points = new TreeSet<Point>();  
    }
    
    public void addPoint(int x, int y){
        Point p = new Point(x, y);
        this.points.add(p);
    }

    public TreeSet<Point> getPoints(){
        return this.points;
    }

}