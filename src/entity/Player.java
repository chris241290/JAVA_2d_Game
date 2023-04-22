package entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.KeyHandler;

// classe Player (sottoclasse di Entity) che è la classe che definisce il nostro player (giocatore)
public class Player extends Entity {

  private int tileSize;
  private KeyHandler keyH;

  // Metodo costruttore di Player (argomenti : un oggetto di tipo GamePanel e uno di tipo KeyHandler,
  public Player(int tileSize, KeyHandler keyH) {
    this.tileSize = tileSize;
    this.keyH = keyH;
    // chiamiamo il metoto setDefaultValues() all'interno di questo costruttore
    // per settare i valori di default
    setDefaultValues();
    getPlayerImage();
  }

  // Metodo che setta la posizione di default del Player
  public void setDefaultValues() {
    super.setY(100);
    super.setX(100);
    super.setSpeed(4);
    super.setDirection("down");
  }

  // Load delle immagini dalla source res/player sulle variabili delle direzioni
  public void getPlayerImage() {
    try {
      super.setUp1(ImageIO.read(getClass().getResourceAsStream("/player/up1.png")));
      super.setUp2(ImageIO.read(getClass().getResourceAsStream("/player/up2.png")));
      super.setDown1(ImageIO.read(getClass().getResourceAsStream("/player/down2.png")));
      super.setDown2(ImageIO.read(getClass().getResourceAsStream("/player/down1.png")));
      super.setLeft1(ImageIO.read(getClass().getResourceAsStream("/player/left1.png")));
      super.setLeft2(ImageIO.read(getClass().getResourceAsStream("/player/left2.png")));
      super.setRight1(ImageIO.read(getClass().getResourceAsStream("/player/right1.png")));
      super.setRight2(ImageIO.read(getClass().getResourceAsStream("/player/right2.png")));

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void update() {
    if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
      // Struttura condizionale che a seconda del tasto premuto updata la posizione del tiles del player
      // Sè la variabile upPressed(sopra) è settata a true (quindi è stato premuto il tasto associato a playerup(w nel nostro caso)
      // allora fa l'operazione playerY = playerY - playerSpeed
      if (keyH.upPressed == true) {
        System.out.println("Premuto tasto UP");
        // setta direction nella direzione corrispondente
        super.setDirection("up");
        // sottrae dalle coordinate Y la velocità impostata del player per farlo muovere
        super.setY(super.getY() - super.getSpeed());
      }
      // Fa l'opposto (addizione) per farlo andare giù
      else if (keyH.downPressed == true) {
        System.out.println("Premuto tasto DOWN");
        super.setDirection("down");
        super.setY(super.getY() + super.getSpeed());
      }
      // Fa le stesse operazioni sulla variabile PlayerX per muoversi a destra e sinistra
      else if (keyH.leftPressed == true) {
        System.out.println("Premuto tasto LEFT");
        super.setDirection("left");
        super.setX(super.getX() - super.getSpeed());
      } else if (keyH.rightPressed == true) {
        System.out.println("Premuto tasto RIGHT");
        super.setDirection("right");
        super.setX(super.getX() + super.getSpeed());
      }
      super.setSpriteCounter(super.getSpriteCounter() + 1);
      if (super.getSpriteCounter() > 10) {
        if (super.getSpriteNum() == 1) {
          super.setSpriteNum(2);
        } else if (super.getSpriteNum() == 2) {
          super.setSpriteNum(1);
        }
        super.setSpriteCounter(0);
      }
    }

  }

  public void draw(Graphics g2) {
    // Metodo che setta colore utilizzato per disegnare oggetti
    //g2.setColor(Color.white);
    // Metodo che disegna un rettangolo (tra parentesi le dimensioni) possiamo cambiarle tramite le variabili utilizzate
    // con l'update saranno aggiornate le variabili dell'argomento fillRect e con il redraw sarà ridisegnato tutto con le
    // coordinate aggiornate
    //g2.fillRect(x, y, gp.tileSize, gp.tileSize);
    BufferedImage image = null;
    switch (super.getDirection()) {
      // Switch case sulla variabile BufferedImage direction con i case stringa
      // daranno il valore (stringa/directory dell'immagine) alla variabile image
      // gli if sfruttano la variabile int come contatore per cambiare le animazioni
      case "up":
        if (super.getSpriteNum() == 1) {
          image = super.getUp1();
          System.out.println("Draw immagine Up1");
        }
        if (super.getSpriteNum() == 2) {
          image = super.getUp2();
          System.out.println("Draw immagine Up2");
        }
        break;

      case "down":
        if (super.getSpriteNum() == 1) {
          image = super.getDown1();
          System.out.println("Draw immagine Down1");
        }
        if (super.getSpriteNum() == 2) {
          image = super.getDown2();
          System.out.println("Draw immagine Down2");
        }
        break;

      case "left":
        if (super.getSpriteNum() == 1) {
          image = super.getLeft1();
          System.out.println("Draw immagine Left1");
        }
        if (super.getSpriteNum() == 2) {
          image = super.getLeft2();
          System.out.println("Draw immagine Left2");
        }
        break;

      case "right":
        if (super.getSpriteNum() == 1) {
          image = super.getRight1();
          System.out.println("Draw immagine Right1");
        }
        if (super.getSpriteNum() == 2) {
          image = super.getRight2();
          System.out.println("Draw immagine Right2");
        }

        break;
    }
    g2.drawImage(image, super.getX(), super.getY(), tileSize, tileSize, null);
  }
}
