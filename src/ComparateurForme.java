import java.util.Comparator;

public class ComparateurForme implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if(((Point)o1).updatePerimetre() == ((Point)o2).updatePerimetre()){
            return ((Point)o1).updateAire() - ((Point)o2).updateAire();
        }
        else{
            return ((Point)o1).updatePerimetre() - ((Point)o2).updatePerimetre();
        }
    }
}
