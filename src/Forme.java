import java.util.ArrayList;
import java.awt.Graphics2D;

public class Forme implements Transformation{ 

    ArrayList<Point> points; 
    float aire = 0;
    float perimetre = 0;


    public Forme(){
        this.points = new ArrayList<Point>();
    }
    
    public void addPoint(int x, int y){
        Point p = new Point(x, y);
        try {
            this.points.add(p);
        }catch (NullPointerException e){
            this.points = new ArrayList<Point>();
            this.points.add(p);
        }   
    }

    public void paint(Graphics2D g){
        
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

    @Override
    public void homothetie() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void translation(int x, int y) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void symetrieaxiale(int x1, int y1, int x2, int y2) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void symetriecentrale(int x, int y) {
        // TODO Auto-generated method stub
        
    }
}