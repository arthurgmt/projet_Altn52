import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class Frame extends JFrame{

	private ArrayList <Dessin> dessins;
    private Dessin dessinParent;
    private int indexDessinPrent;
    private Image imageParent;
    private int indexImageParent;
	private JPanel panelP;
	private JPanel panelListeDessin;
	private JPanel menuDessin, menuImage, menuForme;
	private JComboBox comboBoxDessin, comboBoxImage, comboBoxForme;
	private JPanel panelDessin;
	private Image inew;

	public Frame(){
		this.setVisible(true);
		setPreferredSize(new Dimension(1000,1000));
		pack();
	}
	public Frame(int width, int height, ArrayList<Dessin> dessins) {
		this.dessins = dessins;
		this.comboBoxDessin = new JComboBox<String>();

		this.comboBoxImage = new JComboBox<String>();

		this.comboBoxForme = new JComboBox<String>();

        setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		setPreferredSize(new Dimension(width,height));
		pack();


        this.panelP = new JPanel();
        this.panelP.setLayout(new FlowLayout());


		this.menuDessin = new JPanel();
		this.panelP.add(this.menuDessin);

		this.menuImage = new JPanel();
		this.panelP.add(this.menuImage);

		this.menuForme = new JPanel();
		this.panelP.add(this.menuForme);

		menuDessin();

		JPanel zoneDessin = new JPanel();
		JButton dessiner = new JButton("Dessiner");
		zoneDessin.add(dessiner);
		this.panelDessin = new JPanel();

		zoneDessin.add(this.panelDessin);
		dessiner.addActionListener(e-> this.dessiner());
		this.panelP.add(zoneDessin);


		JButton addImage = new JButton("Ajouter une image");
        JButton modifImage = new JButton("Modifier une image");
        JButton transformDessin = new JButton("Appliquer un transformation à un Dessin");




		this.panelListeDessin = new JPanel();
        //this.panelP.add(this.menuDessin);
		//this.panelP.add(this.panelListeDessin);


		add(panelP);

        setVisible(true);
	}
	public void menuDessin(){
		this.menuDessin.removeAll();

		JButton addDessin = new JButton("Ajouter un dessin");
		addDessin.addActionListener(e -> this.addDessin());
		this.menuDessin.add(addDessin);
		setVisible(true);
	}
	public void menuImage(int index){
		this.dessinParent =  dessins.get(index);
		this.indexDessinPrent = index;
		this.menuImage.removeAll();
		JButton cloneDessin = new JButton("Copie dessin");
		JButton addImage = new JButton("Ajouter une image");
		addImage.addActionListener(e-> addImage());
		cloneDessin.addActionListener(e->{
			dessins.add(this.dessinParent.copie());
		});
		this.menuImage.add(addImage);
		this.menuImage.add(cloneDessin);
		setVisible(true);
	}
	public void menuForme(int index){
		this.indexImageParent = index;
		int i = 0;
		for (Image image : this.dessinParent.getImages()){
			if (i == index){
				this.imageParent = image;
			}
			i++;
		}
		this.menuForme.removeAll();
		JButton addForme = new JButton("Ajouter une forme");
		JLabel transformation = new JLabel("Transformation");
		addForme.addActionListener(e-> addForme());

		this.menuForme.add(transformation);
		JComboBox<String> comboBoxTypeTransfo = new JComboBox<>();
		comboBoxTypeTransfo.addItem("Homothétie");
		comboBoxTypeTransfo.addItem("Translation");
		comboBoxTypeTransfo.addItem("Symétrie centrale");
		comboBoxTypeTransfo.addItem("Symétrie axiale");
		comboBoxTypeTransfo.addItem("Rotation");
		comboBoxTypeTransfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				transformation(comboBoxTypeTransfo.getSelectedItem().toString());
			}
		});
		this.menuForme.add(comboBoxTypeTransfo);

		this.menuForme.add(addForme);


		setVisible(true);
	}

	public void addDessin(){
		Dessin dnew = new Dessin();
		dessins.add(dnew);
		if (this.dessins.size()==1){
			JButton modifDessin = new JButton("Modifier un dessin");
			modifDessin.addActionListener(e -> this.modifDessin());
			this.menuDessin.add(modifDessin);
		}
		setVisible(true);
	}
	public void addImage(){
		this.inew = new Image();
		this.dessins.get(this.indexDessinPrent).addImage(new Image());

		if (this.dessins.get(this.indexDessinPrent).getImages().size()==1){
			JButton modifImage = new JButton("Modifier une image");
			modifImage.addActionListener(e -> this.modifImage());
			this.menuImage.add(modifImage);
		}
		setVisible(true);
	}

	public void addForme(){
		JComboBox<String> comboBoxTypeForme = new JComboBox<>();
		comboBoxTypeForme.addItem("Ellipse");
		comboBoxTypeForme.addItem("Cercle");
		comboBoxTypeForme.addItem("Trait");
		comboBoxTypeForme.addItem("Carré");
		comboBoxTypeForme.addItem("Rectangle");
		comboBoxTypeForme.addItem("Polygone");

		comboBoxTypeForme.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(comboBoxTypeForme.getSelectedItem().toString() == "Ellipse"){
					Ellipse ellipse = new Ellipse((int)(Math.random()*(50)+1),(int)(Math.random()*(50)+1), (int)(Math.random()*(20)+1),(int)(Math.random()*(20)+1));
					imageParent.addForme(ellipse);
				} else if(comboBoxTypeForme.getSelectedItem().toString() == "Cercle"){
					int largeur = (int)(Math.random()*(20)+1);
					Ellipse cercle = new Ellipse((int)(Math.random()*(200)+1),(int)(Math.random()*(200)+1), largeur,largeur);
					imageParent.addForme(cercle);
				} else if(comboBoxTypeForme.getSelectedItem().toString() == "Trait"){
					Trait trait = new Trait((int)(Math.random()*(200)+1),(int)(Math.random()*(200)+1),(int)(Math.random()*(200)+1),(int)(Math.random()*(200)+1));
					imageParent.addForme(trait);
				} else if(comboBoxTypeForme.getSelectedItem().toString() == "Carré"){
					int largeur = (int)(Math.random()*(20)+1);
					Rectangle carre = new Rectangle((int)(Math.random()*(200)+1),(int)(Math.random()*(200)+1), largeur,largeur);
					imageParent.addForme(carre);
				} else if(comboBoxTypeForme.getSelectedItem().toString() == "Rectangle"){
					Rectangle rectangle = new Rectangle((int)(Math.random()*(200)+1),(int)(Math.random()*(200)+1), (int)(Math.random()*(20)+1),(int)(Math.random()*(20)+1));
					imageParent.addForme(rectangle);
				} else if(comboBoxTypeForme.getSelectedItem().toString() == "Polygone"){
					Polygone polygone = new Polygone();
					polygone.addPoint((int)(Math.random()*(200)+1), (int)(Math.random()*(200)+1));
					polygone.addPoint((int)(Math.random()*(200)+1), (int)(Math.random()*(200)+1));
					polygone.addPoint((int)(Math.random()*(200)+1), (int)(Math.random()*(200)+1));
					polygone.addPoint((int)(Math.random()*(200)+1), (int)(Math.random()*(200)+1));
					polygone.addPoint((int)(Math.random()*(200)+1), (int)(Math.random()*(200)+1));
					imageParent.addForme(polygone);
				}
			}
		});
		this.menuForme.add(comboBoxTypeForme);
		setVisible(true);
	}
	public void modifDessin(){
		this.comboBoxDessin.removeAllItems();
		for (int i=1;i<=this.dessins.size();i++){
			String current = Integer.toString(i);
			this.comboBoxDessin.addItem(current);
		}
		this.comboBoxDessin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuImage((Integer.parseInt(comboBoxDessin.getSelectedItem().toString()))-1);
			}
		});
		this.menuDessin.add(this.comboBoxDessin);
		setVisible(true);
	}
	public void modifImage(){
		this.comboBoxImage.removeAllItems();
		for (int i=1;i<=this.dessins.get(this.indexDessinPrent).getImages().size();i++){
			String current = Integer.toString(i);
			this.comboBoxImage.addItem(current);
		}
		this.comboBoxImage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuForme((Integer.parseInt(comboBoxImage.getSelectedItem().toString()))-1);
			}
		});
		this.menuImage.add(this.comboBoxImage);
		setVisible(true);
	}



	public void dessiner(){
		Frame newFrame = new Frame();
		for(Dessin dessin : this.dessins) {
			newFrame.add(dessin);
		}
		newFrame.setVisible(true);
	}

	public void transformation(String transfo){
		if ( transfo == "Homothétie"){
			this.imageParent.homothetie(2);
		} else if (transfo == "Translation") {
			this.imageParent.translation(5, 5);
		}else if (transfo == "Symétrie centrale") {
			this.imageParent.symetriecentrale(3,3);
		}else if (transfo == "Symétrie axiale") {
			this.imageParent.symetrieaxiale();
		}else {
			this.imageParent.rotation();
		}
	}

}