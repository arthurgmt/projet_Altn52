import java.awt.Graphics;

public class Rectangle extends Forme implements Transformation {

    int width;
    int height;

    public Rectangle(int x, int y, int width, int height){
        
        super();
        this.addPoint(x, y);
        this.width=width;
        this.height=height;
    }

    // getter
    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    //dessin
    public void paint(Graphics g){
        Point p = this.getPoints().get(0);
        g.drawRect(p.x, p.y, this.width, this.height);  
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