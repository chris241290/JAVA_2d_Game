package entity;

import java.awt.image.BufferedImage;

public class Entity { // Classe padre per tutte le entità del gioco (npc,mostri,personaggio,etc.)
	// queste variabili saranno presenti in tutte le entità del gioco che si muovono (mostri,npc etc)
	// saranno ereditate da tutte le classi che fanno parte della superclasse Entity
    // Variabile int per le coordinate sullo schermo
	public int y,x;
	// Variabile per la velocità
	public int speed;
	// BufferedImage descrive un immagine accessibile tramite una source
	public BufferedImage up1,up2,down1,down2,left1,left2,right1,right2;
	// Variabile stringa direction su cui faremo lo switch case delle stringhe
	// "up" "down" etc. per gestire le variabili BufferedImagee aggiornare le animazioni su schermo
	public String direction;
	// variabili int contatori degli sprite per cambiare le animazioni
	public int spriteCounter = 0;
	public int spriteNum = 1;
	
	}