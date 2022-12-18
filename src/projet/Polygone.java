package projet;

import java.awt.Graphics2D;
import java.util.ArrayList;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Polygone extends Forme implements Transformation {

    // A polygon is a list of point 
    public Polygone(ArrayList<Point> points){
        
        super();
        this.points = points;
        this.updatePerimetre();
    }

    public Polygone(){
        
        super();
       
    }

    @Override
    public void updatePerimetre(){

        double perimetre = 0;
        Point precedent = null;
        Point current = null;

        for (Point p : this.points){
            if (precedent == null){
                precedent = p;
            }else{
                current = p;

                int x1 = precedent.x;
                int y1 = precedent.y;
                int x2 = current.x;
                int y2 = current.y;

                perimetre += Math.sqrt((y2-y1)*(y2-y1)+(x2-x1)*(x2-x1));
                precedent = current;
            }
        }

        precedent = this.points.get(0);

        int x1 = precedent.x;
        int y1 = precedent.y;
        int x2 = current.x;
        int y2 = current.y;

        perimetre += Math.sqrt((y2-y1)*(y2-y1)+(x2-x1)*(x2-x1));
        
        this.perimetre = perimetre;
    }

    @Override
    public void updateAire(){
        double aire = 0;
        for (int i = 0; i < points.size(); i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % points.size());
            aire += p1.getX() * p2.getY() - p2.getX() * p1.getY();
        }
        this.aire = aire;
    }

    //dessin
    @Override
    public void paint(Graphics2D g){
        int i = 0;
        while (i< points.size()-1){
            Point currentPoint = this.getPoints().get(i);
            Point nextPoint = this.getPoints().get(i+1);
            g.drawLine(currentPoint.x, currentPoint.y, nextPoint.x, nextPoint.y);  
            
            i+=1;
        }
        Point currentPoint = this.getPoints().get(0);
        Point nextPoint = this.getPoints().get(i);

        g.drawLine(currentPoint.x, currentPoint.y, nextPoint.x, nextPoint.y);  
    }
    

    @Override
    public void homothetie(float x){

         for (Point p : this.points){
            p.x *= x;
            p.y *= x;
        }
    }

    @Override
    public void translation(int x, int y) {
        for (Point p : this.points){
            p.x += x;
            p.y += y;
        }
    }

    @Override
    public void symetrieaxiale() {
        for (Point p : this.points){

            p.x = 500 - p.x;
        }
    }

    @Override
    public void symetriecentrale(int x, int y) {
        for (Point p : this.points){

            int distX = x-p.x; 
            int distY = y-p.y; 

            p.x += 2*distX;
            p.y += 2*distY;
        }
    }

    @Override
    public void rotation (){
        Point pmax = points.get(0);
        for (Point p : this.points){
            if(pmax.getX()==p.getX()){
                if(pmax.getY()<p.getY()) pmax = p;
            } else {
                if (pmax.getX() < p.getX()) pmax = p;
            }
        }
        for (Point p : this.points){
            if(!p.equals(pmax)){
                int newX = (int) Math.round((p.getX()-pmax.getX())*cos(3.14)+(p.getY()-pmax.getY())*sin(3.14)+pmax.getX());
                int newY = (int) Math.round((p.getX()-pmax.getX())*sin(3.14)+(p.getY()-pmax.getY())*cos(3.14)+pmax.getY());
                p.setX(newX);
                p.setY(newY);
            }
        }
    }

    @Override
    public String toString() {
        return "projet.Polygone = " +
                "aire : " + aire +
                " | perimetre : " + perimetre +
                " | " + points + "\n";
    }
}