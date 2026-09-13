package it.unicam.cs.mpgc.rpg126109.entita;

import it.unicam.cs.mpgc.rpg126109.gui.PannelloGioco;

import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.Rectangle;

public abstract class Entita{

	//statistiche dell'entità
	//int vita,difesa,attacco,velocita;
	//posizione nella mappa
	public PannelloGioco pG;
	public int posizioneGlobaleX,posizioneGlobaleY;
	public int velocita,vita,danno;

	public BufferedImage su1,su2,giu1,giu2,sinistra1,sinistra2,destra1,destra2;

	public int contatoreSprite = 0;
	public int numSprite = 1;

	public String direzione;
	public Rectangle areaSolida;
	public boolean collisioni = false;

	public abstract void update();
	public abstract void draw(Graphics2D g2);

	
	public Entita(PannelloGioco pG){
		this.pG = pG;
		//if(vita < 1 || difesa < 0 || attacco < 0 || velocita <0){throw new IllegalArgumentException("Valore d'inizializzazione Entita non valido");}
	}
	


	/**Da implementare sistema di movimento,
	 * sistema gestione sprite
	 *	 ______________________________________________
	 *	 !!! RIMUOVERE NUMERI MAGICI DA COSTRUTTORE !!!
	 *	 ----------------------------------------------
	 */

	

}
