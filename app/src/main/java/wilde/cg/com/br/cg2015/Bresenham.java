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

//        int x, y, erro, deltaX, deltaY;
//        erro = 0;
//        x = p1.x;
//        y = p1.y;
//        deltaX = p2.x - p1.x;
//        deltaY = p2.y - p1.y;
//
//        if((Math.abs(deltaY)>=Math.abs(deltaX) && p1.y>p2.y)
//                ||(Math.abs(deltaY)<Math.abs(deltaX) && deltaY<0)){
//
//            x = p2.x;
//            y = p2.y;
//            deltaX = p1.x-p2.x;
//            deltaY = p1.y-p2.y;
//        }
//        p1.draw(g);
//        if(deltaX>=0){
//            if(Math.abs(deltaX)>=Math.abs(deltaY)){
//                for(int i=1;i<Math.abs(deltaX);i++){
//                    if(erro<0){
//                        x++;
//                        new Ponto(x,y).draw(g);
//                        erro += deltaY;
//                    }else{
//                        x++;
//                        y++;
//                        new Ponto(x,y).draw(g);
//                        erro += deltaY - deltaX;
//                    }
//                }
//            }else{
//                for(int i=1;i<Math.abs(deltaY);i++){
//                    if(erro<0){
//                        x++;
//                        y++;
//                        new Ponto(x,y).draw(g);
//                        erro += deltaY - deltaX;
//                    }else{
//                        y++;
//                        new Ponto(x,y).draw(g);
//                        erro -= deltaX;
//                    }
//                }
//            }
//        }else{ // deltaX=Math.abs(deltaY)){
//            for(int i=1;i<Math.abs(deltaX);i++){
//                if(erro<0){
//                    x--;
//                    new Ponto(x,y).draw(g);
//                    erro += deltaY;
//                }else{
//                    x--;
//                    y++;
//                    new Ponto(x,y).draw(g);
//                    erro += deltaY + deltaX;
//                }
//            }
//        }else{
//            for(int i=1;i<Math.abs(deltaY);i++){
//                if(erro<0){
//                    x--;
//                    y++;
//                    new Ponto(x,y).draw(g);
//                    erro += deltaY + deltaX;
//                }else{
//                    y++;
//                    new Ponto(x,y).draw(g);
//                    erro += deltaX;
//                }
//            }
//        }
//    }
//    p2.draw(g);
//}
}