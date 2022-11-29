import java.util.ArrayList;

public class App{

    public static void main(String[] args){

            
		Dessin pan = new Dessin();

        Image i = new Image();

        Forme e = new Elipse(50,50,100,150);
        Forme c = new Elipse(100,100,100,100);
        Forme t = new Trait(0, 0, 500, 500);
        Forme r = new Rectangle(20, 50, 400, 200);

        Forme p = new Polygone();
        p.addPoint(200,40);
        p.addPoint(250,100);
        p.addPoint(180,200);

        // add formes to image
        i.addForme(e);
        i.addForme(t);
        i.addForme(c);
        i.addForme(r);
        i.addForme(p);

        // add image 
        pan.addImage(i);

        // view
        Frame fen = new Frame(500,500);
		fen.add(pan);
		fen.repaint();
		fen.revalidate();

    }

}