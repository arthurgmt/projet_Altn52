import java.util.Comparator;

public class ComparateurForme implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if(((Forme)o1).updatePerimetre() == ((Forme)o2).updatePerimetre()){
            return ((Forme)o1).updateAire() - ((Forme)o2).updateAire();
        }
        else{
            return ((Forme)o1).updatePerimetre() - ((Forme)o2).updatePerimetre();
        }
    }
}
