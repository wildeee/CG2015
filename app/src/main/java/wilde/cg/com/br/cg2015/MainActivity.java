package wilde.cg.com.br.cg2015;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private ViewController screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setConfig();
        setContentView(R.layout.activity_main);

        Button bresenham = (Button)findViewById(R.id.bresenham);

        bresenham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen = new ViewController(MainActivity.this);
                setContentView(screen);
                Thread t = new Thread(screen);
                t.start();
            }
        });

    }

    private void setConfig(){

        Config.ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

        Config.SCREEN_WIDTH = this.getWindowManager().getDefaultDisplay().getWidth();
        Config.SCREEN_HEIGHT = this.getWindowManager().getDefaultDisplay().getHeight();

        Config.HORIZONTAL_DISTORTION = Config.VIRTUAL_WIDTH / Config.SCREEN_WIDTH;
        Config.VERTICAL_DISTORTION = Config.VIRTUAL_HEIGHT / Config.SCREEN_HEIGHT;

        this.setRequestedOrientation(Config.ORIENTATION);
    }

}
