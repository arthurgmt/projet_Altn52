import java.util.ArrayList;

public class Dessin implements Transformation{

    ArrayList<Image> images;

    public Dessin(){
        this.images = new ArrayList<Image>();
    }

    public void addImage(Image i){
        this.images.add(i);
    }


    //getter
    public ArrayList<Image> getImages(){
        return this.images;
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