package it.unicam.cs.mpgc.rpg126109;

import java.awt.*;
import javax.swing.JFrame;

public class Main{
	public static void main(String[] args){
		//inizializzazione del jframe
		JFrame finestra = new JFrame();
		finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		finestra.setResizable(false);
		finestra.setTitle("Adventure");
		
		//inizializzazione contenuto finestra
		Finestra f = new Finestra();

		finestra.add(f);
		//finestra.setLocationRelativeTo();

		finestra.pack();
		finestra.setVisible(true);
	}

}
