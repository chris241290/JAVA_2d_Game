package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity { // classe Player (sottoclasse di Entity) che è la classe che definisce il nostro player (giocatore)
	// Metodo costruttore di Player (argomenti : un oggetto di tipo GamePanel e uno di tipo KeyHandler, 
	public Player(GamePanel gp, KeyHandler keiH) {
		this.gp = gp;
		this.keyH = keiH;
		// chiamiamo il metoto setDefaultValues() all'interno di questo costruttore 
		// per settare i valori di default
		setDefaultValues();
		getPlayerImage();
	}
	GamePanel gp;
	KeyHandler keyH;
	// Metodo che setta la posizione di default del Player
	public void setDefaultValues() {
		y = 100;
		x = 100;
		speed = 4;
		direction = "down";
	}
	// Load delle immagini dalla source res/player sulle variabili delle direzioni
	public void getPlayerImage() {
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/up1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/up2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/down2.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/down1.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/left1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/left2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/right1.png"));
			right2 =ImageIO.read(getClass().getResourceAsStream("/player/right2.png"));

		}catch(IOException e){
			e.printStackTrace();
		};
	}

	public void update() {
		if(keyH.upPressed==true || keyH.downPressed==true || keyH.leftPressed==true || keyH.rightPressed==true) {
			// Struttura condizionale che a seconda del tasto premuto updata la posizione del tiles del player
			// Sè la variabile upPressed(sopra) è settata a true (quindi è stato premuto il tasto associato a playerup(w nel nostro caso)
			// allora fa l'operazione playerY = playerY - playerSpeed
			if(keyH.upPressed == true) {
				// setta direction nella direzione corrispondente 
				direction = "up";
				// sottrae dalle coordinate Y la velocità impostata del player per farlo muovere
				y -= speed;

			}
			// Fa l'opposto (addizione) per farlo andare giù
			else if(keyH.downPressed == true) {
				direction = "down";
				y += speed;
			}
			// Fa le stesse operazioni sulla variabile PlayerX per muoversi a destra e sinistra 
			else if(keyH.leftPressed == true) {
				direction = "left";
				x -=speed;
			}

			else if(keyH.rightPressed == true) {
				direction = "right";
				x += speed;
			}
			spriteCounter++;
			if(spriteCounter > 10) {
				if(spriteNum == 1) {
					spriteNum = 2;
				}
				else if(spriteNum ==2) {
					spriteNum=1;
				}
				spriteCounter=0;
			}
		}

	}
	public void draw(Graphics g2) {
		// Metodo che setta colore utilizzato per disegnare oggetti
		//g2.setColor(Color.white);
		// Metodo che disegna un rettangolo (tra parentesi le dimensioni) possiamo cambiarle tramite le variabili utilizzate
		// con l'update saranno aggiornate le variabili dell'argomento fillRect e con il redraw sarà ridisegnato tutto con le coordinate aggiornate
		//g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		BufferedImage image=null;
		switch(direction) {
		// Switch case sulla variabile BufferedImage direction con i case stringa
		// daranno il valore (stringa/directory dell'immagine) alla variabile image
		// gli if sfruttano la variabile int come contatore per cambiare le animazioni
		case "up":
			if (spriteNum == 1) {
				image=up1;
			}
			if (spriteNum == 2) {
				image=up2;
			}
			break;

		case "down":
			if(spriteNum ==1) {
				image=down1;
			}
			if(spriteNum == 2) {
				image=down2;
			}
			break;

		case "left":
			if(spriteNum ==1) {
				image=left1;
			}
			if(spriteNum == 2) {
				image=left2;
			}
			break;

		case "right":
			if(spriteNum ==1) {
				image=right1;
			}
			if(spriteNum == 2) {
				image=right2;
			}

			break;
		}
		g2.drawImage(image, x, y,gp.tileSize,gp.tileSize,null);
	}
}
