package myPackage;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;


public class GUI  implements ActionListener 
{
    private JFrame frame;
	private DossierBancaire m_dossier;
	private JTextField m_saisie_depot;
	private JTextField m_display_solde;
	private JButton m_remuneration;
    private JLabel label_remunerer;
    private JLabel label_depot;
    private JLabel label_solde;
    private JRadioButton checkbox_client;
    private JRadioButton checkbox_banquier;
    
	// Constructeur
    public GUI(DossierBancaire d)
    {
    	//Dossier bancaire
    	m_dossier = d;
    	
        // Attribution Role client/banquier
        checkbox_client = new JRadioButton("Client");    
        checkbox_banquier = new JRadioButton("Banquier");    
        ButtonGroup bg = new ButtonGroup();    
        bg.add(checkbox_client);bg.add(checkbox_banquier); 
        checkbox_client.addActionListener(this);
        checkbox_banquier.addActionListener(this);

    	//Element saisie label_depot
        m_saisie_depot = new JTextField (20);
        m_saisie_depot.addActionListener(this);
        label_depot = new JLabel("Dépot");

        //Element declenchement remuneration
        m_remuneration = new JButton("OK");
        m_remuneration.addActionListener(this);
        label_remunerer = new JLabel("Remunérer");
        
    	//Element affichage du solde
        m_display_solde = new JTextField (20);
        m_display_solde.setEditable(false); //Pour eviter d'ecrire
        m_display_solde.setText(Double.toString(m_dossier.get_solde()));
        label_solde = new JLabel("Solde");
        
        //Initialisation de la fenetre generale
        frame = new JFrame("Editeur dossier bancaire");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Geometrie de repartition des elements graphiques
        frame.setLayout(new GridLayout(4,2)); //4 lignes and 2 columns

        //First line
        frame.getContentPane().add(checkbox_client);
        frame.add(checkbox_banquier);  
        //Second line
        frame.getContentPane().add(label_solde);
        frame.getContentPane().add(m_display_solde);
        //Third line
        frame.getContentPane().add(label_depot);
        frame.getContentPane().add(m_saisie_depot);  
        //Forth line
        frame.getContentPane().add(label_remunerer);
        frame.getContentPane().add(m_remuneration);
        label_remunerer.setVisible(false);
        m_remuneration.setVisible(false);

        frame.pack(); //Causes this Window to be sized to fit the preferred size and layouts of its subcomponents.
        frame.setVisible(true); //Shows this Window
        
    }
    // Callbacks for buttons: dispatch processings
    public void actionPerformed(ActionEvent e)
    {
    	if( e.getSource() == m_saisie_depot )
    	{
    		float label_depot_value=Float.parseFloat(m_saisie_depot.getText());
    		m_dossier.deposer(label_depot_value);
    		m_saisie_depot.setText("");
    	}
    	if( e.getSource() == m_remuneration )
    	{
    		m_dossier.remunerer();
    	}
        if( e.getSource() == checkbox_client )
    	{
            label_remunerer.setVisible(false);
            m_remuneration.setVisible(false);
    	}
        if( e.getSource() == checkbox_banquier )
    	{
            label_remunerer.setVisible(true);
            m_remuneration.setVisible(true);
    	}
    	m_display_solde.setText(Double.toString(m_dossier.get_solde()));  	
    }
}
