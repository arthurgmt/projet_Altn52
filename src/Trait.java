import java.awt.Graphics2D;

public class Trait extends Forme implements Transformation {

    public Trait(int x1, int y1, int x2, int y2){
        
        super();
        this.addPoint(x1, y1);
        this.addPoint(x2, y2);
    }

    //dessin
    @Override
    public void paint(Graphics2D g){

        Point p1 = this.getPoints().get(0);
        Point p2 = this.getPoints().get(1);

        g.drawLine(p1.x, p1.y, p2.x, p2.y);  
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
        
        for (Point p : this.points){

            int distX = x-p.x; 
            int distY = y-p.y; 

            p.x += 2*distX;
            p.y += 2*distY;
        }
        
    }

}