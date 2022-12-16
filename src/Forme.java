import java.util.ArrayList;
import java.awt.Graphics2D;

abstract class Forme implements Transformation{

    ArrayList<Point> points;
    double aire = 0;
    double perimetre = 0;

    public Forme(){
        this.points = new ArrayList<Point>();
    }

    public double getAire() {
        return aire;
    }

    public double getPerimetre() {
        return perimetre;
    }

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
    
    public void addPoint(int x, int y){
        Point p = new Point(x, y);
        try {
            this.points.add(p);
        }catch (NullPointerException e){
            this.points = new ArrayList<Point>();
            this.points.add(p);
        }   
    }

    abstract void paint(Graphics2D g);

    @Override
    public void homothetie(float x) {
    }

    @Override
    public void translation(int x, int y) {
    }

    @Override
    public void symetrieaxiale() {
    }

    @Override
    public void symetriecentrale(int x, int y) {
    }

    @Override
    public void rotation() {
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        else if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        else{
            return true;
        }
    }
}