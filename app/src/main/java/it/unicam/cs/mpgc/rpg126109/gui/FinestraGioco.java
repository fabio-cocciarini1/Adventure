package it.unicam.cs.mpgc.rpg126109.gui;

import java.awt.*;
import javax.swing.*;

public class FinestraGioco extends Finestra{

	Container contenutoPane = null;

	public PannelloGioco pG;

	public FinestraGioco(String nomeFinestra){

		super(nomeFinestra);

		JFrame finestra = new JFrame(nomeFinestra);
		contenutoPane = finestra.getContentPane();
		
		//componenti
		JLabel vita = new JLabel("vita : 100%");
		JLabel difesa = new JLabel("difesa = 0");
		JLabel attacco = new JLabel("attacco =  1");

		JButton salva = new JButton("Salva");
		
		JPanel barraSuperiore = new JPanel(new FlowLayout());

		//inserimento dei componenti nella barra superiore della finestra di gioco
		barraSuperiore.add(salva);
		barraSuperiore.add(vita);
		barraSuperiore.add(difesa);
		barraSuperiore.add(attacco);

		finestra.add(barraSuperiore, BorderLayout.NORTH);

		//aggiungo il pannello di gioco alla finestra dalla classe PannelloGioco
		pG = new PannelloGioco(false);

		finestra.add(pG, BorderLayout.CENTER);
		
		finestra.setVisible(true);
		finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
