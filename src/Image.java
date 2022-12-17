import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class Image implements Transformation{
    
    TreeSet<Forme> formes;

    ComparateurForme comparateurForme = new ComparateurForme();
    public Image(){
        this.formes = new TreeSet<Forme>(comparateurForme);
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

    public void addForme(Forme f){
        this.formes.add(f);
    }

    @Override
    public void homothetie(float x) {
        for (Forme f: formes){
            f.homothetie(x);
        }
    }

    @Override
    public void translation(int x, int y) {
        for (Forme f: formes){
            f.translation(x, y);
        }
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
        for (Forme f: formes){
            f.rotation();
        }
    }

    public void affichagePartielImage(){
        int i = 0;
        for (Forme forme : this.formes){
            i++;
            forme.updatePerimetre();
            forme.updateAire();
            System.out.println(i + "- " + forme.getClass().getName() + " = périmètre : " + (double) Math.round(forme.getPerimetre() * 100) / 100 + " | aire : " + (double) Math.round(forme.getAire() * 100) / 100);
        }
    }
    public void affichageCompletImage(){
        int i = 0;
        for (Forme forme : this.formes){
            i++;
            forme.updatePerimetre();
            forme.updateAire();
            System.out.println(i + "- " + forme.getClass().getName() + " = périmètre : " + (double) Math.round(forme.getPerimetre() * 100) / 100 + " | aire : " + (double) Math.round(forme.getAire() * 100) / 100
                    + " | " + forme.getPoints());
        }
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

    @Override
    public String toString() {
        return "Image : \n" + formes + "\n";
    }
}