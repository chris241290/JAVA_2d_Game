package main;

import entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

// Classe Jpanel che è una subclasse di GamePanel e ha l'interfaccia Runnable
public class GamePanel extends JPanel implements Runnable {

  // setta la size di base degli elementi di gioco (player,npcs etcs)
  final int originalTileSize = 16; // 16x16 pixel tile
  // setta la scale del monitor  a 3   16x3 = 48  pixel così il nostro tile sarà 16x16 ma sembrerà 48x48
  final int scale = 3;
  // setta la tile size
  public final int tileSize = originalTileSize * scale; // 48x48 pixel tile
  // settaggio della dimensione massima di tiles visibili nello screen utilizzando righe e colonne (la ratio è 4 to 3)
  // 16 colonne orizzontali  (questa variabile se modificata cambierà automaticamente la larghezza dello screen)
  final int maxScreenCol = 16;
  // 12 righe verticali      (questa variabile se modificata cambierà automaticamente la lunghezza dello screen)
  final int maxScreenRow = 12;
  // settaggio width dello screen
  final int screenWidth = tileSize * maxScreenCol; // 768 pixels (altezza)
  // settaggio height dello screen
  final int screenHeight = tileSize * maxScreenRow; // 576 pixels (larghezza)

  // FPS : settaggio degli fps (frame per seconds) a cui viene runnato il gioco (velocità di update)
  int fps = 60;

  KeyHandler keyH;
  Player player;
  Thread gameThread;
  // Setta la posizione di default del player (userò queste variabili come argomenti del metodo fillrect in paint componet
  int playerX = 100;
  int playerY = 100;
  // Setta la velocità del tiles che usiamo come character (4 pixel)
  int playerSpeed = 4;

  // Metodo che definisce l'aspetto del nostro game panel
  public GamePanel() {
    // Istanza della classe KeyHandler sotto la variabile keyH
    keyH = new KeyHandler();
    // Creazione dell'istanza della classe player (nuovo oggetto di tipo player)
    player = new Player(tileSize, keyH);
    // Imposta la size passando come argomento alla funzione Dimension le due variabili che abbiamo creato
    this.setPreferredSize(new Dimension(screenWidth, screenHeight));
    // setta il colore del background del nostro panel (nero)
    this.setBackground(Color.black);
    // setta il doppio buffer ( per maggiori info leggiti il metodo cristo)
    this.setDoubleBuffered(true);
    // Questi due metodi permettono al gamepanel di gestire la sottoclasse KeyListener (di KeyHandler)
    this.addKeyListener(keyH);
    // focusable permette al gamepanel di ricevere i key input
    this.setFocusable(true);

  }

  // Metodo che crea il game thread
  public void startGameThread() {
    System.out.println("START GameThread");
    // Metodo che crea un nuovo oggetto di Thread (leggi il metodo per maggiori info)
    gameThread = new Thread(this);
    gameThread.start();

  }

  // Metodo run che cicla update e redraw del programma
  @Override  // Metodo per runnarlo (Metodo Run dell'interfaccia Runnable sovrascritto)
  public void run() {

    // Game loop di tipo "sleep"
    double drawInterval = 1000000000 / fps;
    double nextDrawTime = System.nanoTime() + drawInterval;
    System.out.println("FPS:" + fps);
    // Ciclo per il loop di gioco
    while (gameThread != null) {
      // Setta la variabile currentTime con System.nanotime che returna
      // il valore corrente della risorsa temporale della JVM in nanosecondi (checka il systemtime)
      // ci serve un appoggio per far far avere al programma un riferimento temporale per fare l'update
      // in pratica diamo al programma un idea del tempo che passa e si regola su esso
      long currentTime = System.nanoTime(); // return in nanosecondi (1 miliardo = 1 secondo)
      // long currentTime2 = System.currentTimeMillis(); // return in millisecondi (1000 = 1 secondo)
      // 1) UPDATE: aggiorna informazioni come ad esempio la posizione del personaggio
      // esempio: Mettiamo che il nostro personaggio sia alle coordinate x: 100 y:100
      // premento il tasto per andare giù, che ad esempio equivale a +3 y (3 pixel) l'update
      // aggiornerà a y : 103 (+3 alle coordinate di y)
      update();
      // 2) DRAW: draw the screen(disegna lo schermo) con le informazioni updatate
      // se ad esempio il player continua a tener premuto il tasto per andare giù, mentre l'update
      // delle coordinate diventerà gradualmente 103,106,109,112 etc avverrà anche il redrawing del
      // nostro pg sullo screen
      repaint();
      // Syso per check del loop di gioco

      // UPDATE E DRAW vengono fatti tante volte al secondo per quanti sono gli fps (frame per seconds)
      // del programma ad esempio 30 volte se sarà a 30fps, 60 se a 60fps etc.
      try {
        double remainingTime = nextDrawTime - System.nanoTime();
        remainingTime = remainingTime / 1000000;
        if (remainingTime < 0) {
          remainingTime = 0;
        }
        Thread.sleep((long) remainingTime);
        nextDrawTime += drawInterval;
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  // Creazione del metodo update che chiameremo nel loop di gioco
  public void update() {
    // chiama il metodo update dalla classe Player
    player.update();
  }

  // la matita o il pennello con cui disegnamo
  @Override
  public void paintComponent(Graphics g) {
    // ottieni accesso tramite la keyword super alla classe padre paintComponent
    super.paintComponent(g);
    // istanza della classe Graphics2D che è una sottoclasse di Graphics
    //che si occupa del disegno e del controllo della geometria del programma
    Graphics2D g2 = (Graphics2D) g;
    // chiamo il metodo dalla classe player
    player.draw(g2);
    // dispose delle risorse occupate (non obbligatorio ma ottimizza l'utilizzo di memoria del software)
    g2.dispose();
  }

}
