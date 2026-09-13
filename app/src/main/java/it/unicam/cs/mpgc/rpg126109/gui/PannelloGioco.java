package it.unicam.cs.mpgc.rpg126109.gui;

import it.unicam.cs.mpgc.rpg126109.userInput.UserInput;
import it.unicam.cs.mpgc.rpg126109.entita.*;
import it.unicam.cs.mpgc.rpg126109.tile.GestoreTile;
import it.unicam.cs.mpgc.rpg126109.ControlloCollisioni;


import java.awt.*;
import javax.swing.*;

// TOGLIERE I COMMENTI SUPERFLUI

public class PannelloGioco extends JPanel implements Runnable{

	int dimensioneOriginaleSprite = 16;//dimensione sprite e schermo in sprite
	public int scala = 3;
	public int dimensioneSprite = dimensioneOriginaleSprite * scala;
	public int maxCol = 30;
	public int maxRighe = 20;
	public int larghezzaSchermo = maxCol * dimensioneSprite;//larghezza schermo in pixel(tile * tileInPixel)
	public int altezzaSchermo = maxRighe * dimensioneSprite;//altezza schermo in pixel(tile * tileInPixel)


	//dimensioni mappa
	public int maxMappaCol = 30;//numero di colonne che ha la mappa
	public int maxMappaRighe = 20;//numero di righe che ha la mappa
	int larghezzaMappa = maxMappaCol * dimensioneSprite;//larghezza mappa in pixel
	int altezzaMappa = maxMappaRighe * dimensioneSprite;//altezza mappa in pixel
	

	//inizializzazione classi ausiliarie (?)
	public UserInput uIn = new UserInput();
	public GestoreEntita gE = new GestoreEntita(this,uIn);
	public GestoreTile gTile = new GestoreTile(this,gE.getGiocatore());
	public Thread threadDiGioco;


	// inizializzazione del JPanel
	public PannelloGioco(){
		this.setPreferredSize(new Dimension(larghezzaSchermo,altezzaSchermo));
		this.setDoubleBuffered(true);
		this.addKeyListener(uIn);
		this.setFocusable(true);
	}
	

	//metodo per far partire il thread
	public void startThread(){
		threadDiGioco = new Thread(this);
		threadDiGioco.start();
	}

	/**LOOP di gioco
	 *
	 * il delta è il tempo che si deve aspettare
	 * per ottenere il refresh rate desiderato
	 *
	 * il timer serve per controllare che il gioco
	 * effettivamente venga processato nella velocità richiesta
	 *
	 * variabile fps per scegliere il refresh rate del gioco
	 */
	
	int FPS = 60;

	@Override
	public void run(){
		double intervallo = 1000000000/FPS;
		double delta = 0;
		long ultimaMisura = System.nanoTime();
		long misuraAttuale;
		long timer = 0;
		int refreshRate = 0;

		while(threadDiGioco != null){
			misuraAttuale = System.nanoTime();
			delta += (misuraAttuale - ultimaMisura) / intervallo;
			timer += (misuraAttuale - ultimaMisura);
			ultimaMisura = misuraAttuale;
			
			if(delta >= 1){
				update();
				repaint();
				delta--;
				refreshRate++;
			}
			if(timer >= 1000000000){
				System.out.println("FPS : " + refreshRate);
				refreshRate = 0;
				timer = 0;
			}
		}
	}

	public void update(){
		gE.update();	
	}

	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		gTile.draw(g2);
		gE.draw(g2);
		g2.dispose();
	}

}

/**Il pannello di gioco è responsabile della visione del loop di gioco
 * 	
 * 	________________________________________
 * 	|					|
 * 	|Barra superiore con statistiche	|
 * 	________________________________________
 *	|	Pannello di gioco		|
 *	||-------------------------------------||
 *	||		loop		       ||
 *	||		di		       ||
 *	||		gioco		       ||
 *	||				       ||
 *	||				       ||
 *	|---------------------------------------|
 *	----------------------------------------
 */
