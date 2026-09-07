package it.unicam.cs.mpgc.rpg126109.gui;

import java.awt.*;
import javax.swing.*;

public class Finestra extends JFrame{

	Container contenutoPane = null;

	public Finestra(int larghezza,int altezza){
		JFrame finestra = new JFrame("Finestra");
		finestra.setBounds(500, 500, larghezza, altezza);
		contenutoPane = finestra.getContentPane();
		
		//componenti
		JLabel vita = new JLabel("vita : 100%");
		JLabel difesa = new JLabel("difesa = 0");
		JLabel attacco = new JLabel("attacco =  1");

		JButton salva = new JButton("Salva");
		
		JPanel barraSuperiore = new JPanel(new FlowLayout());

		barraSuperiore.add(salva);
		barraSuperiore.add(vita);
		barraSuperiore.add(difesa);
		barraSuperiore.add(attacco);

		

		finestra.add(barraSuperiore, BorderLayout.NORTH);

		finestra.setVisible(true);
		finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
