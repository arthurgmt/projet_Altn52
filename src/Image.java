import java.util.TreeSet;

public class Image implements Transformation{
    
    TreeSet<Forme> formes;

    public Image(){
        this.formes = new TreeSet<Forme>();
    }

    public void addForme(Forme f){
        this.formes.add(f);
    }

    //getter
    public TreeSet<Forme> getFormes(){
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
    public void symetrieaxiale() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void symetriecentrale() {
        // TODO Auto-generated method stub
        
    }

}