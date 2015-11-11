package wilde.cg.com.br.cg2015;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Pixel extends ViewObject {

    private Rect body;
    private Paint paint;

    public Pixel(int x, int y) {
        super(x, y, 10, 10);
        body = new Rect();
        paint = new Paint();
        paint.setColor(Color.BLACK);
        updateDistortion();
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRect(body, paint);
        body.top = super.getY();
        body.bottom = super.getY() + super.getHeight();
        body.left = super.getX();
        body.right = super.getX() + super.getWidth();
    }

    @Override
    public void updateDistortion() {
        super.updateDistortion();
        super.setX((int) (super.getX() * Config.HORIZONTAL_DISTORTION));
        super.setY((int) (super.getY() * Config.VERTICAL_DISTORTION));
    }
}
