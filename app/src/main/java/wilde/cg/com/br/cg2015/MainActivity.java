package wilde.cg.com.br.cg2015;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private ViewController screen;
    private MainActivity self = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bresenham = (Button)findViewById(R.id.bresenham);

        bresenham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen = new ViewController(self);
                setContentView(screen);
                Thread t = new Thread(screen);
                t.start();
            }
        });

    }

}
