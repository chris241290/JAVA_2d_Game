package gamepanel;

import constants.paint.PaintConstants;
import constants.run.RunConstants;
import entity.player.Player;
import entity.player.keyhandler.KeyHandler;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

// Classe Jpanel che è una subclasse di GamePanel e ha l'interfaccia Runnable
public class GamePanel extends JPanel implements Runnable {

  // Setta la posizione di default del player (userò queste variabili come argomenti del metodo fillrect in paint componet
  private static final int PLAYER_X = 100;
  private static final int PLAYER_Y = 100;
  // Setta la velocità del tiles che usiamo come character (4 pixel)
  private static final int PLAYER_SPEED = 4;

  private KeyHandler keyH;
  private Player player;
  private Thread gameThread;

  // Metodo che definisce l'aspetto del nostro game panel
  public GamePanel() {
    // Istanza della classe KeyHandler sotto la variabile keyH
    keyH = new KeyHandler();
    // Creazione dell'istanza della classe player (nuovo oggetto di tipo player)
    player = new Player(PaintConstants.TILE_SIZE, keyH);
    // Imposta la size passando come argomento alla funzione Dimension le due variabili che abbiamo creato
    setPreferredSize(new Dimension(PaintConstants.SCREEN_WIDTH, PaintConstants.SCREEN_HEIGHT));
    // setta il colore del background del nostro panel (nero)
    setBackground(Color.black);
    // setta il doppio buffer ( per maggiori info leggiti il metodo cristo)
    setDoubleBuffered(true);
    // Questi due metodi permettono al gamepanel di gestire la sottoclasse KeyListener (di KeyHandler)
    addKeyListener(keyH);
    // focusable permette al gamepanel di ricevere i key input
    setFocusable(true);
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
    double nextDrawTime = System.nanoTime() + RunConstants.DRAW_INTERVAL;
    System.out.println("FPS:" + RunConstants.FPS);
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
        nextDrawTime += RunConstants.DRAW_INTERVAL;
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
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

  // Creazione del metodo update che chiameremo nel loop di gioco
  public void update() {
    // chiama il metodo update dalla classe Player
    player.update();
  }

}
