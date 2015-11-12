package wilde.cg.com.br.cg2015;

public abstract class DinamicViewObject extends ViewObject {

    public DinamicViewObject(Point point, int width, int height) {
        super(point, width, height);
    }

    public abstract void update();
}
