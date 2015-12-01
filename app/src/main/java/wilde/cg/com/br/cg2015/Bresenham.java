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
        this.start = start;
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
        int incX = 0;
        int incY = 0;
        int erro = 0;
        boolean inverteu = false;
//        while (lastSelected.getVirtualPoint().getX() < target.getVirtualPoint().getX()){ // "Repetir os passos seguintes enquanto x < x2"
//            incY = 0;
//            if (distance <= 0){              // Se d <= 0,
//                distance += incrementE;         //  incrementar d de incE
//            } else {                         // Caso contrário,
//                distance += incrementNE;        // Incrementar d de incNE
//                incY = 1;                    // e incrementar y de uma unidade
//            }
//
//            nextPixel = road.getAt(lastSelected.getVirtualPoint().getX() + 1, lastSelected.getVirtualPoint().getY() + incY); // "Incrementar x de uma unidade
//
//            path.add(new LineSegment(lastSelected, nextPixel));                                                              // e marcar o pixel com as coordenadas x e y"
//            lastSelected = nextPixel;
//        }

        if (Math.abs(distanceY) >= Math.abs(distanceX) && start.getVirtualPoint().getY() > target.getVirtualPoint().getY() ||
           (Math.abs(distanceY) < Math.abs(distanceX)  && distanceY < 0)){
            inverteu = true;
            lastSelected = target;
            distanceX = start.getVirtualPoint().getX() - target.getVirtualPoint().getX();
            distanceY = start.getVirtualPoint().getY() - target.getVirtualPoint().getY();
        }

        if (distanceX >= 0){
            if (distanceX >= Math.abs(distanceY)){
                incX = 1;
                erro = distanceY == 0 ? -1 : 0;
                for (int i = 1 ; i < Math.abs(distanceX) ; i++){ // for 1
                    if (erro < 0){
                        incY = 0;
                        erro += distanceY;
                    } else {
                        incY = 1;
                        erro += distanceY - distanceX;
                    }
                    nextPixel = road.getAt(lastSelected.getVirtualPoint().getX()+ incX, lastSelected.getVirtualPoint().getY() + incY);
                    path.add(new LineSegment(lastSelected, nextPixel));
                    lastSelected = nextPixel;
                }
            } else {
                incY = 1;
                for (int i = 1 ; i < Math.abs(distanceY) ; i++){ // for 2
                    if (erro < 0){
                        incX = 1;
                        erro += distanceY - distanceX;
                    } else {
                        incX = 0;
                        erro -= distanceX;
                    }
                    nextPixel = road.getAt(lastSelected.getVirtualPoint().getX()+ incX, lastSelected.getVirtualPoint().getY() + incY);
                    path.add(new LineSegment(lastSelected, nextPixel));
                    lastSelected = nextPixel;
                }
            }
        } else {
            if (Math.abs(distanceX) >= distanceY){
                incX = -1;
                erro = distanceY == 0 ? -1 : 0;
                for (int i = 1 ; i < Math.abs(distanceX); i++){ // for 3
                    if (erro < 0){
                        incY = 0;
                        erro += distanceY;
                    } else {
                        incY = 1;
                        erro += distanceY + distanceX;
                    }
                    nextPixel = road.getAt(lastSelected.getVirtualPoint().getX()+ incX, lastSelected.getVirtualPoint().getY() + incY);
                    path.add(new LineSegment(lastSelected, nextPixel));
                    lastSelected = nextPixel;
                }
            } else {
                incY = 1;
                for (int i = 1 ; i < Math.abs(distanceY) ; i++){ // for 4
                    if (erro < 0){
                        incX = -1;
                        erro += distanceY + distanceX;
                    } else {
                        incX = 0;
                        erro += distanceX;
                    }
                    nextPixel = road.getAt(lastSelected.getVirtualPoint().getX()+ incX, lastSelected.getVirtualPoint().getY() + incY);
                    path.add(new LineSegment(lastSelected, nextPixel));
                    lastSelected = nextPixel;
                }
            }
        }
        path.add(new LineSegment(lastSelected, inverteu ? start : target));
        return path;
    }


}