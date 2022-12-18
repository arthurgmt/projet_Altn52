package projet;

import java.lang.Math;

public class Point {

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public double distance(Point p){

        double distance = Math.sqrt((p.x-this.x)*(p.x-this.x)+(p.y-this.y)*(p.y-this.y));

        return distance;
    }

    @Override
    public String toString() {
        return "x : " + x +
                " | y : " + y;
    }
}
