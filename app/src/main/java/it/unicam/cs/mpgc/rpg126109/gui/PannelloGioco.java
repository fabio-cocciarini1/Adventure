package it.unicam.cs.mpgc.rpg126109.gui;

import it.unicam.cs.mpgc.rpg126109.gui.FinestraGioco;
import it.unicam.cs.mpgc.rpg126109.userInput.UserInput;
import it.unicam.cs.mpgc.rpg126109.entity.Giocatore;
import it.unicam.cs.mpgc.rpg126109.GameLoop;


import java.awt.*;
import javax.swing.*;

public class PannelloGioco extends JPanel implements Runnable{

	//dimensioni sprite e schermo in sprite
	int dimensioneOriginaleSprite = 16;
	int scala = 3;
	public int dimensioneSprite = dimensioneOriginaleSprite * scala;
	int maxCol = 16;
	int maxRighe = 12;
	public int larghezzaSchermo = maxCol * dimensioneSprite;
	public int altezzaSchermo = maxRighe * dimensioneSprite;

	//dimensioni mappa
	int maxMappaCol = 50;
	int maxMappaRighe = 50;
	int larghezzaMappa = maxMappaCol * dimensioneSprite;
	int altezzaMappa = maxMappaRighe * dimensioneSprite;
	
	//inizializzazione classi ausiliarie (?)
	UserInput uIn = new UserInput();
	Giocatore g1 = new Giocatore(this,uIn);
	Thread threadDiGioco;

	
	public PannelloGioco(){
		this.setPreferredSize(new Dimension(larghezzaSchermo,altezzaSchermo));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.addKeyListener(uIn);
		this.setFocusable(true);
	}

	public void startThread(){
		threadDiGioco = new Thread(this);
		threadDiGioco.start();
	}
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
	
	public void update(){}

	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.WHITE);
		g2.fillRect(100,100,dimensioneSprite,dimensioneSprite);
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
