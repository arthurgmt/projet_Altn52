import org.w3c.dom.css.Rect;

import java.util.TreeSet;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.lang.model.type.ArrayType;
import javax.swing.JPanel;

public class Dessin extends JPanel implements Transformation, Cloneable{

    TreeSet<Image> images;
    ComparateurImage comparateurImage = new ComparateurImage();
    public Dessin(){
        this.images = new TreeSet<Image>(comparateurImage);
    }

    public Dessin copie (){
        Dessin d2 = new Dessin();
        String type;
        Image newImage;
        Forme newForme;
        for (Image image : this.images){
            newImage = new Image();
            for (Forme forme : image.formes){
                if (forme instanceof Elipse){
                    newForme = new Elipse(forme.getPoints().get(0).getX()+500, forme.getPoints().get(0).getY(), ((Elipse) forme).getWidth(), ((Elipse) forme).getHeight());
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
    public Dessin(TreeSet<Image> images){
        this.images = images;
    }

    public void addImage(Image i){
        this.images.add(i);
    }


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


    //getter
    public TreeSet<Image> getImages(){
        return this.images;
    }

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
        // TODO Auto-generated method stub
        
    }

    @Override
    public String toString() {
        return "Dessin : \n" + images;
    }
}