import java.util.ArrayList;
import java.util.Scanner;

public class MenuConsole {
    ArrayList <Dessin> dessins;
    Dessin dessinParent;
    int indexDessinPrent;
    Image imageParent;
    int indexImageParent;

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
        Scanner sc = new Scanner(System.in);
        int choix = Integer.parseInt(sc.nextLine());
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
                "1- Modifier une image \n" +
                "2- Dupliquer le dessin\n" +
                "3- Appliquer une transformation au dessin\n" +
                "4- Revenir en arrière");
        Scanner sc = new Scanner(System.in);
        int choix = Integer.parseInt(sc.nextLine());
        switch (choix){
            case 1 :
                Image image = null;
                int indexImage = 0;
                do{
                    System.out.println("Quelle image souhaitez-vous modifier ?");
                    int choixImage = Integer.parseInt(sc.nextLine());
                    for (Image img : dessin.getImages()){
                        indexImage++;
                        if (indexImage == choixImage) image = img;
                    }
                }while(image == null);
                this.imageParent = image;
                this.indexImageParent = indexImage;
                menuImage(image, indexImage);
                break;
            case 2 :
                Dessin dnew = new Dessin();
                dnew = dessin.copie();
                this.dessins.add(dnew);
                menuDessin(dessin, index);
                break;
            case 3 :
                menuTransformation(dessin, index);
                break;
            case 4:
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
                "1- Modifier une forme \n" +
                "2- Appliquer une transformation à l'image\n" +
                "3- Revenir en arrière");
        Scanner sc = new Scanner(System.in);
        int choix = Integer.parseInt(sc.nextLine());
        switch (choix){
            case 1 :
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
            case 2 :
                menuTransformation(image, index);
                break;
            case 3:
                menuDessin(this.dessinParent, this.indexDessinPrent);
            default:
                System.out.println("Erreur de saisie");
                menuPrincipal();
                break;
        }
    }

    public void menuTransformation(Object obj, int index){
        System.out.printf("Quel transformation souhaitez vous appliquer ?\n" +
                "1- L'homothétie \n" +
                "2- La translation\n" +
                "3- La symétrie centrale\n" +
                "4- La rotation de 90°\n" +
                "5- La symétrie axiale\n" +
                "6- Revenir en arrère");
        Scanner sc = new Scanner(System.in);
        int choix = Integer.parseInt(sc.nextLine());
        float choixY = 0;
        float choixX = 0;
        switch(choix){
            case 1 :
                do{
                    System.out.println("Entrer la valeur de X (entrer R pour revenir en arrière)");
                    String saisie = sc.nextLine();
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
                    String saisie = sc.nextLine();
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
                    String saisie = sc.nextLine();
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
                    String saisie = sc.nextLine();
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
                    choixY= Integer.parseInt(sc.nextLine());
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
            default:
                System.out.println("Erreur de saisie");
                menuTransformation(obj, index);
                break;
        }
    }
}