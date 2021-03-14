package coordinateSystemTest;

import jMath.aoklyunin.github.com.vector.Vector2d;
import jMath.aoklyunin.github.com.coordinateSystem.CoordinateSystem2d;
import org.junit.Test;

public class TestCoordinateSystem2d {
    int divideCnt = 5;

    // Big Values size arguments
    @Test
    public void testCoordinateSystem2dFullConv() {
        testCoordinateSystem2dConv(104, 202);
    }

    @Test
    public void testCoordinateSystem2dY1Conv() {
        testCoordinateSystem2dConv(203, 1);
    }

    @Test
    public void testCoordinateSystem2dX1Conv() {
        testCoordinateSystem2dConv(1, 908);
    }

    // Big Values min max arguments
    @Test
    public void testCoordinateSystem2dFullMinMaxConv() {
        testCoordinateSystem2dConv(-300, 104, -203, 202);
    }

    @Test
    public void testCoordinateSystem2dY1MinMaxConv() {
        testCoordinateSystem2dConv(-141, 0, 0, 203);
    }

    @Test
    public void testCoordinateSystem2dX1MinMaxConv() {
        testCoordinateSystem2dConv(-213, 0, 0, 908);
    }

    @Test
    public void testCoordinateSystem2dDeconv1() {
        testCoordinateSystem2dDeconv(10, 20);
    }

    @Test
    public void testCoordinateSystem2dDeconv2() {
        testCoordinateSystem2dDeconv(10, 1);
    }

    @Test
    public void testCoordinateSystem2dDeconv3() {
        testCoordinateSystem2dDeconv(1, 20);
    }

    @Test
    public void testCoordinateSystem2dDeconvMinMax1() {
        testCoordinateSystem2dDeconv(-20, 10, -10, 20);
    }

    @Test
    public void testCoordinateSystem2dDeconvMinMax2() {
        testCoordinateSystem2dDeconv(-10, 0, 0, 10);
    }

    @Test
    public void testCoordinateSystem2dDeconvMinMax3() {
        testCoordinateSystem2dDeconv(-20, 0, 0, 20);
    }


    // Loop tests
    @Test
    public void loopTestConv() {
        for (int i = 1; i < 30; i++)
            for (int j = 1; j < 30; j++)
                testCoordinateSystem2dConv(i, j);
    }

    @Test
    public void loopTestMinMaxConv() {
        for (int i = -7; i < 7; i++)
            for (int i2 = i; i2 < 7; i2++)
                for (int j = -7; j < 7; j++)
                    for (int j2 = j; j2 < 7; j2++)
                        testCoordinateSystem2dConv(i, j, i2, j2);
    }


    private void testCoordinateSystem2dConv(int width, int height) {
        CoordinateSystem2d c = new CoordinateSystem2d(width - 1, height - 1);
        boolean[] arr = new boolean[c.getConvValue(divideCnt) + 1];
        Vector2d delta = Vector2d.mul(c.getSize(), 1.0 / divideCnt);
        for (int i = 0; i <= divideCnt; i++) {
            for (int j = 0; j <= divideCnt; j++) {
                Vector2d vec = new Vector2d(i * delta.x, j * delta.y);
                int co = c.conv(vec, divideCnt);
                assert vec.equals(c.deconv(co, divideCnt));
                arr[co] = true;
            }
        }
        boolean flgRight = true;
        for (boolean b : arr) {
            if (!b) {
                flgRight = false;
                break;
            }
        }
        assert flgRight;
    }

    private void testCoordinateSystem2dConv(int minX, int minY, int maxX, int maxY) {
        CoordinateSystem2d c = new CoordinateSystem2d(minX, maxX, minY, maxY);
        boolean[] arr = new boolean[c.getConvValue(divideCnt) + 1];
        Vector2d delta = Vector2d.mul(c.getSize(), 1.0 / divideCnt);
        for (int i = 0; i <= divideCnt; i++) {
            for (int j = 0; j <= divideCnt; j++) {
                Vector2d vec = new Vector2d(i * delta.x, j * delta.y);
                vec.add(c.getMin());
                int co = c.conv(vec, divideCnt);
                assert vec.equals(c.deconv(co, divideCnt));
                arr[co] = true;
            }
        }
        boolean flgRight = true;
        for (boolean b : arr) {
            if (!b) {
                flgRight = false;
                break;
            }
        }
        assert flgRight;
    }

    private void testCoordinateSystem2dDeconv(int width, int height) {
        CoordinateSystem2d c = new CoordinateSystem2d(width - 1, height - 1);
        for (int i = 0; i < c.getConvValue(divideCnt); i++) {
            assert (c.checkCoords(c.deconv(i, divideCnt)));
        }
    }


    private void testCoordinateSystem2dDeconv(int minX, int minY, int maxX, int maxY) {
        CoordinateSystem2d c = new CoordinateSystem2d(minX, maxX, minY, maxY);
        for (int i = 0; i < c.getConvValue(divideCnt); i++) {
            assert (c.checkCoords(c.deconv(i, divideCnt)));
        }
    }


}
