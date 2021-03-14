package coordinateSystemTest;

import jMath.aoklyunin.github.com.vector.Vector4d;
import jMath.aoklyunin.github.com.coordinateSystem.CoordinateSystem4d;
import org.junit.Test;

public class TestCoordinateSystem4d {

    int divideCnt = 5;

    // Big Values size arguments
    @Test
    public void testCoordinateSystem4dFullConv() {
            testCoordinateSystem4dConv(594, 456, 456, 912);
    }

    @Test
    public void testCoordinateSystem4dX1Conv() {
            testCoordinateSystem4dConv(1, 908, 450, 245);
    }

    @Test
    public void testCoordinateSystem4dY1Conv() {
            testCoordinateSystem4dConv(203, 1, 908, 245);
    }

    @Test
    public void testCoordinateSystem4dZ1Conv() {
            testCoordinateSystem4dConv(203, 908, 1, 245);
    }

    @Test
    public void testCoordinateSystem4dW1Conv() {
            testCoordinateSystem4dConv(203, 908, 270, 1);
    }

    @Test
    public void testCoordinateSystem4dY1Z1Conv() {
            testCoordinateSystem4dConv(908, 1, 1, 450);
    }

    @Test
    public void testCoordinateSystem4dZ1X1Conv() {
            testCoordinateSystem4dConv(1, 345, 1, 439);
    }

    @Test
    public void testCoordinateSystem4dY1X1Conv() {
            testCoordinateSystem4dConv(1, 1, 345, 219);
    }

    @Test
    public void testCoordinateSystem4dW1X1Conv() {
            testCoordinateSystem4dConv(1, 345, 789, 1);
    }

    @Test
    public void testCoordinateSystem4dW1Y1Conv() {
            testCoordinateSystem4dConv(121, 1, 345, 1);
    }

    @Test
    public void testCoordinateSystem4dW1Z1Conv() {
            testCoordinateSystem4dConv(412, 345, 1, 1);
    }

    @Test
    public void testCoordinateSystem4dX1Y1Z1Conv() {
            testCoordinateSystem4dConv(1, 1, 1, 450);
    }

    @Test
    public void testCoordinateSystem4dX1Y1W1Conv() {
            testCoordinateSystem4dConv(1, 1, 450, 1);
    }

    @Test
    public void testCoordinateSystem4dX1Z1W1Conv() {
            testCoordinateSystem4dConv(1, 450, 1, 1);
    }

    @Test
    public void testCoordinateSystem4dY1Z1W1Conv() {
            testCoordinateSystem4dConv(450, 1, 1, 1);
    }

    // Big Values min max arguments
    @Test
    public void testCoordinateSystem4dFullMinMaxConv() {
            testCoordinateSystem4dConv(-310, -191, -231, -201, 194, 456, 456, 301);
    }

    @Test
    public void testCoordinateSystem4dY1MinMaxConv() {
            testCoordinateSystem4dConv(-301, 0, -211, -134, 203, 0, 908, 304);
    }

    @Test
    public void testCoordinateSystem4dZ1MinMaxConv() {
            testCoordinateSystem4dConv(-131, -439, 0, -231, 203, 908, 0, 78);
    }

    @Test
    public void testCoordinateSystem4dX1MinMaxConv() {
            testCoordinateSystem4dConv(0, -513, -123, -200, 0, 908, 450, 300);
    }

    @Test
    public void testCoordinateSystem4dW1MinMaxConv() {
            testCoordinateSystem4dConv(-513, -123, -200, 0, 908, 450, 300, 0);
    }

    @Test
    public void testCoordinateSystem4dY1Z1MinMaxConv() {
            testCoordinateSystem4dConv(-321, 0, 0, -123, 908, 0, 0, 430);
    }

    @Test
    public void testCoordinateSystem4dZ1W1MinMaxConv() {
            testCoordinateSystem4dConv(-85, -97, 0, 0, 14, 345, 0, 28);
    }


    @Test
    public void testCoordinateSystem4dW1X1MinMaxConv() {
            testCoordinateSystem4dConv(0, -321, -123, 0, 0, 908, 430, 0);
    }

    @Test
    public void testCoordinateSystem4dX1Y1MinMaxConv() {
            testCoordinateSystem4dConv(0, 0, -97, -14, 0, 0, 345, 28);
    }


    @Test
    public void testCoordinateSystem4dZ1X1MinMaxConv() {
            testCoordinateSystem4dConv(0, -97, 0, -97, 0, 345, 0, 261);
    }

    @Test
    public void testCoordinateSystem4dDeconv1() {
            testCoordinateSystem4dDeconv(10, 20, 30, 40);
    }

    @Test
    public void testCoordinateSystem4dDeconv2() {
            testCoordinateSystem4dDeconv(10, 1, 30, 40);
    }

    @Test
    public void testCoordinateSystem4dDeconv3() {
            testCoordinateSystem4dDeconv(10, 20, 1, 40);
    }

    @Test
    public void testCoordinateSystem4dDeconv4() {
            testCoordinateSystem4dDeconv(1, 20, 30, 40);
    }

    @Test
    public void testCoordinateSystem4dDeconvMinMax1() {
            testCoordinateSystem4dDeconv(-10, -20, -30, -40, 10, 20, 30, 40);
    }

    @Test
    public void testCoordinateSystem4dDeconvMinMax2() {
            testCoordinateSystem4dDeconv(-10, -0, -30, -40, 10, 0, 30, 40);
    }

    @Test
    public void testCoordinateSystem4dDeconvMinMax3() {
            testCoordinateSystem4dDeconv(-10, -20, 0, -30, 10, 20, 0, 30);
    }

    @Test
    public void testCoordinateSystem4dDeconvMinMax4() {
            testCoordinateSystem4dDeconv(0, -20, -30, -40, 0, 20, 30, 40);
    }


    @Test
    public void loopTestConv() {
            for (int i = 1; i < 10; i++)
                for (int j = 1; j < 10; j++)
                    for (int k = 1; k < 10; k++)
                        for (int l = 1; l < 10; l++)
                            testCoordinateSystem4dDeconv(i, j, k, l);
    }

    @Test
    public void loopTestMinMaxConv() {
            for (int i = -2; i < 2; i++)
                for (int i2 = i; i2 < 2; i2++)
                    for (int j = -2; j < 2; j++)
                        for (int j2 = j; j2 < 2; j2++)
                            for (int k = -2; k < 2; k++)
                                for (int k2 = k; k2 < 2; k2++)
                                    for (int l = -2; l < 2; l++)
                                        for (int l2 = l; l2 < 2; l2++)
                                            testCoordinateSystem4dConv(i, j, k, l, i2, j2, k2, l2);
    }


    private void testCoordinateSystem4dConv(int width, int height, int depth, int w) {
        CoordinateSystem4d c = new CoordinateSystem4d(width - 1, height - 1, depth - 1, w - 1);
        boolean[] arr = new boolean[c.getConvValue(divideCnt) + 1];
        Vector4d delta = Vector4d.mul(c.getSize(),1.0 / divideCnt);
        for (int i = 0; i <= divideCnt; i++) {
            for (int j = 0; j <= divideCnt; j++) {
                for (int k = 0; k <= divideCnt; k++) {
                    for (int l = 0; l <= divideCnt; l++) {
                        Vector4d vec = new Vector4d(i * delta.x, j * delta.y, k * delta.z, l * delta.w);
                        int co = c.conv(vec, divideCnt);
                        assert vec.equals(c.deconv(co, divideCnt));
                        arr[co] = true;
                    }
                }
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

    private void testCoordinateSystem4dConv(int minX, int minY, int minZ, int minW, int maxX, int maxY, int maxZ, int maxW) {
        CoordinateSystem4d c = new CoordinateSystem4d(minX, maxX, minY, maxY, minZ, maxZ, minW, maxW);
        boolean[] arr = new boolean[c.getConvValue(divideCnt) + 1];
        Vector4d delta = Vector4d.mul(c.getSize(),1.0 / divideCnt);
        for (int i = 0; i <= divideCnt; i++) {
            for (int j = 0; j <= divideCnt; j++) {
                for (int k = 0; k <= divideCnt; k++) {
                    for (int l = 0; l <= divideCnt; l++) {
                        Vector4d vec = new Vector4d(i * delta.x, j * delta.y, k * delta.z, l * delta.w);
                        vec = Vector4d.sum(vec, c.getMin());
                        int co = c.conv(vec, divideCnt);
                        assert vec.equals(c.deconv(co, divideCnt));
                        arr[co] = true;
                    }
                }
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

    private void testCoordinateSystem4dDeconv(int width, int height, int depth, int w) {
        CoordinateSystem4d c = new CoordinateSystem4d(width - 1, height - 1, depth - 1, w - 1);
        for (int i = 0; i < c.getConvValue(divideCnt); i++) {
            assert (c.checkCoords(c.deconv(i, divideCnt)));
        }
    }


    private void testCoordinateSystem4dDeconv(int minX, int minY, int minZ, int minW, int maxX, int maxY, int maxZ, int maxW) {
        CoordinateSystem4d c = new CoordinateSystem4d(minX, maxX, minY, maxY, minZ, maxZ, minW, maxW);
        for (int i = 0; i < c.getConvValue(divideCnt); i++) {
            assert (c.checkCoords(c.deconv(i, divideCnt)));
        }
    }


}
