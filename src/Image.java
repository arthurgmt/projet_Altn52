import java.text.Normalizer.Form;
import java.util.ArrayList;

public class Image implements Transformation{
    
    ArrayList<Forme> formes;


    public Image(){
        this.formes = new ArrayList<Forme>();
    }

    public void addForme(Forme f){
        this.formes.add(f);
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
    public void symetrieaxiale() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void symetriecentrale() {
        // TODO Auto-generated method stub
        
    }

}