import java.util.ArrayList;
import java.util.Scanner;

public class App{

  public static void main(String[] args){

    ArrayList <Dessin> dessins = new ArrayList<Dessin>();

    System.out.println("*** Bienvenue sur cette application de dessin ! ***\n");


    MenuConsole menuConsole;
    System.out.println("1- commencer avec des données par défaut\n2- commencer de zéro\n");
    Scanner sc = new Scanner(System.in);
    int saisie = Integer.parseInt(sc.nextLine());
    while (saisie!=1 && saisie!=2){
      System.out.println("1- commencer avec des données par défaut \n 2- commencer de zéro\n");
    }
    if (saisie == 1){
      dessins = genererDefault();
    }
    menuConsole = new MenuConsole(dessins);
    menuConsole.menuPrincipal();


    // fen.add(pan);
    // fen.add(pan2);
    // fen.repaint();
    // fen.revalidate();
    // fen.add(pan2);
    // fen.repaint();
    // fen.revalidate();
  }
  public static ArrayList<Dessin> genererDefault(){
    ArrayList <Dessin> dessins = new ArrayList<Dessin>();
    Dessin pan = new Dessin();
    Image i = new Image();
    Image i2 = new Image();

    Forme e = new Ellipse(0,0,200,100);
    Forme c = new Ellipse(0,0,100,100);
    Forme t = new Trait(50, 150, 300, 50);
    Forme r = new Rectangle(15, 15, 100, 80);
    Forme r2 = new Rectangle(0, 0, 100, 80);
    Forme p = new Polygone();
    p.addPoint(10,10);
    p.addPoint(60,10);
    p.addPoint(60,210);

    i.addForme(t);
    i.addForme(c);
    i.addForme(r);
    i.addForme(p);

    i2.addForme(e);
    i2.addForme(r2);

    pan.addImage(i);
    pan.addImage(i2);
    dessins.add(pan);
    return dessins;
  }

}