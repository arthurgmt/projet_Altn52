package projet;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class FormeTest {

    Forme t1 = new Trait(100,200,100,200);
    Forme t2 = new Trait(0,100,0,100);

    Forme r = new Rectangle(0,0,200,10);

    Polygone p = new Polygone();

    @Test
    public void translation() {

        t2.translation(100,100);

        int x = t1.getPoints().get(0).x;
        int y = t1.getPoints().get(0).y;
        int x1 = t1.getPoints().get(1).x;
        int y1 = t1.getPoints().get(1).y;

        int x2 = t2.getPoints().get(0).x;
        int y2 = t2.getPoints().get(0).y;
        int x3 = t2.getPoints().get(0).x;
        int y3 = t2.getPoints().get(0).y;

        assertEquals("Translation", true, x == x2);
        assertEquals("Translation", true, y == y2);
        assertEquals("Translation", true, x1 == x3);
        assertEquals("Translation", true, y1 == y3);
    }

    @Test
    public void homothetie() {

        t2.homothetie(2);

        int x = t1.getPoints().get(0).x;
        int y = t1.getPoints().get(0).y;
        int x1 = t1.getPoints().get(1).x;
        int y1 = t1.getPoints().get(1).y;

        int x2 = t2.getPoints().get(0).x;
        int y2 = t2.getPoints().get(0).y;
        int x3 = t2.getPoints().get(0).x;
        int y3 = t2.getPoints().get(0).y;

        assertEquals("Homothetie", false, x == x2);
        assertEquals("Homothetie", true, y == y2);
        assertEquals("Homothetie", false, x1 == x3);
        assertEquals("Homothetie", true, y1 == y3);
    }

    @Test
    public void symetrieaxiale() {

        r.symetrieaxiale();

        int x = r.getPoints().get(0).x;   
        int y = r.getPoints().get(0).y;   

        assertEquals("Hmothetie", true, x == 300);
        assertEquals("Hmothetie", true, y == 490);

    }

    @Test
    public void symetriecentrale() {

        r.symetriecentrale(250, 250);

        int x = r.getPoints().get(0).x;   
        int y = r.getPoints().get(0).y;   

        assertEquals("Symetriecentrale", true, x == 300);
        assertEquals("Symetriecentrale", true, y == 490);
    }

    @Test
    public void perimetrePolygone(){
        p.addPoint(10,10);
        p.addPoint(60,10);
        p.addPoint(210,210);
        p.addPoint(10,210);

        p.updatePerimetre();

        assertEquals("Perimetre projet.Polygone", true, p.getPerimetre() == 700);
    }

    @Test
    public void aire() {     

        assertEquals("Aire", true, r.getAire() == 2000);
    }

    @Test
    public void perimetre() {     

        assertEquals("Perimetre", true, r.getPerimetre() == 420);
    }
}