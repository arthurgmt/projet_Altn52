import java.security.spec.EllipticCurve;

public class Elipse extends Forme implements Transformation {

    int width;
    int height;

    public Elipse(int x, int y, int width, int height){
        
        super();
        this.addPoint(x, y);
        this.width=width;
        this.height=height;
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