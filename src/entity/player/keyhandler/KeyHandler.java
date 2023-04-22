package entity.player.keyhandler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

  // variabili boolean per l'associazione dei tasti
  private boolean upPressed;
  private boolean downPressed;
  private boolean leftPressed;
  private boolean rightPressed;

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
    switch (code) {
      case KeyEvent.VK_W -> upPressed = true;
      case KeyEvent.VK_S -> downPressed = true;
      case KeyEvent.VK_A -> leftPressed = true;
      case KeyEvent.VK_D -> rightPressed = true;
      default -> System.out.println("Tasto non gestito!");
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

  public boolean isUpPressed() {
    return upPressed;
  }

  public void setUpPressed(boolean upPressed) {
    this.upPressed = upPressed;
  }

  public boolean isDownPressed() {
    return downPressed;
  }

  public void setDownPressed(boolean downPressed) {
    this.downPressed = downPressed;
  }

  public boolean isLeftPressed() {
    return leftPressed;
  }

  public void setLeftPressed(boolean leftPressed) {
    this.leftPressed = leftPressed;
  }

  public boolean isRightPressed() {
    return rightPressed;
  }

  public void setRightPressed(boolean rightPressed) {
    this.rightPressed = rightPressed;
  }
}
