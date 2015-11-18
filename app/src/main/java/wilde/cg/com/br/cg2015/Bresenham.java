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

        this.distanceX = target.getVirtualPoint().getX() - start.getVirtualPoint().getX(); // dx = x2 - x1
        this.distanceY = target.getVirtualPoint().getY() - start.getVirtualPoint().getY(); // dy = y2 - y1

        this.distance = 2 * distanceY - distanceX;                           // d = 2dy - dx

        this.incrementE = 2 * distanceY;                                     // incE = 2dy
        this.incrementNE = 2 * (distanceY - distanceX);                      // incNE = 2(dy - dx)

        this.lastSelected = start;    // "Inicializar x = x1 e y = y1 e marcar pixels com essa coordenada".
        // Foi inicializado, porém será marcado em outro momento.

    }

    public List<LineSegment> buildPath(){
        List<LineSegment> path = new ArrayList<>();
        Pixel nextPixel;
        int incY;
        while (lastSelected.getVirtualPoint().getX() < target.getVirtualPoint().getX()){ // "Repetir os passos seguintes enquanto x < x2"
            incY = 0;
            if (distance <= 0){              // Se d <= 0,
                distance += incrementE;         //  incrementar d de incE
            } else {                         // Caso contrário,
                distance += incrementNE;        // Incrementar d de incNE
                incY = 1;                    // e incrementar y de uma unidade
            }

            nextPixel = road.getAt(lastSelected.getVirtualPoint().getX() + 1, lastSelected.getVirtualPoint().getY() + incY); // "Incrementar x de uma unidade

            path.add(new LineSegment(lastSelected, nextPixel));                                                              // e marcar o pixel com as coordenadas x e y"
            lastSelected = nextPixel;
        }


        return path;
    }
}