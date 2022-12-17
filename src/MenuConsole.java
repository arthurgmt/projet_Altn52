import java.util.ArrayList;
import java.util.Scanner;

public class MenuConsole {
    private ArrayList <Dessin> dessins;
    private Dessin dessinParent;
    private int indexDessinPrent;
    private Image imageParent;
    private int indexImageParent;
    private Scanner sc = new Scanner(System.in);

    public MenuConsole (ArrayList<Dessin> dessins){
        this.dessins = dessins;
    }
    public void menuPrincipal (){
        for (int i = 0; i < dessins.size(); i++){
            System.out.println("*Dessin n° " + (i+1) + " :");
            for (Image image : dessins.get(i).getImages()){
                image.affichagePartielImage();
            }
        }
        System.out.printf("\nQue souhaitez-vous faire ?\n" +
                "1- Modifier un dessin\n" +
                "2- Ajouter un dessin\n" +
                "3- Passer en mode IHM\n" +
                "4- Quitter\n");
        int choix = Integer.parseInt(this.sc.nextLine());
        switch (choix){
            case 1 : System.out.println("\n" + "A quel dessin souhaitez-vous apporter des modifications ? (entrer R pour revenir en arrière)");
                String saisie = sc.nextLine();
                char carac = saisie.charAt(0);
                if (carac == 'R'){
                    menuPrincipal();
                }else{
                    choix= Integer.parseInt(saisie);
                    Dessin dessin = new Dessin();
                    try {
                        dessin = this.dessins.get(choix-1);
                    }catch (NullPointerException e){
                        menuPrincipal();
                    }
                    this.dessinParent = dessin;
                    this.indexDessinPrent = choix;
                    menuDessin(dessin, choix);
                }
                break;
            case 2 :
                Dessin dnew = new Dessin();
                dessins.add(dnew);
                menuPrincipal();
                break;
            case 3:
                System.out.println("TADA");
                break;
            case 4 :
                System.exit(1);
            default:
                System.out.println("Erreur de saisie");
                menuPrincipal();
                break;
        }
    }
    public void menuDessin(Dessin dessin, int index){
        System.out.println("\nVoici la liste détaillée des images du dessin n°"+index);

        int i = 0;
        for (Image image : dessin.getImages()){
            i++;
            System.out.println("*Image n° " + i + " :");
            image.affichageCompletImage();
        }
        System.out.println("\n\nQue souhaitez-vous faire ?\n" +
                "1- Ajouter une image \n" +
                "2- Modifier une image \n" +
                "3- Dupliquer le dessin\n" +
                "4- Appliquer une transformation au dessin\n" +
                "5- Revenir en arrière\n");
        int choix = Integer.parseInt(this.sc.nextLine());
        switch (choix){
            case 1 :
                Image newImage = new Image();
                this.dessinParent.addImage(newImage);
                menuDessin(this.dessinParent, this.indexDessinPrent);
            case 2 :
                Image image = null;
                int indexImage = 0;
                do{
                    System.out.println("Quelle image souhaitez-vous modifier ?");
                    int choixImage = Integer.parseInt(this.sc.nextLine());
                    for (Image img : dessin.getImages()){
                        indexImage++;
                        if (indexImage == choixImage) image = img;
                    }
                }while(image == null);
                this.imageParent = image;
                this.indexImageParent = indexImage;
                menuImage(image, indexImage);
                break;
            case 3 :
                Dessin dnew = new Dessin();
                dnew = dessin.copie();
                this.dessins.add(dnew);
                menuDessin(dessin, index);
                break;
            case 4 :
                menuTransformation(dessin, index);
                break;
            case 5 :
                menuPrincipal();
                break;
            default:
                System.out.println("Erreur de saisie");
                menuPrincipal();
                break;
        }
    }
    public void menuImage (Image image, int index){
        System.out.println("\n\nVoici la liste détaillée des formes de l'image n°"+index);
        image.affichageCompletImage();
        System.out.println("\nQue souhaitez-vous faire ?\n" +
                "1- Ajouter une forme \n" +
                "2- Modifier une forme \n" +
                "3- Appliquer une transformation à l'image\n" +
                "4- Revenir en arrière");
        int choix = Integer.parseInt(this.sc.nextLine());
        switch (choix){
            case 1:
                int indexNewForme = -1;
                do{
                    System.out.println("Quelle forme souhaitez-vous ajouter ?\n" + "1- Ellipse\n" + "2- Cercle\n" +
                            "3- Trait\n" + "4- Carré\n" + "5- Rectangle\n" + "6- Polygone\n" + "7- Retour en arrière\n");
                    indexNewForme = Integer.parseInt(this.sc.nextLine());
                    menuForme(indexNewForme);
                }while(indexNewForme<0 && indexNewForme<8);
                menuImage(this.imageParent, this.indexImageParent);
                break;
            case 2 :
                Forme forme = null;
                int indexForme = 0;
                do{
                    System.out.println("Quelle forme souhaitez-vous modifier ?");
                    int choixForme = Integer.parseInt(sc.nextLine());
                    for (Forme frm : image.getFormes()){
                        indexForme++;
                        if (indexForme == choixForme) forme = frm;
                    }
                }while(forme == null);
                menuTransformation(forme, indexForme);
                break;
            case 3 :
                menuTransformation(image, index);
                break;
            case 4:
                menuDessin(this.dessinParent, this.indexDessinPrent);
            default:
                System.out.println("Erreur de saisie");
                menuPrincipal();
                break;
        }
    }
    public void menuForme(int index){
        int width;
        switch (index){
            case 1 :
                Elipse elipse = new Elipse(saisieUtilisateur(1), saisieUtilisateur(2), saisieUtilisateur(3), saisieUtilisateur(4));
                this.imageParent.addForme(elipse);
                break;
            case 2 :
                width = saisieUtilisateur(3);
                Elipse cercle = new Elipse(saisieUtilisateur(1), saisieUtilisateur(2), width, width);
                this.imageParent.addForme(cercle);
                break;
            case 3 :
                Trait trait = new Trait(saisieUtilisateur(1), saisieUtilisateur(2), saisieUtilisateur(1), saisieUtilisateur(2));
                this.imageParent.addForme(trait);
                break;
            case 4 :
                width = saisieUtilisateur(3);
                Rectangle carre = new Rectangle(saisieUtilisateur(1), saisieUtilisateur(2), width, width);
                this.imageParent.addForme(carre);
                break;
            case 5 :
                Rectangle rectangle = new Rectangle(saisieUtilisateur(1), saisieUtilisateur(2), saisieUtilisateur(3), saisieUtilisateur(4));
                this.imageParent.addForme(rectangle);
                break;
            case 6 :
                Polygone polygone = new Polygone();
                int saisiX = saisieUtilisateur(1);
                int saisiY = saisieUtilisateur(2);
                do {
                    polygone.addPoint(saisiX,saisiY);
                    saisiX = saisieUtilisateur(1);
                    saisiY = saisieUtilisateur(2);
                }while(saisiX>=0 && saisiY>=0);
                this.imageParent.addForme(polygone);
                break;
            default:
                System.out.println("Erreur");
                break;
        }
    }
    public int saisieUtilisateur(int choix){
        boolean valid = false;
        String input;
        int x =0;
        switch (choix){
            case 1 : input = "x"; break;
            case 2 : input = "y"; break;
            case 3 : input = "la largeur"; break;
            case 4 : input = "la hauteur"; break;
            default: input = ""; break;
        }
        do{
            try{
                System.out.println("Entrer la valeur de "+ input +" (entrer R pour revenir en arrière)");
                String saisie = this.sc.nextLine();
                char carac = saisie.charAt(0);
                if (carac == 'R'){
                    return -1;
                }
                else {
                    x= Integer.parseInt(saisie);
                    valid = true;
                }
            }catch (NullPointerException e){
                System.out.println("Erreur de saisie, un entier positif est attendu.");
                valid = false;
            }
        }while(valid == false);
        return x;
    }

    public void menuTransformation(Object obj, int index){
        System.out.printf("Quel transformation souhaitez vous appliquer ?\n" +
                "1- L'homothétie \n" +
                "2- La translation\n" +
                "3- La symétrie centrale\n" +
                "4- La rotation de 90°\n" +
                "5- La symétrie axiale\n" +
                "6- Revenir en arrère\n");
        int choix = Integer.parseInt(this.sc.nextLine());
        float choixY = 0;
        float choixX = 0;
        switch(choix){
            case 1 :
                do{
                    System.out.println("Entrer la valeur de X (entrer R pour revenir en arrière)");
                    String saisie = this.sc.nextLine();
                    char carac = saisie.charAt(0);
                    if (carac == 'R'){
                        menuTransformation(obj, index);
                    }
                    else {
                        choixX= Float.parseFloat(saisie);
                    }
                }while(choixX == 0);
                if (obj instanceof Dessin){
                    ((Dessin) obj).homothetie(choixX);
                    System.out.println("L'homothétie du dessin a été réalisée avec succès ! ");
                    menuDessin(((Dessin) obj), index);
                } else if (obj instanceof Image) {
                    ((Image) obj).homothetie(choixX);
                    System.out.println("L'homothétie de l'image a été réalisée avec succès ! ");
                    menuImage(((Image) obj), index);
                } else {
                    ((Forme) obj).homothetie(choixX);
                    System.out.println("L'homothétie de la forme a été réalisée avec succès ! ");
                    menuImage(this.imageParent, this.indexImageParent);
                }
                break;
            case 2:
                try{
                    System.out.println("Entrer la valeur de x (entrer R pour revenir en arrière)");
                    String saisie = this.sc.nextLine();
                    char carac = saisie.charAt(0);
                    if (carac == 'R'){
                        menuTransformation(obj, index);
                    }
                    else {
                        choixX= Integer.parseInt(saisie);
                    }
                }catch (NullPointerException e){
                    System.out.println("Erreur de saisie");
                    menuTransformation(obj, index);
                }
                try{
                    System.out.println("Entrer la valeur de y (entrer R pour revenir en arrière)");
                    String saisie = this.sc.nextLine();
                    char carac = saisie.charAt(0);
                    if (carac == 'R'){
                        menuTransformation(obj, index);
                    }
                    else {
                        choixY= Integer.parseInt(saisie);
                    }
                }catch (NullPointerException e){
                    System.out.println("Erreur de saisie");
                    menuTransformation(obj, index);
                }
                if (obj instanceof Dessin){
                    ((Dessin) obj).translation(((int)choixX), ((int)choixY));
                    System.out.println("La translation du dessin a été réalisée avec succès ! ");
                    menuDessin(((Dessin) obj), index);
                } else if (obj instanceof Image) {
                    ((Image) obj).translation(((int)choixX), ((int)choixY));
                    System.out.println("La translation de l'image a été réalisée avec succès ! ");
                    menuImage(((Image) obj), index);
                } else {
                    ((Forme) obj).translation(((int)choixX), ((int)choixY));
                    System.out.println("La translation de la forme a été réalisée avec succès ! ");
                    menuImage(this.imageParent, this.indexImageParent);
                }
                break;
            case 3:
                try{
                    System.out.println("Entrer la valeur de x (entrer R pour revenir en arrière)");
                    String saisie = this.sc.nextLine();
                    char carac = saisie.charAt(0);
                    if (carac == 'R'){
                        menuTransformation(obj, index);
                    }
                    else {
                        choixX= Integer.parseInt(saisie);
                    }
                }catch (NullPointerException e){
                    System.out.println("Erreur de saisie");
                    menuTransformation(obj, index);
                }
                try{
                    System.out.println("Entrer la valeur de y");
                    choixY= Integer.parseInt(this.sc.nextLine());
                }catch (NullPointerException e){
                    System.out.println("Erreur de saisie");
                    menuTransformation(obj, index);
                }
                if (obj instanceof Dessin){
                    ((Dessin) obj).symetriecentrale(((int)choixX), ((int)choixY));
                    System.out.println("La symétrie centrale du dessin a été réalisée avec succès ! ");
                    menuDessin(((Dessin) obj), index);
                } else if (obj instanceof Image) {
                    ((Image) obj).symetriecentrale(((int)choixX), ((int)choixY));
                    System.out.println("La symétrie centrale de l'image a été réalisée avec succès ! ");
                    menuImage(((Image) obj), index);
                } else {
                    ((Forme) obj).symetriecentrale(((int)choixX), ((int)choixY));
                    System.out.println("La symétrie centrale de la forme a été réalisée avec succès ! ");
                    menuImage(this.imageParent, this.indexImageParent);
                }
                break;
            case 4 :
                if (obj instanceof Dessin){
                    ((Dessin) obj).rotation();
                    System.out.println("La rotation du dessin a été réalisée avec succès ! ");
                    menuDessin(((Dessin) obj), index);
                } else if (obj instanceof Image) {
                    ((Image) obj).rotation();
                    System.out.println("La rotation de l'image a été réalisée avec succès ! ");
                    menuImage(((Image) obj), index);
                } else {
                    ((Forme) obj).rotation();
                    System.out.println("La rotation de la forme a été réalisée avec succès ! ");
                    menuImage(this.imageParent, this.indexImageParent);
                }
                break;
            case 5 :
                if (obj instanceof Dessin){
                    ((Dessin) obj).symetrieaxiale();
                    System.out.println("La symétrie axiale du dessin a été réalisée avec succès ! ");
                    menuDessin(((Dessin) obj), index);
                } else if (obj instanceof Image) {
                    ((Image) obj).symetrieaxiale();
                    System.out.println("La symétrie axiale de l'image a été réalisée avec succès ! ");
                    menuImage(((Image) obj), index);
                } else {
                    ((Forme) obj).symetrieaxiale();
                    System.out.println("La symétrie axiale de la forme a été réalisée avec succès ! ");
                    menuImage(this.imageParent, this.indexImageParent);
                }
                break;
            case 6 :
                menuDessin(this.dessinParent, this.indexDessinPrent);
            default:
                System.out.println("Erreur de saisie");
                menuTransformation(obj, index);
                break;
        }
    }
}