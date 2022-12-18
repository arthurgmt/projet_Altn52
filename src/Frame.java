import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class Frame extends JFrame{

	private ArrayList <Dessin> dessins;
    private Dessin dessinParent;
    private int indexDessinPrent;
    private Image imageParent;
    private int indexImageParent;

	public Frame(int width, int height) {

        setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		setPreferredSize(new Dimension(width,height));
		pack();


        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton addDessin = new JButton("Ajouter un dessin");
        JButton modifDessin = new JButton("Modifier un dessin");

		JButton addImage = new JButton("Ajouter une image");
        JButton modifImage = new JButton("Modifier une image");
        JButton transformDessin = new JButton("Appliquer un transformation à un Dessin");

		addDessin.addActionListener(e -> this.addDessin());
		modifDessin.addActionListener(e -> this.modifDessin(panel));
        
        panel.add(addDessin);
        panel.add(modifDessin);

		// panel.add(addImage);
        // panel.add(modifImage);

		add(panel);

        setVisible(true);
	}

	public void addDessin(){
		Dessin dnew = new Dessin();
		dessins.add(dnew);
	}
	
	public void modifDessin(JPanel panel){
		String[10] options = {};
		for (int i=1;i<this.dessins.size();i++){
			String current = Integer.toString(i);
			options[i-1] = current;
		}

        JComboBox comboBox = new JComboBox(options);

		this.add(comboBox);
        this.validate();
		
	}


}