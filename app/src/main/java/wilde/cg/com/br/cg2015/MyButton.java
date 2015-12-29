package wilde.cg.com.br.cg2015;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

public class MyButton {

    private Rect button;
    private final int left;
    private final int top;
    private final int right;
    private final int bottom;

    private final String label = "RESET";

    public MyButton(int left, int top, int right, int bottom){
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        button = new Rect(left, top, right, bottom);
    }

    public void draw(Canvas canvas){
        Paint black = new Paint();
        Paint white = new Paint();

        black.setColor(Color.BLACK);
        black.setStyle(Paint.Style.FILL);
        white.setColor(Color.WHITE);
        white.setTextSize(bottom - top - 10);

        canvas.drawRect(this.button, black);
        canvas.drawText(label, 15, 32, white);
    }


    public int getLeft() {
        return left;
    }

    public int getTop() {
        return top;
    }

    public int getRight() {
        return right;
    }

    public int getBottom() {
        return bottom;
    }
}
