import java.util.ArrayList;
import java.util.TreeSet;

public class Image implements Transformation{
    
    ArrayList<Forme> formes;

    public Image(){
        this.formes = new ArrayList<Forme>();
    }

    public void addForme(Forme f){
        this.formes.add(f);
    }

    //getter
    public ArrayList<Forme> getFormes(){
        return this.formes;
    }
    

    @Override
    public void homothetie() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void translation() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void symetrieaxiale(int x1, int y1, int x2, int y2) {
        for (Forme f: formes){
            f.symetrieaxiale(x1, y1, x2, y2);
        }
    }

    @Override
    public void symetriecentrale(int x, int y) {
        for (Forme f: formes){
            f.symetriecentrale(x, y);
        }
        
    }

}