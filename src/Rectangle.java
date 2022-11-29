import java.awt.Graphics2D;

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
    @Override
    public void paint(Graphics2D g){
        Point p = this.getPoints().get(0);
        g.drawRect(p.x, p.y, this.width, this.height);  
    }

    @Override
    public void homothetie(){
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
        
        Point p = this.points.get(0);

        int dx = x - (p.x + width/2);
        int dy = y - (p.y + height/2); 

        p.x += 2*dx;
        p.y += 2*dy;

    }


}