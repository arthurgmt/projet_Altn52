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
        int choix = Integer.parseInt(sc.nextLine());
        switch (choix){
            case 1 : afficherListeDessin(); break;
            case 2 : Dessin dnew = new Dessin(); break;
            default:
                System.out.println("Erreur de saisie");
                menuPrincipal();
                break;
        }
    }
    public void afficherListeDessin(){
        for (int i = 0; i < dessins.size(); i++){
            System.out.println("*Dessin n° " + (i+1) + " :");
            for (Image image : dessins.get(i).getImages()){
                image.affichagePartielImage();
            }
        }
        System.out.println("\n" + "A quel dessin souhaitez-vous apporter des modifications ?");
        Scanner sc = new Scanner(System.in);
        int choix = Integer.parseInt(sc.nextLine());
        Dessin dessin = new Dessin();
        try {
            dessin = this.dessins.get(choix-1);
        }catch (NullPointerException e){
            afficherListeDessin();
        }
        menuDessin(dessin, choix);
    }

    public void menuDessin(Dessin dessin, int choix){
        System.out.println("Voici la liste détaillée des images du dessin n°"+choix);

        int i = 0;
        for (Image image : dessin.getImages()){
            i++;
            System.out.println("*Image n° " + i + " :");
            image.affichageCompletImage();
        }
        System.out.printf("Que souhaitez-vous faire ?\n" +
                "1- Modifier une image \n" +
                "2- Dupliquer le dessin\n" +
                "3- Appliquer une transformation au dessin");
        Scanner sc = new Scanner(System.in);
        choix = Integer.parseInt(sc.nextLine());
        switch (choix){
            case 1 :
                Image image = null;
                System.out.println("Quelle image souhaitez-vous modifier ?");
                int choixImage = Integer.parseInt(sc.nextLine());
                dessin.getImages()[choixImage-1];
                while(image == null){
                    System.out.println("Veuillez entrer un nombre correspondant à une image de la liste");
                }; break;
            case 2 : Dessin dnew = new Dessin(); break;
            default:
                System.out.println("Erreur de saisie");
                menuPrincipal();
                break;
        }
    }
    public void menuImage (Image image){
        System.out.println("Image");
    }
}
