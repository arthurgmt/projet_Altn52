import java.util.ArrayList;

public class App{

  public static void main(String[] args){

    System.out.println("*** Bienvenue sur cette application de dessin ! ***\n");

    ArrayList <Dessin> dessins = new ArrayList<Dessin>();
		Dessin pan = new Dessin();

    Image i = new Image();
    Image i2 = new Image();
    Forme r_ = new Rectangle(0, 0, 500, 500);
    i.addForme(r_);

    Forme e = new Elipse(0,0,200,100);
    Forme c = new Elipse(0,0,100,100);
    Forme t = new Trait(50, 150, 300, 50);
    Forme r = new Rectangle(15, 15, 100, 80);
    Forme r2 = new Rectangle(0, 0, 100, 80);

    Forme p = new Polygone();
    p.addPoint(10,10);
    p.addPoint(60,10);
    p.addPoint(60,210);


    // add formes to image
    i.addForme(t);
    i.rotation();
    //t.rotation();
    i.addForme(t);
    i.addForme(c);
    i.addForme(r);
    i.addForme(p);
    i2.addForme(r);
    i2.addForme(p);

    // modif 
    // c.symetriecentrale(250, 250);
    // c.symetrieaxiale();
    t.symetrieaxiale();

    // add image 
    pan.addImage(i);
    //pan.addImage(i2);

    Dessin pan2 = pan.copie();
    dessins.add(pan);
    dessins.add(pan2);
    MenuConsole menuConsole = new MenuConsole(dessins);
    menuConsole.menuPrincipal();

    // view
    Frame fen = new Frame(1200,1200);

		/*fen.add(pan);
        //fen.add(pan2);
		fen.repaint();
		fen.revalidate();
    //fen.add(pan2);
    fen.repaint();
    fen.revalidate();*/
  }

}