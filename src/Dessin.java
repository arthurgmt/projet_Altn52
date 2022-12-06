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

public class Dessin extends JPanel implements Transformation{

    ArrayList<Image> images;

    public Dessin(){
        this.images = new ArrayList<Image>();
    }

    public Dessin(ArrayList<Image> images){
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
    public ArrayList<Image> getImages(){
        return this.images;
    }

    @Override
    public void homothetie() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void translation(int x, int y) {
        // TODO Auto-generated method stub
        
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
    
}