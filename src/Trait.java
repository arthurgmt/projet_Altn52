import java.awt.Graphics;

public class Trait extends Forme implements Transformation {

    public Trait(int x1, int y1, int x2, int y2){
        
        super();
        this.addPoint(x1, y1);
        this.addPoint(x2, y2);
    }

    //dessin
    public void paint(Graphics g){

        Point p1 = this.getPoints().get(0);
        Point p2 = this.getPoints().get(1);

        g.drawLine(p1.x, p1.y, p2.x, p2.y);  
    }

    @Override
    public void homothetie(){
        // TODO Auto-generated method stub
    }

    @Override
    public void translation() {
        // TODO Auto-generated method stub
    }

    @Override
    public void symetrieaxiale() {
        // TODO Auto-generated method stub
    }

    @Override
    public void symetriecentrale() {
        // TODO Auto-generated method stub
    }

}