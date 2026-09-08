package it.unicam.cs.mpgc.rpg126109;

import it.unicam.cs.mpgc.rpg126109.gui.FinestraGioco;
import it.unicam.cs.mpgc.rpg126109.gui.*;
import it.unicam.cs.mpgc.rpg126109.gui.FinestraMenu;


import java.awt.*;
import javax.swing.*;

public class Main{

	public static void main(String[] args){
		//FinestraGioco finestraProva = new FinestraGioco("Finestra inizializzata dal metodo main",100,100,1000,800);
		
		JFrame finestra = new JFrame();
		//finestra.getContentPane.setLayout(new BorderLayout());
		finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		finestra.setTitle("Adventure");

		PannelloGioco pG = new PannelloGioco();
		JPanel barraSuperiore = new JPanel(new FlowLayout());

		finestra.add(pG);//, BorderLayout.CENTER);

		finestra.pack();
		finestra.setResizable(false);
		finestra.setVisible(true);
		finestra.setLocationRelativeTo(null);

		pG.startThread();
		
		
		//FinestraMenu finestraProva1 = new FinestraMenu("Finestra inizializzata dalla funzione main",1000,100,800,200);
	}

}
