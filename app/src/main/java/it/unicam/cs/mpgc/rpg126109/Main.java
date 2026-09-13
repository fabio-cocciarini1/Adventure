package it.unicam.cs.mpgc.rpg126109;

import it.unicam.cs.mpgc.rpg126109.gui.FinestraMenu;


import java.awt.*;
import javax.swing.*;

public class Main{

	public static void main(String[] args){
		
		FinestraMenu finestraProva = new FinestraMenu("Adventure");

		finestraProva.setLocationRelativeTo(null);
		finestraProva.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		finestraProva.pack();
	}

}
