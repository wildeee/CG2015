package wilde.cg.com.br.cg2015;

import android.graphics.Canvas;

public abstract class DrawableObject {

    private int x;
    private int y;
    private int width;
    private int height;

    public DrawableObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public abstract void update();
    public abstract void draw(Canvas canvas);

    public void updateDistortion(){
        this.width = (int) (this.width * Config.HORIZONTAL_DISTORTION);
        this.height = (int) (this.height * Config.VERTICAL_DISTORTION);
    }
}
