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
    public void translation(int x, int y) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void symetrieaxiale() {
        for (Forme f: formes){
            f.symetrieaxiale();
        }
    }

    @Override
    public void symetriecentrale(int x, int y) {
        for (Forme f: formes){
            f.symetriecentrale(x, y);
        }
        
    }

}