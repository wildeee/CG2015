package wilde.cg.com.br.cg2015;

public abstract class DinamicViewObject extends ViewObject {

    public DinamicViewObject(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public abstract void update();
}
