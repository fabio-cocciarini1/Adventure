package it.unicam.cs.mpgc.rpg126109.gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class FinestraMenu extends Finestra{

	Container contenutoPane = null;
	JFrame finestra;

	public FinestraMenu(String nomeFinestra){
		super(nomeFinestra);

		this.finestra = new JFrame(nomeFinestra);
		finestra.setBounds(750,500,300,300);
		contenutoPane = finestra.getContentPane();

		JButton nuovaPartita = new JButton("Nuovo Partita");
		JButton continua = new JButton("Continua");
		JButton esci = new JButton("Esci");
		
		nuovaPartita.addActionListener(new clicNuovaPartita());
		continua.addActionListener(new clicContinua());
		esci.addActionListener(new clicEsci());

		//contenutoPane.setLayout(new BoxLayout(contenutoPane,BoxLayout.PAGE_AXIS));

		JPanel contieniPulsanti = new JPanel();

		contieniPulsanti.setLayout(new BoxLayout(contieniPulsanti,BoxLayout.Y_AXIS));
		
		JPanel pulsante1 = new JPanel();
		JPanel pulsante2 = new JPanel();
		JPanel pulsante3 = new JPanel();

		pulsante1.setLayout(new BoxLayout(pulsante1,BoxLayout.X_AXIS));
		pulsante2.setLayout(new BoxLayout(pulsante2,BoxLayout.X_AXIS));
		pulsante3.setLayout(new BoxLayout(pulsante3,BoxLayout.X_AXIS));


		contieniPulsanti.add(Box.createVerticalGlue());

		pulsante1.add(Box.createHorizontalGlue());
		pulsante1.add(nuovaPartita);
		pulsante1.add(Box.createHorizontalGlue());

		contieniPulsanti.add(pulsante1);
		contieniPulsanti.add(Box.createVerticalGlue());

		pulsante2.add(Box.createHorizontalGlue());
		pulsante2.add(continua);
		pulsante2.add(Box.createHorizontalGlue());

		contieniPulsanti.add(pulsante2);
		contieniPulsanti.add(Box.createVerticalGlue());

		pulsante3.add(Box.createHorizontalGlue());
		pulsante3.add(esci);
		pulsante3.add(Box.createHorizontalGlue());

		contieniPulsanti.add(pulsante3);
		contieniPulsanti.add(Box.createVerticalGlue());

		finestra.add(contieniPulsanti,BorderLayout.CENTER);
		finestra.setVisible(true);
		finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

private class clicNuovaPartita implements ActionListener{
	public void actionPerformed(ActionEvent e){
			finestra.setVisible(false);
			finestra.dispose();
			JFrame finestraGioco = new JFrame("Adventure");
			finestraGioco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			PannelloGioco pG = new PannelloGioco();
			finestraGioco.add(pG);
			finestraGioco.pack();
			finestraGioco.setResizable(false);
			finestraGioco.setVisible(true);
			finestraGioco.setLocationRelativeTo(null);
			pG.startThread();
		}
	}

private class clicContinua implements ActionListener{
	public void actionPerformed(ActionEvent e){
			finestra.setVisible(false);
			finestra.dispose();
			JFrame finestraGioco = new JFrame("Adventure");
			finestraGioco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			PannelloGioco pG = new PannelloGioco();
			finestraGioco.add(pG);
			finestraGioco.pack();
			finestraGioco.setResizable(false);
			finestraGioco.setVisible(true);
			finestraGioco.setLocationRelativeTo(null);
			pG.startThread();
		}
	}

private class clicEsci implements ActionListener{
	public void actionPerformed(ActionEvent e){
		System.out.println("pulsanteeeeeeeeeeeeeeee");
		}
	}
}

/**	Layout desiderato
 * 	________________________________
 *	|	titolo del gioco	|
 *	|_______________________________|
 *	|				|
 *	|	    pulsante 1		|
 *	|				|
 *	|	    pulsante 2		|
 *	|				|
 *	|	    pulsante 3		|
 *	|				|
 *	---------------------------------
 *	BorderLayout:
 *	- lato alto per il titolo;
 *	- centro con BoxLayout:
 *		- pulsasnte 1;
 *		- pulsante 2;
 *		- pulsante 3;
 *			-tutti e tre centrati
 *				rispetto alla bisettrice
 *				verticale della finestra;
 */
