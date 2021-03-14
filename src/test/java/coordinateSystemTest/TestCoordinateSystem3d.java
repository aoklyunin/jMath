package coordinateSystemTest;

import jMath.aoklyunin.github.com.vector.Vector3d;
import jMath.aoklyunin.github.com.coordinateSystem.CoordinateSystem3d;

import org.junit.Test;

public class TestCoordinateSystem3d {

    private final int divideCnt = 5;

    // Big Values size arguments
    @Test
    public void testCoordinateSystem3dFullConv() {
            testCoordinateSystem3dConv(594, 456, 456);
    }

    @Test
    public void testCoordinateSystem3dY1Conv() {
            testCoordinateSystem3dConv(203, 1, 908);
    }

    @Test
    public void testCoordinateSystem3dZ1Conv() {
            testCoordinateSystem3dConv(203, 908, 1);
    }

    @Test
    public void testCoordinateSystem3dX1Conv() {
            testCoordinateSystem3dConv(1, 908, 450);
    }

    @Test
    public void testCoordinateSystem3dY1Z1Conv() {
            testCoordinateSystem3dConv(908, 1, 1);
    }

    @Test
    public void testCoordinateSystem3dZ1X1Conv() {
            testCoordinateSystem3dConv(1, 345, 1);
    }

    // Big Values min max arguments
    @Test
    public void testCoordinateSystem3dFullMinMaxConv() {
            testCoordinateSystem3dConv(-310, -191, -231, 194, 456, 456);
    }

    @Test
    public void testCoordinateSystem3dY1MinMaxConv() {
            testCoordinateSystem3dConv(-301, 0, -211, 203, 0, 908);
    }

    @Test
    public void testCoordinateSystem3dZ1MinMaxConv() {
            testCoordinateSystem3dConv(-131, -439, 0, 203, 908, 0);
    }

    @Test
    public void testCoordinateSystem3dX1MinMaxConv() {
            testCoordinateSystem3dConv(0, -513, -123, 0, 908, 450);
    }

    @Test
    public void testCoordinateSystem3dY1Z1MinMaxConv() {
            testCoordinateSystem3dConv(-321, 0, 0, 908, 0, 0);
    }

    @Test
    public void testCoordinateSystem3dZ1X1MinMaxConv() {
            testCoordinateSystem3dConv(0, -97, 0, 0, 345, 0);
    }

    @Test
    public void testCoordinateSystem3dDeconv1() {
            testCoordinateSystem3dDeconv(10, 20, 30);
    }

    @Test
    public void testCoordinateSystem3dDeconv2() {
            testCoordinateSystem3dDeconv(10, 1, 30);
    }

    @Test
    public void testCoordinateSystem3dDeconv3() {
            testCoordinateSystem3dDeconv(10, 20, 1);
    }

    @Test
    public void testCoordinateSystem3dDeconv4() {
            testCoordinateSystem3dDeconv(1, 20, 30);
    }

    @Test
    public void testCoordinateSystem3dDeconvMinMax1() {
            testCoordinateSystem3dDeconv(-10, -20, -30, 10, 20, 30);
    }

    @Test
    public void testCoordinateSystem3dDeconvMinMax2() {
            testCoordinateSystem3dDeconv(-10, -0, -30, 10, 0, 30);
    }

    @Test
    public void testCoordinateSystem3dDeconvMinMax3() {
            testCoordinateSystem3dDeconv(-10, -20, 0, 10, 20, 0);
    }

    @Test
    public void testCoordinateSystem3dDeconvMinMax4() {
            testCoordinateSystem3dDeconv(0, -20, -30, 0, 20, 30);
    }


    @Test
    public void loopTestConv() {
            for (int i = 1; i < 10; i++)
                for (int j = 1; j < 10; j++)
                    for (int k = 1; k < 10; k++)
                        testCoordinateSystem3dDeconv(i, j, k);
    }

    @Test
    public void loopTestMinMaxConv() {
            for (int i = -3; i < 3; i++)
                for (int i2 = i; i2 < 3; i2++)
                    for (int j = -3; j < 3; j++)
                        for (int j2 = j; j2 < 3; j2++)
                            for (int k = -3; k < 3; k++)
                                for (int k2 = k; k2 < 3; k2++)
                                    testCoordinateSystem3dConv(i, j, k, i2, j2, k2);
    }


    private void testCoordinateSystem3dConv(int width, int height, int depth) {
        CoordinateSystem3d c = new CoordinateSystem3d(width - 1, height - 1, depth - 1);
        System.out.println(c.getConvValue(divideCnt) + 1);
        boolean[] arr = new boolean[c.getConvValue(divideCnt) + 1];
        Vector3d delta = Vector3d.mul(c.getSize(), 1.0 / divideCnt);
        for (int i = 0; i <= divideCnt; i++) {
            for (int j = 0; j <= divideCnt; j++) {
                for (int k = 0; k <= divideCnt; k++) {
                    Vector3d vec = new Vector3d(i * delta.x, j * delta.y, k * delta.z);
                    System.out.print(vec+" ");
                    int co = c.conv(vec, divideCnt);
                    System.out.print(co+" ");
                    System.out.println(c.deconv(co,divideCnt)+" ");
                    assert vec.equals(c.deconv(co, divideCnt));
                    arr[co] = true;
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

    private void testCoordinateSystem3dConv(int minX, int minY, int minZ, int maxX, int maxY, int maxZ) {
        CoordinateSystem3d c = new CoordinateSystem3d(minX, maxX, minY, maxY, minZ, maxZ);
        boolean[] arr = new boolean[c.getConvValue(divideCnt) + 1];
        Vector3d delta = Vector3d.mul(c.getSize(), 1.0 / divideCnt);
        for (int i = 0; i <= divideCnt; i++) {
            for (int j = 0; j <= divideCnt; j++) {
                for (int k = 0; k <= divideCnt; k++) {
                    Vector3d vec = Vector3d.sum(new Vector3d(i * delta.x, j * delta.y, k * delta.z), c.getMin());
                    int co = c.conv(vec, divideCnt);
                    assert vec.equals(c.deconv(co, divideCnt));
                    arr[co] = true;
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

    private void testCoordinateSystem3dDeconv(int width, int height, int depth) {
        CoordinateSystem3d c = new CoordinateSystem3d(width - 1, height - 1, depth - 1);
        for (int i = 0; i < c.getConvValue(divideCnt); i++) {
            assert (c.checkCoords(c.deconv(i, divideCnt)));
        }
    }


    private void testCoordinateSystem3dDeconv(int minX, int minY, int minZ, int maxX, int maxY, int maxZ) {
        CoordinateSystem3d c = new CoordinateSystem3d(minX, maxX, minY, maxY, minZ, maxZ);
        for (int i = 0; i < c.getConvValue(divideCnt); i++) {
            assert (c.checkCoords(c.deconv(i, divideCnt)));
        }
    }


}
