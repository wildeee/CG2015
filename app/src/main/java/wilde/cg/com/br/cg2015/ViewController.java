package wilde.cg.com.br.cg2015;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.List;

public class ViewController extends View implements Runnable {

    private static final String TAG = "ViewController";

    private PixelMail pixels;

    private int selectedPixelsAmount;
    private Pixel start;
    private Pixel target;

    private List<LineSegment> reta;

    private Bresenham bresenham;

    private MyButton btn;

    public ViewController(Context context) {
        super(context);
        init();
    }

    private boolean checkResetButton(int x, int y){
        return
                x >= btn.getLeft() && x <= btn.getRight()
             && y >= btn.getTop() && y <= btn.getBottom();
    }

    public void init() {
        pixels = new PixelMail();
        selectedPixelsAmount = 0;

        btn = new MyButton(10, 10, 80, 40);


        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int x = (int) event.getX();
                int y = (int) event.getY();

                if (checkResetButton(x, y)) {
                    reta = null;
                    ViewController.this.init();
                    return false;
                }

                Pixel clicked = pixels.getNearestPixel(x, y);

                if (selectedPixelsAmount == 1) {
                    target = clicked;
                    target.setSelected(true);
                    selectedPixelsAmount++;

                    bresenham = new Bresenham(start, target, pixels);
                    reta = bresenham.buildPath();
                }

                if (selectedPixelsAmount == 0) {
                    start = clicked;
                    start.setSelected(true);
                    selectedPixelsAmount++;
                }
                return false;
            }
        });

    }

    @Override
    public void run() {
        while (true){
            this.postInvalidate();
            try {
                this.update();
                Thread.sleep(50);
            }
            catch (Exception ex){
                Log.d(TAG, "Erro no Loop do app.");
            }
        }
    }

    public void update(){
    }

    @Override
    protected void onDraw(Canvas canvas){
        pixels.draw(canvas);
        btn.draw(canvas);

        if (reta != null){
            for (LineSegment lineSegment : reta) {
                lineSegment.draw(canvas);
            }
        }
    }

}
