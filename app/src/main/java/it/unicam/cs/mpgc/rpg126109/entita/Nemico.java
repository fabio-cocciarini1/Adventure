package it.unicam.cs.mpgc.rpg126109.entita;

import it.unicam.cs.mpgc.rpg126109.gui.PannelloGioco;
import it.unicam.cs.mpgc.rpg126109.entita.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Nemico extends Entita{
	
	ArrayList<Entita> entitaSullaMappa;
	Giocatore giocatore;

	public Nemico(PannelloGioco pG,int posizioneGlobaleX,int posizioneGlobaleY,Giocatore giocatore){
		super(pG);
		this.posizioneGlobaleX = posizioneGlobaleX;
		this.posizioneGlobaleY = posizioneGlobaleY;
		this.giocatore = giocatore;
		valoriDefault();
		getSprite();
	}
	private int getXGiocatore(){
		return giocatore.posizioneGlobaleX;
	}
	private int getYGiocatore(){
		return giocatore.posizioneGlobaleY;
	}
	public void muovi(){
		if(Math.abs(posizioneGlobaleX - getXGiocatore()) > 1 * pG.dimensioneSprite ||
			Math.abs(posizioneGlobaleY - getYGiocatore()) > 1 * pG.dimensioneSprite){
				
				if(posizioneGlobaleX < getXGiocatore()){posizioneGlobaleX += velocita;}
				else{posizioneGlobaleX -= velocita;}

				if(posizioneGlobaleY < getYGiocatore()){posizioneGlobaleY += velocita;}
				else{posizioneGlobaleY -= velocita;}
			}
	}

	public void valoriDefault(){
		velocita = 1;
		direzione = "su";
	}

	public void update(){
		muovi();
	}

	public void getSprite(){
		try{
			su1 = ImageIO.read(getClass().getResourceAsStream("/nemico/goblin.png"));
			su2 = ImageIO.read(getClass().getResourceAsStream("/nemico/goblin.png"));
			giu1 = ImageIO.read(getClass().getResourceAsStream("/nemico/goblin.png"));
			giu2 = ImageIO.read(getClass().getResourceAsStream("/nemico/goblin.png"));
			sinistra1 = ImageIO.read(getClass().getResourceAsStream("/nemico/goblin.png"));
			sinistra2 = ImageIO.read(getClass().getResourceAsStream("/nemico/goblin.png"));
			destra1 = ImageIO.read(getClass().getResourceAsStream("/nemico/goblin.png"));
			destra2 = ImageIO.read(getClass().getResourceAsStream("/nemico/goblin.png"));
		}catch(IOException e){e.printStackTrace();}
	}

	public void draw(Graphics2D g2){
		if(visibile()){
			g2.drawImage(su1,posizioneGlobaleX,posizioneGlobaleY,pG.dimensioneSprite,pG.dimensioneSprite,null);
		}
	}
	/*public int xRelativaAGiocatore(){
		if(posizioneGlobaleX > giocatore.posizioneGlobaleX){
			return posizioneGlobaleX-giocatore.posizioneGlobaleX;
		}
		else{
			return posizioneGlobaleX+giocatore.posizioneGlobaleX;
		} 
	}
	public int yRelativaAGiocatore(){
		if(posizioneGlobaleY > giocatore.posizioneGlobaleY){
			return giocatore.posizioneSuSchermataY+(posizioneGlobaleY-giocatore.posizioneGlobaleY);
		}
		else{
			return giocatore.posizioneSuSchermataY-(posizioneGlobaleY-giocatore.posizioneGlobaleY);
		} 
	}*/
	public boolean visibile(){
		if(Math.abs(posizioneGlobaleX - getXGiocatore()) < pG.maxCol * pG.dimensioneSprite &&
			Math.abs(posizioneGlobaleY - getYGiocatore()) < pG.maxRighe * pG.dimensioneSprite){
			return true;
			}
		else{return false;}
	}

}
/**
 * getGiocatore()
 * è un metorìdo che ritorna l'entità Giocatore dall'arraylist di
 * entita passatagli dal GestoreEntita
 * - getXGiocatore()
 * - getYGiocatore()
 *   sono due metodi per avere le coordinate dell'entità Giocatore
 * --------------
 * muovi()
 * è un metodo responsabile per muovere l'entità Nemico nella direzione
 * dell'entitò Giocatore solo se il Nemico è più lontano di un blocco
 * in entrambe le direzioni
 * ------------
 * visibile()
 * è il metodo responsable per determinare che l'entità nemico
 * sia visibile nello schermata
 */
