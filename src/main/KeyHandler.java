package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

  // variabili boolean per l'associazione dei tasti
  public boolean upPressed, downPressed, leftPressed, rightPressed;

  // Metodi keyEvent sovrascritto con strutture condizionali e variabili booleane
  @Override
  public void keyTyped(KeyEvent e) {

  }

  // Metodo keyPressed sovrascritto
  @Override
  public void keyPressed(KeyEvent e) {
    // Questo metodo fà il return della key che è stata premuta e la associa alla variabile code
    int code = e.getKeyCode();
    // Associa alle variabili boolean la condizione true se viene premuto il tasto associato
    // Sopra
    if (code == KeyEvent.VK_W) {
      upPressed = true;
    }
    // Sotto
    if (code == KeyEvent.VK_S) {
      downPressed = true;
    }
    // Sinistra
    if (code == KeyEvent.VK_A) {
      leftPressed = true;
    }
    // Destra
    if (code == KeyEvent.VK_D) {
      rightPressed = true;
    }

  }

  // Metodo keyReleased sovrascritto
  @Override
  public void keyReleased(KeyEvent e) {
    // Setta i valori a false se la key viene rilasciata
    int code = e.getKeyCode();
    // Sopra
    if (code == KeyEvent.VK_W) {
      upPressed = false;
    }
    // Sotto
    if (code == KeyEvent.VK_S) {
      downPressed = false;
    }
    // Sinistra
    if (code == KeyEvent.VK_A) {
      leftPressed = false;
    }
    // Destra
    if (code == KeyEvent.VK_D) {
      rightPressed = false;
    }
  }

}
