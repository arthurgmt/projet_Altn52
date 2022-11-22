import java.util.ArrayList;

public class Forme { 

    ArrayList<Point> points; 

    public Forme(){
        points = new ArrayList<Point>();  
    }
    
    public void addPoint(int x, int y){
        Point p = new Point(x, y);
        this.points.add(p);
    }

    public ArrayList<Point> getPoints(){
        return this.points;
    }

}