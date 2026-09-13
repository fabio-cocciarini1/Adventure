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
		if(nomeFinestra == null /*||
			       	posizioneX < 0 || posizioneX > larghezzaSchermo - larghezza ||
				posizioneY < 0 || posizioneY > altezzaSchermo - altezza||
				larghezza < 0 || larghezza > larghezzaSchermo ||
				altezza < 0 || altezza > altezzaSchermo*/)
		{throw new IllegalArgumentException("Valori di inizializzazione della finestra non validi");}

	}
}
