package wilde.cg.com.br.cg2015;

public class Bresenham {

    private Pixel start;
    private Pixel target;

    private PixelMail road;

    public Bresenham(Pixel start, Pixel target, PixelMail road) {
        this.start = start;
        this.target = target;
        this.road = road;
    }
}