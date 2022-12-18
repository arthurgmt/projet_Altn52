package projet;

import java.util.Comparator;

public class ComparateurImage implements Comparator {
    public int compare(Object o1, Object o2) {
        if(((Image)o1).getPerimetre() == ((Image)o2).getPerimetre()){
            return (int) (((Image)o1).getAire() - ((Image)o2).getAire());
        }
        else{
            return (int) (((Image)o1).getPerimetre() - ((Image)o2).getPerimetre());
        }
    }
}
