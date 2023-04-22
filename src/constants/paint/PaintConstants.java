package constants.paint;

public class PaintConstants {
  // setta la size di base degli elementi di gioco (player,npcs etcs)
  public static final int ORIGINAL_TILE_SIZE = 16; // 16x16 pixel tile
  // setta la scale del monitor  a 3   16x3 = 48  pixel così il nostro tile sarà 16x16 ma sembrerà 48x48
  public static final int SCALE = 3;
  // setta la tile size
  public static final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE; // 48x48 pixel tile
  // settaggio della dimensione massima di tiles visibili nello screen utilizzando righe e colonne (la ratio è 4 to 3)
  // 16 colonne orizzontali  (questa variabile se modificata cambierà automaticamente la larghezza dello screen)
  public static final int MAX_SCREEN_COL = 16;
  // 12 righe verticali      (questa variabile se modificata cambierà automaticamente la lunghezza dello screen)
  public static final int MAX_SCREEN_ROW = 12;
  // settaggio width dello screen
  public static final int SCREEN_WIDTH = TILE_SIZE * MAX_SCREEN_COL; // 768 pixels (altezza)
  // settaggio height dello screen
  public static final int SCREEN_HEIGHT = TILE_SIZE * MAX_SCREEN_ROW; // 576 pixels (larghezza)

}
