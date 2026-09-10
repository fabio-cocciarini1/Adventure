package it.unicam.cs.mpgc.rpg126109.tile;

import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;


import it.unicam.cs.mpgc.rpg126109.gui.PannelloGioco;

public class GestoreTile extends Tile{
	
	PannelloGioco pG;
	public Tile[] tile;
	public int mappaNumeroTile[][]; //array bidimensionale [x][y] con una specifica tile in ogni posizione

	public GestoreTile(PannelloGioco pG){
		this.pG = pG;
		tile = new Tile[10];
		mappaNumeroTile = new int[pG.maxMappaCol][pG.maxMappaRighe];

		getImmagineTile();
		caricaMappa("/mappe/mappa.txt");
	}

	public void getImmagineTile(){
		try{
			tile[0] = new Tile();
			tile[0].immagineTile = getImmagine("/tile/acqua.png");
			tile[0].collisioni = true;

			tile[1] = new Tile();
			tile[1].immagineTile = getImmagine("/tile/albero.png");
			tile[1].collisioni = true;

			tile[2] = new Tile();
			tile[2].immagineTile = getImmagine("/tile/erba.png");

			tile[3] = new Tile();
			tile[3].immagineTile = getImmagine("/tile/muro.png");
			tile[3].collisioni = true;

			tile[4] = new Tile();
			tile[4].immagineTile = getImmagine("/tile/sabbia.png");

			tile[5] = new Tile();
			tile[5].immagineTile = getImmagine("/tile/terra.png");

		}catch(IOException e){e.printStackTrace();}
	}

	public BufferedImage getImmagine(String percorsoFile) throws IOException{
		return ImageIO.read(getClass().getResourceAsStream(percorsoFile));
	}

	public void caricaMappa(String percorsoFile){
		try{
			InputStream is = getClass().getResourceAsStream(percorsoFile);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			int colonna = 0;
			int riga = 0;

			while(colonna < pG.maxMappaCol && riga < pG.maxMappaRighe){
				String rigaLetta = br.readLine();
				while(colonna < pG.maxMappaCol){
					String numeri[] = rigaLetta.split(" ");
					int num = Integer.parseInt(numeri[colonna]);

					mappaNumeroTile[colonna][riga] = num;
					colonna++;
				}
				if(colonna == pG.maxMappaCol){colonna = 0; riga++;}
			}
			br.close();
		}catch(IOException e){e.printStackTrace();}
	}
	public void draw(Graphics2D g2){
		int colonnaMondo = 0;
		int rigaMondo = 0;

		while(colonnaMondo < pG.maxMappaCol && rigaMondo < pG.maxMappaRighe){
			// numero identificativo della sprite nelle coordinate selezionate
			int numIdTile = mappaNumeroTile[colonnaMondo][rigaMondo];

			//coordinate del mondo
			int xMondo = colonnaMondo * pG.dimensioneSprite;
			int yMondo = rigaMondo * pG.dimensioneSprite;
			//coordinate del giocatore (nella schermata?)
			int xSchermo = xMondo - pG.g1.posizioneGlobaleX + pG.g1.posizioneSuSchermataX;
			int ySchermo = yMondo - pG.g1.posizioneGlobaleY + pG.g1.posizioneSuSchermataY;
			
			if(xMondo + pG.dimensioneSprite > pG.g1.posizioneGlobaleX - pG.g1.posizioneSuSchermataX ||
					xMondo + pG.dimensioneSprite < pG.g1.posizioneSuSchermataX + pG.g1.posizioneSuSchermataX ||
					yMondo - pG.dimensioneSprite > pG.g1.posizioneGlobaleY - pG.g1.posizioneSuSchermataY ||
					yMondo + pG.dimensioneSprite < pG.g1.posizioneGlobaleY + pG.g1.posizioneSuSchermataY){
						g2.drawImage(tile[numIdTile].immagineTile,xSchermo,ySchermo,pG.dimensioneSprite,pG.dimensioneSprite,null);
					}

			colonnaMondo++;

			if(colonnaMondo == pG.maxMappaCol){
				colonnaMondo = 0;
				rigaMondo++;
			}

		}
	}
}
