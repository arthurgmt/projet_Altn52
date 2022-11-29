import java.util.ArrayList;

public class App{

  public static void main(String[] args){

            
		Dessin pan = new Dessin();

    Image i = new Image();
    Forme r_ = new Rectangle(0, 0, 500, 500);
    i.addForme(r_);

    // Forme e = new Elipse(50,50,100,150);
    Forme c = new Elipse(0,0,100,100);
    // Forme t = new Trait(200, 200, 500, 500);
    Forme r = new Rectangle(0, 0, 100, 80);

    // add formes to image
    // i.addForme(e);
    // i.addForme(t);
    // i.addForme(c);
    i.addForme(r);

    // add image 
    pan.addImage(i);

    // view
    Frame fen = new Frame(500,520);

		fen.add(pan);
		fen.repaint();
		fen.revalidate();

  }

}