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
    private JTextField m_saisie_retirer;
	private JTextField m_display_solde;
	private JButton m_remuneration;
    private JLabel label_remunerer;
    private JLabel label_depot;
    private JLabel label_solde;
    private JLabel label_retirer;
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

        //Element saisie label_retirer
        m_saisie_retirer = new JTextField (20);
        m_saisie_retirer.addActionListener(this);
        label_retirer = new JLabel("Retirer");

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
        frame.setLayout(new GridLayout(5,2)); //5 lignes and 2 colonnes
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
        frame.getContentPane().add(label_retirer);
        frame.getContentPane().add(m_saisie_retirer);
        //Fifth line
        frame.getContentPane().add(label_remunerer);
        frame.getContentPane().add(m_remuneration);

        // l'option remunerer est desactivée au début du programme avant le choix du role client/banquier
        label_remunerer.setEnabled(false);
        m_remuneration.setEnabled(false);


        frame.pack(); //Causes this Window to be sized to fit the preferred size and layouts of its subcomponents.
        frame.setVisible(true); //Shows this Window
        
    }
    // Callbacks for buttons: dispatch processings
    public void actionPerformed(ActionEvent e)
    {
    	if( e.getSource() == m_saisie_depot ) // saisie du dépot
    	{
    		float label_depot_value=Float.parseFloat(m_saisie_depot.getText());
    		m_dossier.deposer(label_depot_value);
    		m_saisie_depot.setText("");
    	}
    	if( e.getSource() == m_remuneration ) // bouton "remunerer"
    	{
    		m_dossier.remunerer();
    	}
        if( e.getSource() == m_saisie_retirer ) // bouton "retirer"
    	{
    		float label_retirer_value=Float.parseFloat(m_saisie_retirer.getText());
    		m_dossier.retirer(label_retirer_value);
    		m_saisie_retirer.setText("");
    	}
        if( e.getSource() == checkbox_client ) //checkbox "client"
    	{
            // si l'utlisateur est banquier on désactive l'option remunérer
            m_remuneration.setEnabled(false);
            label_remunerer.setEnabled(false);
    	}
        if( e.getSource() == checkbox_banquier ) //checkbox "banquier"
    	{
            // si l'utlisateur est banquier on active l'option remunérer
            label_remunerer.setEnabled(true);
            m_remuneration.setEnabled(true);
    	}
        // actualisation du solde
    	m_display_solde.setText(Double.toString(m_dossier.get_solde()));  	
    }
}
