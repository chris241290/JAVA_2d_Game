package tiles;

import constants.paint.PaintConstants;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import javax.imageio.ImageIO;

public class TileManager {

  private final int tileSize;

  private Tile[] tiles;

  private int mapTileNum[][];

  public TileManager(int tileSize) {
    this.tileSize = tileSize;
    tiles = new Tile[10];
    mapTileNum = new int[PaintConstants.MAX_SCREEN_COL][PaintConstants.MAX_SCREEN_ROW];
    loadTilesImages();
    loadMap();
  }

  public void loadTilesImages() {
    try {
      tiles[0] = new Tile();
      tiles[0].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/background/dirt/dirt.png"))));
      tiles[1] = new Tile();
      tiles[1].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/background/grass/grass.png"))));
      tiles[2] = new Tile();
      tiles[2].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/background/rocks/rocks.png"))));
      tiles[3] = new Tile();
      tiles[3].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/background/water/water.png"))));
      tiles[4] = new Tile();
      tiles[4].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/background/wood/wood.png"))));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void draw(Graphics2D g2) {

    int col = 0;
    int row = 0;
    int x = 0;
    int y = 0;

    while(col < PaintConstants.MAX_SCREEN_COL && row < PaintConstants.MAX_SCREEN_ROW) {
      int tileNum = mapTileNum[col][row];
      g2.drawImage(tiles[tileNum].getImage(), x, y, tileSize, tileSize, null);
      col++;
      x += tileSize;

      if(col == PaintConstants.MAX_SCREEN_COL) {
        col = 0;
        x = 0;
        row++;
        y += tileSize;
      }
    }
  }

  public void loadMap() {
    try {
      InputStream is = Objects.requireNonNull(getClass().getResourceAsStream("/maps/map02.txt"));
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

      int col = 0;
      int row = 0;

      while(col < PaintConstants.MAX_SCREEN_COL && row < PaintConstants.MAX_SCREEN_ROW) {
        String line = bufferedReader.readLine();

        while(col < PaintConstants.MAX_SCREEN_COL) {
          String numbers[] = line.split(" ");
          int num = Integer.parseInt(numbers[col]);

          mapTileNum[col][row] = num;
          col++;
        }
        if (col == PaintConstants.MAX_SCREEN_COL) {
          col = 0;
          row++;
        }
      }
      bufferedReader.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
