package wilde.cg.com.br.cg2015;

import android.graphics.Canvas;

public abstract class ViewObject {

    private final Point point;
    private int width;
    private int height;

    public ViewObject(Point point, int width, int height) {
        this.point = point;
        this.width = width;
        this.height = height;
    }

    public abstract void draw(Canvas canvas);

    public void updateDistortion(){
        this.width = (int) (this.width * Config.HORIZONTAL_DISTORTION);
        this.height = (int) (this.height * Config.VERTICAL_DISTORTION);
    }

    public Point getPoint() {
        return point;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
