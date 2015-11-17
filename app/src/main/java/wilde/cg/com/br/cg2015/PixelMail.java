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
                pixels[row][col] = new Pixel(new Point((col + 1) * distance, (row + 1) * distance));
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

    public Pixel getNearestPixel(int x, int y){
        Pixel nearest = pixels[0][0];
        Point clicked = new Point(x, y);
        double nearestDistance = nearest.getPoint().getDistance(clicked);
        double distance;

        for (Pixel[] pixelArray : pixels) {
            for (Pixel pixel : pixelArray) {
                distance = clicked.getDistance(pixel.getPoint());
                if (distance < nearestDistance){
                    nearest = pixel;
                    nearestDistance = distance;
                }
            }
        }
        return nearest;
    }

    public Pixel getAt(int x, int y){
        return pixels[x][y];
    }
}
