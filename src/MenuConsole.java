import java.util.ArrayList;
import java.util.Scanner;

public class MenuConsole {
    ArrayList <Dessin> dessins;
    public MenuConsole (ArrayList<Dessin> dessins){
        this.dessins = dessins;
    }
    public void menuPrincipal (){
        System.out.printf("Que souhaitez-vous faire ?\n" +
                "1- Afficher la liste des dessin\n" +
                "2- Ajouter un dessin\n");
        Scanner sc = new Scanner(System.in);
        String choix = sc.nextLine();
        switch (choix){
            case "1" : afficherListeDessin(); break;
            case "2" : Dessin dnew = new Dessin(); break;
            default:
                System.out.println("Erreur de saisie");
                menuPrincipal();
                break;
        }
    }
    public void afficherListeDessin(){
        for (int i = 0; i < dessins.size(); i++){
            System.out.println((i+1) + "- " + dessins.get(i));
        }
    }
}
