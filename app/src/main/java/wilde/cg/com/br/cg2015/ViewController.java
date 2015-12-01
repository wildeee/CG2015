package wilde.cg.com.br.cg2015;

import android.content.Context;
import android.graphics.Canvas;
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

    public ViewController(Context context) {
        super(context);
        init();
    }

    private void init() {
        pixels = new PixelMail();
        selectedPixelsAmount = 0;

        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Pixel clicked = pixels.getNearestPixel((int) event.getX(), (int) event.getY()); // Ainda é necessário verificar se os pixels clicados não são iguais. Após isso, desenhar a reta entre pixels, e partir para a implementação do Bresenham.

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

        if (reta != null){
            for (LineSegment lineSegment : reta) {
                lineSegment.draw(canvas);
            }
        }
    }

}
