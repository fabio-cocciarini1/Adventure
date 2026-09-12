package it.unicam.cs.mpgc.rpg126109;

import it.unicam.cs.mpgc.rpg126109.gui.PannelloGioco;
import it.unicam.cs.mpgc.rpg126109.entita.*;

import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.io.IOException;

public class ControlloCollisioni{
	
	PannelloGioco pG;
	//GestoreEntita gE;
	//Giocatore giocatore;

	public ControlloCollisioni(PannelloGioco pG){
		this.pG = pG;
		//this.gE = gE;
		//getGiocatore();
	}
	/*
	public void getGiocatore(){
		for(int i=0;i<gE.entitaSullaMappa.size();i++){
			if(gE.entitaSullaMappa.get(i) instanceof Giocatore){
				giocatore = (Giocatore) gE.entitaSullaMappa.get(i);
			}
		}
	}*/


	/** Per le collisioni ho bisogno delle coordinate dei quattro lati
	 * di una entità, per poterne ottenere i quattro lati,
	 * da poi controllare per eventuali collisioni
	 */

	/**coordinate relative alla mappa dell'area solita
	 * dell'entita in fase di controllo
	 *
	 *
	 * entitaLatoSinistroX/		entitaLatoDestroX/
	 * entitaColonnaSinistra	entitaColonnaDestra
	 *	|				|
	 *	|	entitaLatoAltoY/	|
	 *	|	entitaRigaSopra		|
	 *	|		    |		|
	 *	|		    V		|
	 *      |		 _______	|
	 *	|	      	|	|	|
	 *	|------------>	|	| <-----|
	 *			|_______|
	 *
	 *			    A
	 *			    |
	 *		entitaLatoBassoY/
	 *		entitaRigaSotto
	 *
	 */

	public void controlloSprite(Entita entita){

		//coordinate relative ai 4 lati dell'areaSolida da controllare
		int entitaLatoSinistroX = entita.posizioneGlobaleX + entita.areaSolida.x;
		int entitaLatoDestroX = entita.posizioneGlobaleX + entita.areaSolida.x + entita.areaSolida.width;
		int entitaLatoAltoY = entita.posizioneGlobaleY + entita.areaSolida.y;
		int entitaLatoBassoY = entita.posizioneGlobaleY + entita.areaSolida.y + entita.areaSolida.height;

		//colonna o riga corrispondente alle coordinate del lato
		int entitaColonnaSinistra = entitaLatoSinistroX / pG.dimensioneSprite;
		int entitaColonnaDestra = entitaLatoDestroX / pG.dimensioneSprite;
		int entitaRigaSopra = entitaLatoAltoY / pG.dimensioneSprite;
		int entitaRigaSotto = entitaLatoBassoY / pG.dimensioneSprite;

		int numIdTile1,numIdTile2;

		switch(entita.direzione){
			case "su" :
				entitaRigaSopra = (entitaLatoAltoY - entita.velocita) / pG.dimensioneSprite;
				numIdTile1 = pG.gTile.mappaNumeroTile[entitaColonnaSinistra][entitaRigaSopra];
				numIdTile2 = pG.gTile.mappaNumeroTile[entitaColonnaDestra][entitaRigaSopra];
				if(pG.gTile.tile[numIdTile1].collisioni == true ||
						pG.gTile.tile[numIdTile2].collisioni == true){
					entita.collisioni = true;
						}
				break;
			case "giu" :
				entitaRigaSotto = (entitaLatoBassoY + entita.velocita) / pG.dimensioneSprite;
				numIdTile1 = pG.gTile.mappaNumeroTile[entitaColonnaSinistra][entitaRigaSotto];
				numIdTile2 = pG.gTile.mappaNumeroTile[entitaColonnaDestra][entitaRigaSotto];
				if(pG.gTile.tile[numIdTile1].collisioni == true ||
						pG.gTile.tile[numIdTile2].collisioni == true){
					entita.collisioni = true;
						}
				break;
			case "sinistra" :
				entitaColonnaSinistra = (entitaLatoSinistroX - entita.velocita) / pG.dimensioneSprite;
				numIdTile1 = pG.gTile.mappaNumeroTile[entitaColonnaSinistra][entitaRigaSopra];
				numIdTile2 = pG.gTile.mappaNumeroTile[entitaColonnaSinistra][entitaRigaSotto];
				if(pG.gTile.tile[numIdTile1].collisioni == true ||
						pG.gTile.tile[numIdTile2].collisioni == true){
					entita.collisioni = true;
						}
				break;
			case "destra":
				entitaColonnaDestra = (entitaLatoDestroX + entita.velocita) / pG.dimensioneSprite;
				numIdTile1 = pG.gTile.mappaNumeroTile[entitaColonnaDestra][entitaRigaSopra];
				numIdTile2 = pG.gTile.mappaNumeroTile[entitaColonnaDestra][entitaRigaSotto];
				if(pG.gTile.tile[numIdTile1].collisioni == true ||
						pG.gTile.tile[numIdTile2].collisioni == true){
					entita.collisioni = true;
						}
				break;
		}
	}
}
