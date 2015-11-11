package wilde.cg.com.br.cg2015;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
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
