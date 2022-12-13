import java.util.Comparator;

public class ComparateurForme implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if(((Forme)o1).getPerimetre() == ((Forme)o2).getPerimetre()){
            return (int) (((Forme)o1).getAire() - ((Forme)o2).getAire());
        }
        else{
            return (int) (((Forme)o1).getPerimetre() - ((Forme)o2).getPerimetre());
        }
    }
}
