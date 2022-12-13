import java.awt.Graphics2D;


public class Elipse extends Forme {

    int width;
    int height;

    public Elipse(int x, int y, int width, int height){
        
        super();
        this.addPoint(x, y);
        this.width=width;
        this.height=height;
        this.updateAire();
        this.updatePerimetre();
    }

    public void updateAire(){
        this.aire = Math.PI * (this.width/2) * (this.height/2); 
    }

    public void updatePerimetre(){
        this.perimetre = 2*Math.PI*Math.sqrt((width*width+height*height)/2);
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
        g.drawOval(p.x, p.y, this.width, this.height);  
    }
    
    @Override
    public void homothetie(float x){
        Point p = this.getPoints().get(0);
        
        p.x = Math.round(p.x * x);
        width = Math.round(width * x);
        height = Math.round(height * x);
    }

    @Override
    public void translation(int x, int y) {
        Point p = this.points.get(0);

        p.x += x;
        p.y += y;
    }

    @Override
    public void symetrieaxiale() {
        Point p = this.points.get(0);

        p.x = 500 - p.x - this.width;
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