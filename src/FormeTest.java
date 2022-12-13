import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class FormeTest {

    Forme t1 = new Trait(0,200,0,200);
    Forme t2 = new Trait(0,100,0,100);

    Forme r = new Rectangle(0,0,200,10);


    @Test
    public void translation() {

        t2.translation(100,100);

        int y = t1.getPoints().get(0).y;
        int y2 = t2.getPoints().get(0).y;

        assertEquals("Translation", true, y == y2);
    }

    @Test
    public void homothetie() {

        t2.homothetie(2);

        int y = t1.getPoints().get(0).y;
        int y2 = t2.getPoints().get(0).y;    

        assertEquals("Hmothetie", true, y == y2);
    }

    @Test
    public void symetrieaxiale() {

        r.symetrieaxiale();

        int x = r.getPoints().get(0).x;   

        assertEquals("Hmothetie", true, x == 300);
    }

    @Test
    public void symetriecentrale() {

        r.symetriecentrale(250, 250);

        int x = r.getPoints().get(0).x;   

        assertEquals("Symetriecentrale", true, x == 300);
    }

    @Test
    public void aire() {     

        assertEquals("Aire", true, r.aire == 2000);
    }

    @Test
    public void perimetre() {     

        assertEquals("Parametre", true, r.perimetre == 420);
    }
}