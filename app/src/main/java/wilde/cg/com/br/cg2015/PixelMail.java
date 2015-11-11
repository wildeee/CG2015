package wilde.cg.com.br.cg2015;

import android.graphics.Canvas;

public class PixelMail {

    private Pixel pixels[][];

    private static final int rowCount = 10;
    private static final int colCount = 6;
    private static final int distance = 68;

    public PixelMail() {
        pixels = new Pixel[rowCount][colCount];

        for (int row = 0; row < rowCount; row++){
            for (int col = 0; col < colCount; col++){
                pixels[row][col] = new Pixel((col + 1) * distance, (row + 1) * distance);
            }
        }
    }

    public void draw(Canvas canvas){
        for (int row = 0; row < rowCount; row++){
            for (int col = 0; col < colCount; col++){
                pixels[row][col].draw(canvas);
            }
        }
    }
}
