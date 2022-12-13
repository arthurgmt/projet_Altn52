import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class Image implements Transformation{
    
    TreeSet<Forme> formes;

    ComparateurForme comparateurForme = new ComparateurForme();
    public Image(){
        this.formes = new TreeSet<Forme>(comparateurForme);
    }

    public void addForme(Forme f){
        this.formes.add(f);
    }

    //getter
    public TreeSet<Forme> getFormes(){
        return this.formes;
    }

    public double getPerimetre(){
        double perimetre = 0;
        for(Forme forme : formes){
            perimetre += forme.getPerimetre();
        }
        return perimetre;
    }
    public double getAire(){
        double aire = 0;
        for(Forme forme : formes){
            aire += forme.getAire();
        }
        return aire;
    }

    @Override
    public void homothetie(float x) {
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

    @Override
    public void rotation() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        else if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        else{
            return true;
        }
    }
}