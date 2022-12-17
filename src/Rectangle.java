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

    @Override
    public String toString() {
        if (this.width == this.height){
            return "Carré = " +
                    "largeur : " + width +
                    " | hauteur : " + height +
                    " | aire : " + aire +
                    " | perimetre : " + perimetre +
                    " | " + points + "\n";
        }
        else{
            return "Rectangle = " +
                    "largeur : " + width +
                    " | hauteur : " + height +
                    " | aire : " + aire +
                    " | perimetre : " + perimetre +
                    " | " + points + "\n";
        }
    }


}