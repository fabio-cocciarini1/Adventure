package it.unicam.cs.mpgc.rpg126109.entita;

import it.unicam.cs.mpgc.rpg126109.gui.PannelloGioco; 
import it.unicam.cs.mpgc.rpg126109.userInput.UserInput;

import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Giocatore extends Entita{

	UserInput uIn;
	GestoreEntita gE;

	//public int posizioneSuSchermataX, posizioneSuSchermataY;
	public int vita,danno;

	public Giocatore(PannelloGioco pG,UserInput uIn,GestoreEntita gE){
		super(pG);
		this.uIn = uIn;
		this.gE = gE;

		//posizioneSuSchermataX = (pG.larghezzaSchermo/2) - (pG.dimensioneSprite/2); // metà larghezza
		//posizioneSuSchermataY = (pG.altezzaSchermo/2) - (pG.dimensioneSprite/2); // metà altezza

		areaSolida = new Rectangle(5 * pG.scala, 7 * pG.scala, 6 * pG.scala, 8 * pG.scala);//area dove calcolare le collisioni

		setValoriDefault();//valori di default del personaggio
		getSpriteGiocatore();//sprite del personaggio
	}

	public void setValoriDefault(){
		posizioneGlobaleX = pG.dimensioneSprite * 2;//posizione relativa alla mappa
		posizioneGlobaleY = pG.dimensioneSprite * 2;//posizione relativa alla mappa
		velocita = 4;
		vita = 10;
		direzione = "giu";
	}

	//metodo per caricare in memoria le sprite del giocatore
	BufferedImage attaccoSu,attaccoGiu,attaccoSinistra,attaccoDestra;
	public void getSpriteGiocatore(){
		try{
			su1 = getSprite("/giocatore/su1.png");
			su2 = getSprite("/giocatore/su2.png");
			giu1 = getSprite("/giocatore/giu1.png");
			giu2 = getSprite("/giocatore/giu2.png");
			sinistra1 = getSprite("/giocatore/sinistra1.png");
			sinistra2 = getSprite("/giocatore/sinistra2.png");
			destra1 = getSprite("/giocatore/destra1.png");
			destra2 = getSprite("/giocatore/destra2.png");
			attaccoSu = getSprite("/giocatore/attacco/attaccoSu.png");
			attaccoGiu = getSprite("/giocatore/attacco/attaccoGiu.png");
			attaccoSinistra = getSprite("/giocatore/attacco/attaccoSinistra.png");
			attaccoDestra = getSprite("/giocatore/attacco/attaccoDestra.png");
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	
	private BufferedImage getSprite(String percorsoFile) throws IOException{
		return ImageIO.read(getClass().getResourceAsStream(percorsoFile));
	}
	

	public void update(){
		muovi();
		if(uIn.spazio == true){
			attacca();
		}
	}
	public void muovi(){
		//viene aggiornato lo stato del personaggio solo se una della quattro direzione è premuta
	if(uIn.su == true ||
		uIn.giu == true ||
		uIn.sinistra == true ||
		uIn.destra == true){
		
		if(uIn.su == true){direzione = "su";}
		else if (uIn.giu == true){direzione = "giu";}
		else if (uIn.sinistra == true){direzione = "sinistra";}
		else if (uIn.destra == true){direzione = "destra";}

		// controllo collisioni
		collisioni = false;
		gE.collisioniCheck.controlloSprite(this);

		if(collisioni == false){
			switch(direzione){
				case "su" :
					posizioneGlobaleY -= velocita;
					break;
				case "giu" :
					posizioneGlobaleY += velocita;
					break;
				case "sinistra" :
					posizioneGlobaleX -= velocita;
					break;
				case "destra" :
					posizioneGlobaleX += velocita;
					break;
			}
			contatoreSprite++;
			contatoreSprite = updateAnimazione(contatoreSprite);
		}
		
	}}
	// !! ATTENZIONE !! trovare modo meno contorto per aggiornare le sprite
	public int updateAnimazione(int contatoreSprite){
		if(contatoreSprite > 20){
			if(numSprite == 1){numSprite = 2;}
			else if(numSprite == 2){numSprite = 1;}
			return contatoreSprite = 0;
		}else{return contatoreSprite;}
	}
	public void attacca(){
		for(int i=0;i<gE.entitaSullaMappa.size();i++){
			if(gE.entitaSullaMappa.get(i) instanceof Nemico &&
					Math.abs(gE.entitaSullaMappa.get(i).posizioneGlobaleX-posizioneGlobaleX)<pG.dimensioneSprite &&
					Math.abs(gE.entitaSullaMappa.get(i).posizioneGlobaleY - posizioneGlobaleY)<pG.dimensioneSprite){
				gE.entitaSullaMappa.remove(i);
			}
		}
	}

	public void draw(Graphics2D g2){

		BufferedImage sprite = null;
		if(!uIn.spazio){
		switch(direzione){
			case "su":
				if(numSprite == 1){sprite = su1;}
				if(numSprite == 2){sprite = su2;}
				break;
			case "giu":
				if(numSprite == 1){sprite = giu1;}
				if(numSprite == 2){sprite = giu2;}
				break;
			case "sinistra":
				if(numSprite == 1){sprite = sinistra1;}
				if(numSprite == 2){sprite = sinistra2;}
				break;
			case "destra":
				if(numSprite == 1){sprite = destra1;}
				if(numSprite == 2){sprite = destra2;}
				break;
			case "spazio":
				sprite = attaccoGiu;
				break;
			}
		}else{
			switch(direzione){
				case "su":
					sprite = attaccoSu;
					break;
				case "giu":
					sprite = attaccoGiu;
					break;
				case "sinistra":
					sprite = attaccoSinistra;
					break;
				case "destra":
					sprite = attaccoDestra;
					break;
			}
		}
		//g2.drawImage(sprite, posizioneSuSchermataX, posizioneSuSchermataY, pG.dimensioneSprite, pG.dimensioneSprite, null);
		//g2.drawImage(sprite, posizioneSuSchermataX + pG.dimensioneSprite, posizioneSuSchermataY - pG.dimensioneSprite, pG.dimensioneSprite, pG.dimensioneSprite*3, null);
		g2.drawImage(sprite, posizioneGlobaleX, posizioneGlobaleY, pG.dimensioneSprite, pG.dimensioneSprite, null);
	}
}

/** posizioneSuSchermataX e posizioneSuSchermataY sono le coordinate che, rispettivamente,
 * hanno la metà della larghezza dello schermo, contando anche la metà della larghezza della sprite del giocatore,
 * e la metà dell'altezza dello schermo, contando l'altezza della sprite del giocatore
 * -------------------
 * update()
 * è il metodo responsabile per aggiornare tutte le informazioni dell'entità giocatore
 * -------------------
 * muovi()
 * è il metodo responsabile per il movimento dell'entità giocatore e ciò che ne comporta:
 * controllo collisioni e aggiornamento del ciclo delle sprite
 * -------------------
 * int updateAnimazione(int contatoreSprite)
 * è responsabile per l'aggiornamento del ciclo dell'animazione
 * viene chiamata da muovi() perchè l'animazione di movimento si deve aggiornare
 * solo quando si è in movimento
 * -------------------
 * draw(Graphics2D g2)
 * è il metodo responsabile per stampare a schermo l'entità giocatore e come cambia nel tempo
 * nel caso dell'entità giocatore, che è sempre inquadrata, non c'è bisogno di controllare
 * se è visibile
 * Grazie al metodo muovi() avviene il cambio di direzione e grazie al metodo updateAnimazione()
 * avviene il cambio di sprite per quella direzione
 */
