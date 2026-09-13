package it.unicam.cs.mpgc.rpg126109;

import it.unicam.cs.mpgc.rpg126109.gui.FinestraGioco;
import it.unicam.cs.mpgc.rpg126109.gui.*;
import it.unicam.cs.mpgc.rpg126109.gui.FinestraMenu;


import java.awt.*;
import javax.swing.*;

public class Main{

	public static void main(String[] args){
		
		FinestraMenu finestraProva = new FinestraMenu("Adventure");

		finestraProva.setLocationRelativeTo(null);
		finestraProva.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		finestraProva.pack();
		/*
		JFrame finestra = new JFrame();
		//finestra.getContentPane.setLayout(new BorderLayout());
		finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		finestra.setTitle("Adventure");

		PannelloGioco pG = new PannelloGioco();

		finestra.add(pG);

		finestra.pack();
		finestra.setResizable(false);
		finestra.setVisible(true);
		finestra.setLocationRelativeTo(null);

		pG.startThread();*/
		
		
		//FinestraMenu finestraProva1 = new FinestraMenu("Finestra inizializzata dalla funzione main",1000,100,800,200);
	}

}
