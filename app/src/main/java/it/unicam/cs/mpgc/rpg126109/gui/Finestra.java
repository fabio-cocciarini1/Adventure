package it.unicam.cs.mpgc.rpg126109.gui;

import java.awt.*;
import javax.swing.*;

public class Finestra extends JFrame{

	Container contenutoPane = null;

	public Finestra(String nomeFinestra){
		//dimensioni schermo utente
		Dimension dimensioneShermo = Toolkit.getDefaultToolkit().getScreenSize();
		int larghezzaSchermo = dimensioneShermo.width;
		int altezzaSchermo = dimensioneShermo.height;

		//controllo valori di inizializzazione
		if(nomeFinestra == null )
		{throw new IllegalArgumentException("Valori di inizializzazione della finestra non validi");}

	}
}
