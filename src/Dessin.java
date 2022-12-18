import java.util.TreeSet;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Dessin extends JPanel implements Transformation{

    //listes d'images
    TreeSet<Image> images;
    //comparateur qui permet le tri des images dans la liste par périmètres puis par aires
    ComparateurImage comparateurImage = new ComparateurImage();

    //constructeur : initialise la liste d'image à vide
    public Dessin(){
        this.images = new TreeSet<Image>(comparateurImage);
    }

    //constructeur : initialise la liste d'image grâce à la liste passée en attribut
    public Dessin(TreeSet<Image> images){
        this.images = images;
    }

    //permet d'ajouter une nouvelle image à la liste
    public void addImage(Image i){
        this.images.add(i);
    }

    //getter de la liste d'images
    public TreeSet<Image> getImages(){
        return this.images;
    }

    //retourne un nouveau dessin qui est une copie de l'actuel. Pour faire la copie la fonction parcourt les images
    // et crée une nouvelle image et l'ajoute au nouveau dessin. Puis elle parcourt les formes de chaque image et
    // crée une nouvelle forme en fonction de la classe de la forme actuelle. La nouvelle forme possède les mêmes
    //attributs que la forme actuelle.
    public Dessin copie (){
        Dessin d2 = new Dessin();
        String type;
        Image newImage;
        Forme newForme;
        for (Image image : this.images){
            newImage = new Image();
            for (Forme forme : image.formes){
                if (forme instanceof Ellipse){
                    newForme = new Ellipse(forme.getPoints().get(0).getX()+500, forme.getPoints().get(0).getY(), ((Ellipse) forme).getWidth(), ((Ellipse) forme).getHeight());
                } else if (forme instanceof Rectangle) {
                    newForme = new Rectangle(forme.getPoints().get(0).getX()+500, forme.getPoints().get(0).getY(), ((Rectangle) forme).getWidth(), ((Rectangle) forme).getHeight());
                } else {
                    if (forme instanceof Polygone) {
                        newForme = new Polygone();
                    } else{
                        newForme = new Trait();
                    }
                    for (Point point : forme.points){
                        newForme.addPoint(point.getX()+500, point.getY());
                    }
                }
                newImage.addForme(newForme);
            }
            d2.addImage(newImage);
        }
        return d2;
    }

    //todo commentaire de cette fonction
    @Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g.create();		
		g2.setStroke(new BasicStroke(2));

        g2.setColor(new Color(0,0,0));

		for(Image im : this.images) {

            for(Forme f : im.formes){
                f.paint(g2);
            }
		}
		g = g2;
	}


    //Les fonctions de transformation parcourent les images du dessin et appliquent la transformation à chaque image.
    @Override
    public void homothetie(float x) {
        for (Image i : images){
            i.homothetie(x);
        }
    }

    @Override
    public void translation(int x, int y) {
        for (Image i : images){
            i.translation(x, y);
        }
    }

    @Override
    public void symetrieaxiale() {
        for (Image i : images){
            i.symetrieaxiale();
        }
    }

    @Override
    public void symetriecentrale(int x, int y) {
        for (Image i : images){
            i.symetriecentrale(x, y);
        }
    }

    @Override
    public void rotation() {
        for (Image i : images){
            i.rotation();
        }
    }

    @Override
    public String toString() {
        return "Dessin : \n" + images;
    }
}