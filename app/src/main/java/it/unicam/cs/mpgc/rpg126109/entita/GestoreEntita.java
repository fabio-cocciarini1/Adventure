package it.unicam.cs.mpgc.rpg126109.entita;
import it.unicam.cs.mpgc.rpg126109.entita.*;
import it.unicam.cs.mpgc.rpg126109.gui.PannelloGioco;
import it.unicam.cs.mpgc.rpg126109.userInput.UserInput;
import it.unicam.cs.mpgc.rpg126109.ControlloCollisioni;

import java.util.ArrayList;
import java.awt.*;

/**Classe responsabile per la gestione delle entita nella mappa;
 * gestisce la creazione di nemici, il loro movimento e la loro morte.
 */
public class GestoreEntita extends Entita{
	UserInput uIn;
	ControlloCollisioni collisioniCheck;
	Giocatore giocatore;
	public ArrayList<Entita> entitaSullaMappa;

	public GestoreEntita(PannelloGioco pG, UserInput uIn){
		super(pG);
		this.uIn = uIn;
		this.entitaSullaMappa = new ArrayList<Entita>();
		giocatore = new Giocatore(pG,uIn,this);
		entitaSullaMappa.add(giocatore);
		collisioniCheck = new ControlloCollisioni(pG);
	}

	public void update(){
		for(int i=0;i<entitaSullaMappa.size();i++){
			entitaSullaMappa.get(i).update();
		}
		
		minNemici(10);
		

	}
	

	public void minNemici(int minNemici){
		int numNemici = 0;
		int coordinataCasuale = 0;
		for(int i=0;i<entitaSullaMappa.size();i++){
			if(entitaSullaMappa.get(i) instanceof Nemico){numNemici++;}
		}
		while(numNemici < minNemici){
			coordinataCasuale = pG.dimensioneSprite * numeroACasoTra(2,46);
			entitaSullaMappa.add(new Nemico(pG,coordinataCasuale,coordinataCasuale,giocatore));
			numNemici++;
		}
	}
	//per generare un numero casuale in un range di valori
	private int numeroACasoTra(int min, int max){
		int differenza = max - min;
		return (int)(Math.random() * (differenza + 1));
	}

	public void draw(Graphics2D g2){
		for(int i=0;i<entitaSullaMappa.size();i++){
			Entita n = entitaSullaMappa.get(i);
			System.out.println("coordinate del nemico "+i+" x:"+n.posizioneGlobaleX+" y: "+n.posizioneGlobaleY);
			entitaSullaMappa.get(i).draw(g2);
		}
	}
	public Giocatore getGiocatore(){
		return giocatore;
	}




}
