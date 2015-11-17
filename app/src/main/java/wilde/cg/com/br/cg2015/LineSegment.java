package wilde.cg.com.br.cg2015;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class LineSegment {

    private Paint paint;
    private Pixel begin;
    private Pixel end;

    public LineSegment(Pixel begin, Pixel end) {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        this.begin = begin;
        this.end = end;
    }

    public void draw(Canvas canvas) {
        canvas.drawLine(begin.getPoint().getX(),
                        begin.getPoint().getY(),
                          end.getPoint().getX(),
                          end.getPoint().getY(),
                        paint
        );
    }
}
