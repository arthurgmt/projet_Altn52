import java.awt.Graphics;
import javax.swing.*;

public class DrawMyCercle extends JPanel
{
  public void paint(Graphics g){
    g.drawOval(100, 100, 100, 100);  
  }
  
  public static void main(String[] args){
    JFrame f = new JFrame("Dessiner un cercle");
    f.getContentPane().add(new DrawMyCercle());
    f.setSize(300, 300);
    f.setVisible(true);
    f.setResizable(false);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}