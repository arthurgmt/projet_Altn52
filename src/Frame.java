import java.awt.Dimension;

import javax.swing.JFrame;

public class Frame extends JFrame{

	public Frame(int width, int height) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		setPreferredSize(new Dimension(width,height));
		pack();
	}
}