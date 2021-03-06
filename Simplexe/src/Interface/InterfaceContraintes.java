package Interface;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.text.NumberFormat;

import Ecouteur.EcouteurAccueil;
import Ecouteur.EcouteurContraintes;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class InterfaceContraintes extends JFrame{

	private int nbContraintes;
	private int nbVariables;
	//private ArrayList<JTextField> tabVariables;
        private ArrayList<JFormattedTextField> tabVariables;
        private ArrayList<JTextField> tabMaximisant;
	private ArrayList<JTextField> tabResult;
	private ArrayList<JTextField> tabFonctionEco;
	private ArrayList<JLabel> tabNomVariable;
        private ArrayList<JComboBox> tabSigne;

	private JButton boutonMethode1=new JButton("Résolution 1ere Methode");
        private JButton boutonMethode2=new JButton("Résolution 2ème Methode");
	public JFrame maFenetre=new JFrame("Simplexe - TOMIO & NAVARRO");

	public InterfaceContraintes(int nbContraintes, int nbVariables)
	{
		this.nbContraintes=nbContraintes;
		this.nbVariables=nbVariables;
		constructionAffichage();
	}

        private void constructionAffichage()
        {
            //tabVariables = new ArrayList<JTextField>();
            tabVariables = new ArrayList<JFormattedTextField>();
            tabMaximisant = new ArrayList<JTextField>();
            tabFonctionEco = new ArrayList<JTextField>();
            tabNomVariable = new ArrayList<JLabel>();
            tabSigne = new ArrayList<JComboBox>();

            //Pannel Nord
            JPanel panelNord = new JPanel();
            JLabel variableFonctionEco;
            JTextField valeurVariableFonctionEco;
            JLabel fonctionEco = new JLabel("[MAX]Z = ");
            panelNord.setLayout(new GridLayout(1, nbVariables+1));
            panelNord.add(fonctionEco);

            for(int k=0;k<nbVariables;k++)
            {
                variableFonctionEco = new JLabel("X"+k);
                valeurVariableFonctionEco= new JTextField();
                tabNomVariable.add(variableFonctionEco);
                tabFonctionEco.add(valeurVariableFonctionEco);
                panelNord.add(valeurVariableFonctionEco);
                panelNord.add(variableFonctionEco);
            }

            //Pannel centre
            JPanel panelCentre = new JPanel();
            panelCentre.setLayout((new GridLayout(nbContraintes,nbVariables+2)));
            JLabel variables;
            //JTextField valeurVariables;
            JFormattedTextField valeurVariables;
            JTextField result;
            JComboBox signe;


            for(int i=0;i<nbContraintes;i++)
            {
                for(int j=0;j<nbVariables;j++)
                {
                    variables = new JLabel("X"+j);
                    //valeurVariables = new JTextField();
                    valeurVariables = new JFormattedTextField(NumberFormat.getNumberInstance());
                    tabVariables.add(valeurVariables);
                    panelCentre.add(valeurVariables);
                    panelCentre.add(variables);
                }
                result = new JTextField();
                signe = new JComboBox();
                signe.addItem(">=");
                signe.addItem("=");
                signe.addItem("<=");
                tabSigne.add(signe);
                tabMaximisant.add(result);
                panelCentre.add(signe);
                panelCentre.add(result);

            }

            //panel sud
            JPanel panelSud = new JPanel();
            panelSud.setLayout((new GridLayout(1,2)));
            panelSud.add(boutonMethode1);
            panelSud.add(boutonMethode2);

            maFenetre.add(panelNord,BorderLayout.NORTH);
            maFenetre.add(panelCentre,BorderLayout.CENTER);
            maFenetre.add(panelSud,BorderLayout.SOUTH);
         
            boutonMethode1.addActionListener(new EcouteurContraintes(this, nbContraintes, nbVariables));
            boutonMethode2.addActionListener(new EcouteurContraintes(this, nbContraintes, nbVariables));
            maFenetre.pack();
            maFenetre.setVisible(true);
        }


	public void closeContrainte()
	{
		maFenetre.setVisible(false);
	}

	public ArrayList<JFormattedTextField> getTabVariables()
	{
		return tabVariables;
	}

	public ArrayList<JTextField> getTabResult()
	{
		return tabResult;
	}

        public ArrayList<JTextField> getTabMaximisant()
        {
             return tabMaximisant;
        }

	public ArrayList<JTextField> getTabFonctionEco()
	{
		return tabFonctionEco;
	}

	public ArrayList<JLabel> getTabNomVariable()
	{
		return tabNomVariable;
	}

	public ArrayList<JComboBox> getTabSigne()
	{
		return tabSigne;
	}

    public JButton getBoutonMethode1() {
        return boutonMethode1;
    }

    public JButton getBoutonMethode2() {
        return boutonMethode2;
    }

        
}
