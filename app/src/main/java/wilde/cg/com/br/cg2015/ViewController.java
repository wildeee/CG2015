package wilde.cg.com.br.cg2015;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class ViewController extends View implements Runnable {

    private static final String TAG = "ViewController";

    private PixelMail pixels;

    public ViewController(Context context) {
        super(context);
        init();
    }

    private void init() {
        pixels = new PixelMail();

        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                System.out.println("X: " + event.getX());
                System.out.println("Y: " + event.getY());
                System.out.println();
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
    }
}
