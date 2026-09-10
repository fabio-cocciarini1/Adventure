package it.unicam.cs.mpgc.rpg126109.entity;

import java.awt.image.BufferedImage;
import java.awt.Rectangle;

public class Entita{

	//statistiche dell'entità
	//int vita,difesa,attacco,velocita;
	//posizione nella mappa
	public int posizioneGlobaleX,posizioneGlobaleY;
	public int velocita;

	public BufferedImage su1,su2,giu1,giu2,sinistra1,sinistra2,destra1,destra2;

	public int contatoreSprite = 0;
	public int numSprite = 1;

	public String direzione;
	public Rectangle areaSolida;
	public boolean collisioni = false;

	/*
	public Entita(int vita, int difesa, int attacco, int velocita){
		if(vita < 1 || difesa < 0 || attacco < 0 || velocita <0){
			throw new IllegalArgumentException("Valore d'inizializzazione Entita non valido");
		}
		this.vita = vita;
		this.difesa = difesa;
		this.attacco = attacco;
		this.velocita = velocita;
		this.posizioneGlobaleX = 1;
		this.posizioneGlobaleY = 2;
	}
	*/


	/**Da implementare sistema di movimento,
	 * sistema gestione sprite
	 *	 ______________________________________________
	 *	 !!! RIMUOVERE NUMERI MAGICI DA COSTRUTTORE !!!
	 *	 ----------------------------------------------
	 */

	

}
