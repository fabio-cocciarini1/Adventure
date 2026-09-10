package it.unicam.cs.mpgc.rpg126109.entity;

import it.unicam.cs.mpgc.rpg126109.gui.PannelloGioco; 
import it.unicam.cs.mpgc.rpg126109.userInput.UserInput;

import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Giocatore extends Entita{

	PannelloGioco pG;
	UserInput uIn;

	public int posizioneSuSchermataX, posizioneSuSchermataY;

	public Giocatore(PannelloGioco pG,UserInput uIn){
		this.pG = pG;
		this.uIn = uIn;

		posizioneSuSchermataX = (pG.larghezzaSchermo/2) - (pG.dimensioneSprite/2);//calcolo per ottenere la metà della lunghezza della schermata visibile, considerando anche la sprite
		posizioneSuSchermataY = (pG.altezzaSchermo/2) - (pG.dimensioneSprite/2);//calcolo per ottenere la metà dell'altezza della schermata visibile, considerando anche la sprite

		areaSolida = new Rectangle(5 * pG.scala, 7 * pG.scala, 6 * pG.scala, 8 * pG.scala);//are dove calcolare le collisioni

		setValoriDefault();//valori di default del personaggio
		getSpriteGiocatore();//sprite del personaggio
	}

	public void setValoriDefault(){
		posizioneGlobaleX = pG.dimensioneSprite * 25;//posizione relativa alla mappa
		posizioneGlobaleY = pG.dimensioneSprite * 25;//posizione relativa alla mappa
		velocita = 4;
		direzione = "giu";
	}

	//metodo per caricare in memoria le sprite del giocatore
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
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	
	private BufferedImage getSprite(String percorsoFile) throws IOException{
		return ImageIO.read(getClass().getResourceAsStream(percorsoFile));
	}
	

	public void update(){
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
			pG.collisioniCheck.controlloSprite(this);

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
			}
			contatoreSprite++;

			if(contatoreSprite > 20){
				if(numSprite == 1){numSprite = 2;}
				else if(numSprite == 2){numSprite = 1;}
				contatoreSprite = 0;
			}
		}
		
	}

	public void draw(Graphics2D g2){
		//g2.setColor(Color.GREEN);
		//g2.fillRect(posizioneGlobaleX,posizioneGlobaleY,pG.dimensioneSprite,pG.dimensioneSprite);

		BufferedImage sprite = null;

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
		}
		g2.drawImage(sprite, posizioneSuSchermataX, posizioneSuSchermataY, pG.dimensioneSprite, pG.dimensioneSprite, null);

	}

}
