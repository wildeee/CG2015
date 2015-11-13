package wilde.cg.com.br.cg2015;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void testePointDistance5(){
        Point p = new Point(0, 0);
        Point p2 = new Point(3, 4);

        assertEquals(5, p.getDistance(p2), 0.01);
    }

    @Test
    public void testePointDistance(){
        Point p = new Point(7, 20);
        Point p2 = new Point(3, 4);

        assertEquals(16.49, p.getDistance(p2), 0.01);
    }
}