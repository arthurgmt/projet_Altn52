import java.awt.Graphics2D;
import java.util.ArrayList;

public class Polygone extends Forme implements Transformation {

    // A polygon is a list of point 
    public Polygone(ArrayList<Point> points){
        
        super();
        this.points = points;
       
    }

    public Polygone(){
        
        super();
       
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
    public void homothetie(){
        // TODO Auto-generated method stub
    }

    @Override
    public void translation(int x, int y) {
        for (Point p : this.points){
            p.x += x;
            p.y += y;
        }
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