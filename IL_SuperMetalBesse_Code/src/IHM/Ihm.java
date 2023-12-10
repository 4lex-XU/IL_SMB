package IHM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Set;

import Interfaces.*;
import Factory.*;

public class Ihm extends JFrame implements ActionListener {

	private ILivres gl;

	private JButton openBookButton;
	private JButton createBookButton;
	
	private JFrame createBookForm;
	
	private JTextField titleField;
	private JTextField authorField;
	private JButton validateButton;
	private JButton cancelButton;
	private JButton validateLivreButton;

	public Ihm() {
		gl = Factory.newGestionLivre();
		setTitle("Super Metal Besse");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setLayout(new FlowLayout());

		openBookButton = new JButton("Ouvrir un livre");
		createBookButton = new JButton("Creer un livre");

		openBookButton.addActionListener(this);
		createBookButton.addActionListener(this);

		add(openBookButton);
		add(createBookButton);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == openBookButton) {
			createBookForm = new JFrame("Liste des livres");
			createBookForm.setSize(300, 300); // Ajustez la taille selon le besoin
			createBookForm.setLayout(new BorderLayout()); // Utilisation de BorderLayout pour une meilleure disposition
	
			// Création de la liste des livres
			Set<ILivre> livres = gl.getListeLivres();
			DefaultListModel<String> listModel = new DefaultListModel<>();
			for (ILivre livre : livres) {
				listModel.addElement(livre.getTitre()); // Supposons que l'interface ILivre a une méthode getTitre()
			}
			JList<String> bookList = new JList<>(listModel);
			bookList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Permettre la sélection d'un seul livre à la fois
	
			// Ajout des composants à la fenêtre
			createBookForm.add(new JScrollPane(bookList), BorderLayout.CENTER); // Ajout de la JList dans un JScrollPane
	
			validateLivreButton = new JButton("Valider");
			cancelButton = new JButton("Annuler");
	
			validateLivreButton.addActionListener(this);
			cancelButton.addActionListener(this);
	
			JPanel buttonPanel = new JPanel(); // Un panel pour les boutons
			buttonPanel.add(validateLivreButton);
			buttonPanel.add(cancelButton);
	
			createBookForm.add(buttonPanel, BorderLayout.SOUTH); // Ajout du panel des boutons en bas
	
			createBookForm.setVisible(true);
		}
		else if (e.getSource() == validateLivreButton) {
			// Création de la nouvelle fenêtre pour les options supplémentaires
			createBookForm = new JFrame("Gestion du Livre");
			createBookForm.setSize(1000, 600); // Ajustez la taille selon le besoin
		
			// Créer les boutons pour les nouvelles fonctionnalités
			JButton createSectionButton = new JButton("+ Section");
			JButton createEnchainementButton = new JButton("+ Enchainement");
			JButton createObjeButton = new JButton("+ Objet");
			JButton generer = new JButton("Generer le livre");


			
			// Ajouter des écouteurs pour les actions des boutons
			createSectionButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TO-DO
				}
			});
			
			createEnchainementButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TO-DO
				}
			});
			
			createObjeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TO-DO
				}
			});

			generer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TO-DO
				}
			});
			// Panel pour les boutons
			JPanel buttonsPanel = new JPanel();
			buttonsPanel.add(createSectionButton);
			buttonsPanel.add(createEnchainementButton);
			buttonsPanel.add(createObjeButton);
			buttonsPanel.add(generer);
	
			createBookForm.add(buttonsPanel, BorderLayout.NORTH);
			createBookForm.setVisible(true);
		}
		
		else
		if (e.getSource() == createBookButton) {
			createBookForm = new JFrame("Creer un livre");
			createBookForm.setSize(300, 200);
			createBookForm.setLayout(new FlowLayout());

			titleField = new JTextField(20);
			authorField = new JTextField(20);

			validateButton = new JButton("Valider");
			cancelButton = new JButton("Annuler");

			validateButton.addActionListener(this);
			cancelButton.addActionListener(this);

			createBookForm.add(new JLabel("Titre"));
			createBookForm.add(titleField);
			createBookForm.add(new JLabel("Auteur"));
			createBookForm.add(authorField);
			createBookForm.add(validateButton);
			createBookForm.add(cancelButton);

			createBookForm.setVisible(true);
		}
		else if (e.getSource() == cancelButton) {
			createBookForm.dispose();
		}
		else if (e.getSource() == validateButton) {
			String titre = titleField.getText();
			String auteur = authorField.getText();
			gl.creerLivre(titre, auteur);
			createBookForm.dispose();
		}

	}



	public void affichageInterfaceEdition(String titreLivre, Boolean ouvert) {

	}


	public void affichageFormulaireObjets(Object titreLivre, Boolean ouvert) {

	}


	public void affichageProprietesSection(String titreLivre, Integer idSection, boolean ouvert) {

	}

	public void affichageProprietesEnchainement(String titreLivre, Integer idEnchainement, Boolean ouvert) {

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ihm ihm = new Ihm();
					ihm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}