package entity;

import java.awt.image.BufferedImage;

// Classe padre per tutte le entità del gioco (npc,mostri,personaggio,etc.)
public class Entity {

  // queste variabili saranno presenti in tutte le entità del gioco che si muovono (mostri,npc etc)
  // saranno ereditate da tutte le classi che fanno parte della superclasse Entity
  // Variabile int per le coordinate sullo schermo
  private int y;
  private int x;
  // Variabile per la velocità
  private int speed;
  // BufferedImage descrive un immagine accessibile tramite una source
  private BufferedImage up1;
  private BufferedImage up2;
  private BufferedImage down1;
  private BufferedImage down2;
  private BufferedImage left1;
  private BufferedImage left2;
  private BufferedImage right1;
  private BufferedImage right2;
  // Variabile stringa direction su cui faremo lo switch case delle stringhe
  // "up" "down" etc. per gestire le variabili BufferedImagee aggiornare le animazioni su schermo
  private Direction direction;
  // variabili int contatori degli sprite per cambiare le animazioni
  private int spriteCounter = 0;
  private int spriteNum = 1;

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getSpeed() {
    return speed;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public BufferedImage getUp1() {
    return up1;
  }

  public void setUp1(BufferedImage up1) {
    this.up1 = up1;
  }

  public BufferedImage getUp2() {
    return up2;
  }

  public void setUp2(BufferedImage up2) {
    this.up2 = up2;
  }

  public BufferedImage getDown1() {
    return down1;
  }

  public void setDown1(BufferedImage down1) {
    this.down1 = down1;
  }

  public BufferedImage getDown2() {
    return down2;
  }

  public void setDown2(BufferedImage down2) {
    this.down2 = down2;
  }

  public BufferedImage getLeft1() {
    return left1;
  }

  public void setLeft1(BufferedImage left1) {
    this.left1 = left1;
  }

  public BufferedImage getLeft2() {
    return left2;
  }

  public void setLeft2(BufferedImage left2) {
    this.left2 = left2;
  }

  public BufferedImage getRight1() {
    return right1;
  }

  public void setRight1(BufferedImage right1) {
    this.right1 = right1;
  }

  public BufferedImage getRight2() {
    return right2;
  }

  public void setRight2(BufferedImage right2) {
    this.right2 = right2;
  }

  public Direction getDirection() {
    return direction;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }

  public int getSpriteCounter() {
    return spriteCounter;
  }

  public void setSpriteCounter(int spriteCounter) {
    this.spriteCounter = spriteCounter;
  }

  public int getSpriteNum() {
    return spriteNum;
  }

  public void setSpriteNum(int spriteNum) {
    this.spriteNum = spriteNum;
  }
}