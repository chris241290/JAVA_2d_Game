package main;

import javax.swing.JFrame;

public class Main {

  public static void main(String[] args) {
    // Creazione di un oggetto JFrame e import della libreria che ci permette di chiamare le funzioni della classe JFrame che
    // gestisce L'interfaccia grafica con le classi
    JFrame window = new JFrame();
    // Metodo che setta la default close operation
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // Metodo che setta come non resaizabile (con false)
    window.setResizable(false);
    // Metodo che setta il TITOLO
    window.setTitle("Sei Top");
    // Creazione dell'istanza per l'oggetto GamePanel (clase)
    GamePanel gamePanel = new GamePanel();
    // Chiama il metodo window e gli passa i parametri stabiliti in gamepanel, così la finestra avrà quei parametri
    window.add(gamePanel);
    // Pack associa le modifiche a window
    window.pack();
    // Metodo che setta la location della finestra, in questo caso abbiamo settato di default (quindi la finestra sarà al centro
    // dello schermo)
    window.setLocationRelativeTo(null);
    // Metodo che rende la finestra visibile con argomento boolean TRUE
    window.setVisible(true);
    // Chiama il metodo per avviare il loop  di gioco (con update e draw)
    gamePanel.startGameThread();

  }

}
