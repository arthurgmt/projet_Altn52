import java.awt.Graphics2D;

public class Trait extends Forme {

    public Trait(){
        super();
    }
    public Trait(int x1, int y1, int x2, int y2){
        
        super();
        this.addPoint(x1, y1);
        this.addPoint(x2, y2);
        this.updatePerimetre();
    }

    public void updatePerimetre() {
        Point p1 = this.getPoints().get(0);
        Point p2 = this.getPoints().get(1);

        int x1 = p1.x;
        int y1 = p1.y;
        int x2 = p2.x;
        int y2 = p2.y;

        this.perimetre = Math.sqrt((y2-y1)*(y2-y1)+(x2-x1)*(x2-x1));
    }

    //dessin
    @Override
    public void paint(Graphics2D g){

        Point p1 = this.getPoints().get(0);
        Point p2 = this.getPoints().get(1);

        g.drawLine(p1.x, p1.y, p2.x, p2.y);  
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
    public void rotation() {

        for (Point p : this.points){

            int x = p.x;

            p.x = p.y;
            p.y = x;
        }
    }

    @Override
    public String toString() {
        return "Trait{" +
                "points=" + points +
                '}';
    }
}