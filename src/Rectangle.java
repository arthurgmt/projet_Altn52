import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.TreeSet;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Rectangle extends Polygone{

    int width;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    int height;

    public Rectangle(){
        super();
    }
    public Rectangle(int x, int y, int width, int height){
        
        super();
        this.addPoint(x, y);
        this.width=width;
        this.height=height;
        this.updatePoints();
        this.updateAire();
        this.updatePerimetre();
    }

    public void updateAire(){
        this.aire = this.width * this.height;
    }

    public void updatePerimetre(){
        this.perimetre = this.width*2 + this.height*2;
    }

    // getter
    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    public void updatePoints () {
        Point p1 = this.points.get(0);
        this.addPoint(p1.getX() + this.width, p1.getY());
        this.addPoint(p1.getX() + this.width, p1.getY() + this.height);
        this.addPoint(p1.getX(), p1.getY() + this.height);
    }


    /*@Override
    public void rotation (){
        Point pmax = points.get(0);
        for (Point p : this.points){
            if(pmax.getX()==p.getX()){
                if(pmax.getY()<p.getY()) pmax = p;
            } else {
                if (pmax.getX() < p.getX()) pmax = p;
            }
        }
        System.out.println("pmax : "+pmax);
        for (Point p : this.points){
            System.out.println("le point : "+p);
            if(!p.equals(pmax)){
                int newX = (int) Math.round((p.getX()-pmax.getX())*cos(90)+(p.getY()-pmax.getY())*sin(90)+pmax.getX());
                int newY = (int) Math.round((p.getX()-pmax.getX())*sin(90)+(p.getY()-pmax.getY())*cos(90)+pmax.getY());
                System.out.println("new x"+newX);
                System.out.println("new y"+newY);
                p.setX(newX);
                p.setY(newY);
            }
        }
    }*/

    @Override
    public String toString() {
        return "Rectangle = " +
                "largeur : " + width +
                " | hauteur : " + height +
                " | aire : " + aire +
                " | perimetre : " + perimetre +
                " | " + points;
    }


}