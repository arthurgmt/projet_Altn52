import java.util.ArrayList;

public class App{

  public static void main(String[] args){

		Dessin pan = new Dessin();

    Image i = new Image();
    Forme r_ = new Rectangle(0, 0, 500, 500);
    i.addForme(r_);

    Forme e = new Elipse(0,0,100,100);
    Forme c = new Elipse(0,0,100,100);
    Forme t = new Trait(200, 200, 500, 500);
    Forme r = new Rectangle(0, 0, 100, 80);

    Forme p = new Polygone();
    p.addPoint(100,0);
    p.addPoint(100,200);
    p.addPoint(80,250);
    p.addPoint(200,150);

    // add formes to image
    i.addForme(e);
    // i.addForme(t);
    i.addForme(c);
    // i.addForme(r);
    i.addForme(p);

    // modif 
    c.symetriecentrale(250, 250);

    // add image 
    pan.addImage(i);

    // view
    Frame fen = new Frame(500,520);

		fen.add(pan);
		fen.repaint();
		fen.revalidate();

  }

}