package wilde.cg.com.br.cg2015;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Pixel extends ViewObject {

    private Rect body;
    private Paint paint;
    private boolean selected;

    public Pixel(Point point) {
        super(point, 10, 10);
        selected = false;
        body = new Rect();
        paint = new Paint();
        paint.setColor(Color.BLACK);
        updateDistortion();
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRect(body, paint);
        body.top = super.getPoint().getY();
        body.bottom = super.getPoint().getY() + super.getHeight();
        body.left = super.getPoint().getX();
        body.right = super.getPoint().getX() + super.getWidth();
    }

    @Override
    public void updateDistortion() {
        super.updateDistortion();
        super.getPoint().setX((int) (super.getPoint().getX() * Config.HORIZONTAL_DISTORTION));
        super.getPoint().setY((int) (super.getPoint().getY() * Config.VERTICAL_DISTORTION));
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        paint.setColor(selected ? Color.RED : Color.BLACK);
        this.selected = selected;
    }
}
