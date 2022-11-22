import java.util.ArrayList;

public class Forme { 

    ArrayList<Point> points; 
    float aire = 0;
    float perimetre = 0;


    public Forme(){
        points = new ArrayList<Point>();  
    }
    
    public void addPoint(int x, int y){
        Point p = new Point(x, y);
        this.points.add(p);
    }

    // getter
    public ArrayList<Point> getPoints(){
        return this.points;
    }

    // setter
    public void setAire(float aire){
        this.aire = aire;
    }

    public void setPerimetre(float perimetre){
        this.perimetre = perimetre;
    }
}