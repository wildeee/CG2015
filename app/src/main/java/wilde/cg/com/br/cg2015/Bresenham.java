package wilde.cg.com.br.cg2015;

import java.util.ArrayList;
import java.util.List;

public class Bresenham {

    private Pixel start;
    private Pixel target;

    private PixelMail road;

    private Pixel lastSelected;

    private int distanceX;
    private int distanceY;

    private int distance;

    private int incrementE;
    private int incrementNE;

    public Bresenham(Pixel start, Pixel target, PixelMail road) {
        this.start = start;    // x1 y1
        this.target = target;  // x2 y2
        this.road = road;

        this.distanceX = target.getPoint().getX() - start.getPoint().getX(); // dx = x2 - x1
        this.distanceY = target.getPoint().getY() - start.getPoint().getY(); // dy = y2 - y1

        this.distance = 2 * distanceY - distanceX;                           // d = 2dy - dx

        this.incrementE = 2 * distanceY;                                     // incE = 2dy
        this.incrementNE = 2 * (distanceY - distanceX);                      // incNE = 2(dy - dx)

        this.lastSelected = start;    // "Inicializar x = x1 e y = y1 e marcar pixels com essa coordenada".
        // Foi inicializado, porém será marcado em outro momento.

    }

    public List<LineSegment> buildPath(){
        List<LineSegment> path = new ArrayList<>();

        while (lastSelected.getPoint().getX() < target.getPoint().getX()){ // "Repetir os passos seguintes enquanto x < x2"
            if (distance <= 0){              // Se d <= 0,
                distance += incrementE;         //  incrementar d de incE
            } else {                         // Caso contrário,
                distance += incrementNE;        // Incrementar d de incNE
                                                // e incrementar y de uma unidade

            }
                                     // "Incrementar x de uma unidade e marcar o pixel com as coordenadas x e y"
        }


        return path;
    }
}