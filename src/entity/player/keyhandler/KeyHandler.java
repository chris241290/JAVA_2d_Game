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
    // TODO document why this method is empty
  }

  // Metodo keyPressed sovrascritto
  @Override
  public void keyPressed(KeyEvent e) {
    // Questo metodo fà il return della key che è stata premuta e la associa alla variabile code
    handleButtons(e, true);
  }

  // Metodo keyReleased sovrascritto
  @Override
  public void keyReleased(KeyEvent e) {
    // Setta i valori a false se la key viene rilasciata
    handleButtons(e, false);
  }

  private void handleButtons(KeyEvent e, boolean pressed) {
    int code = e.getKeyCode();
    switch (code) {
      case KeyEvent.VK_W -> upPressed = pressed;
      case KeyEvent.VK_S -> downPressed = pressed;
      case KeyEvent.VK_A -> leftPressed = pressed;
      case KeyEvent.VK_D -> rightPressed = pressed;
      default -> System.out.println("Tasto non gestito!");
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
