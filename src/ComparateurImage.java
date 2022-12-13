import java.util.Comparator;

public class ComparateurImage implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if(((Image)o1).updatePerimetre() == ((Image)o2).updatePerimetre()){
            return ((Image)o1).updateAire() - ((Image)o2).updateAire();
        }
        else{
            return ((Image)o1).updatePerimetre() - ((Image)o2).updatePerimetre();
        }
    }
}
