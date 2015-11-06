package wilde.cg.com.br.cg2015;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

public class ViewController extends View implements Runnable {

    private static final String TAG = "ViewController";
    private int i;
    private Paint paint;

    public ViewController(Context context) {
        super(context);
        init();
    }

    private void init() {
        this.i = 0;
        paint = new Paint();
        paint.setColor(Color.BLACK);
    }

    @Override
    public void run() {
        while (true){
            try {
                this.update();
                postInvalidate();
                Thread.sleep(50);
            }
            catch (Exception ex){
                Log.d(TAG, "Erro no Loop do jogo.");
            }
        }
    }

    public void update(){
        i++;
    }

    protected void onDraw(Canvas canvas){
        canvas.drawText("Valor do i: " + i, 50, 100, paint);
    }
}
