package it.unicam.cs.mpgc.rpg126109.userInput;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class UserInput implements KeyListener{
	
	public boolean su, giu, sinistra, destra;

	@Override
	public void keyTyped(KeyEvent e){}

	@Override
	public void keyPressed(KeyEvent e){
		int codice = e.getKeyCode();

		if(codice == KeyEvent.VK_W){
			su = true;
		}
		if(codice == KeyEvent.VK_S){
			giu = true;
		}
		if(codice == KeyEvent.VK_A){
			sinistra = true;
		}
		if(codice == KeyEvent.VK_D){
			destra = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e){
		
		int codice = e.getKeyCode();

		if(codice == KeyEvent.VK_W){
			su = false;
		}
		if(codice == KeyEvent.VK_S){
			giu = false;
		}
		if(codice == KeyEvent.VK_A){
			sinistra = false;
		}
		if(codice == KeyEvent.VK_D){
			destra = false;
		}
	}


}
