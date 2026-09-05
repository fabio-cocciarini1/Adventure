package it.unicam.cs.mpgc.rpg126109;

import java.awt.*;
import javax.swing.*;

public class Finestra extends JPanel{
	public int blocco = 16;
	public int scala = 3;
	public int larghezzaInBlocchi = 16;
	public int altezzaInBlocchi = 12;
	public int larghezzaSchermo = larghezzaInBlocchi * (blocco * scala);
	public int altezzaSchermo = altezzaInBlocchi * (blocco * scala);

	public Finestra(){
		this.setPreferredSize(new Dimension(larghezzaSchermo, altezzaSchermo));
		this.setBackground(Color.BLACK);
		this.setFocusable(true);
	}
}
