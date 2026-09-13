package it.unicam.cs.mpgc.rpg126109.tile;

import java.awt.image.BufferedImage;
import java.awt.*;
import java.util.ArrayList;
import java.io.*;
import javax.imageio.ImageIO;


import it.unicam.cs.mpgc.rpg126109.gui.PannelloGioco;
import it.unicam.cs.mpgc.rpg126109.entita.GestoreEntita;
import it.unicam.cs.mpgc.rpg126109.entita.Giocatore;

public class GestoreTile extends Tile{
	
	PannelloGioco pG;
	public Tile[] tile;
	public int mappaNumeroTile[][]; //array bidimensionale [x][y] con una specifica tile in ogni posizione
	Giocatore giocatore;

	public GestoreTile(PannelloGioco pG,Giocatore giocatore){
		this.pG = pG;
		this.giocatore = giocatore;
		tile = new Tile[10];
		mappaNumeroTile = new int[pG.maxMappaCol][pG.maxMappaRighe];

		getImmagineTile();
		caricaMappa("/mappe/mappaGiusta.txt");
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
			int xMondo = colonnaMondo * pG.dimensioneSprite;
			int yMondo = rigaMondo * pG.dimensioneSprite;
			
			g2.drawImage(tile[numIdTile].immagineTile,xMondo,yMondo,pG.dimensioneSprite,pG.dimensioneSprite,null);
			
			colonnaMondo++;

			if(colonnaMondo == pG.maxMappaCol){
				colonnaMondo = 0;
				rigaMondo++;
			}
		}
	}
}
/**
 * getImmagineTile()
 * è responsabile per reperire la sprite dei blocchi dello sfondo e
 * li inizializza in un array monodimensionale di tipo Tile
 * specificando anche se è una sprite che ha COLLISIONI o meno
 * -------------------
 * BufferedImage getImmagine(String percorsoFile) throws IOException
 * è un metodo responsabile per reperire la sprite dalla locazione in memoria
 * specificata dalla String passatagli
 * è stato implementato per rendere meno ripetitivo il processo di recupero immagini dalla memoria
 * e di assegnamento di esse alle relative Tile() e per renderlo più facilmente leggibile
 * NON gestisce le eventuali eccezioni, le passa al metodo che lo chiama
 * -------------------
 * caricaMappa(String percorsoFile)
 * è il metodo responsabile per leggere e caricare in memoria la mappa
 * selezionata
 * -------------------
 * draw(Graphics2D g2)
 * è il metodo responsabile per disegnare a schermo la parte di mappa visibile
 * a schermo
 * per fare ciò si avvale delle coordinate dell'entita Giocatore per
 * mostrare ciò che si trova intorno al Giocatore
 * --------------------
 * getGiocatore()
 * è responsabile per ottenere il riferimento all'entità giocatore
 * in modo da poterne ricavare dati di conseguenza
 */
