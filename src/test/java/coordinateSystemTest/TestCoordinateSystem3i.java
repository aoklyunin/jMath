package coordinateSystemTest;

import jMath.aoklyunin.github.com.vector.Vector3i;
import jMath.aoklyunin.github.com.coordinateSystem.CoordinateSystem3i;
import org.junit.Test;

public class TestCoordinateSystem3i {

    // Big Values size arguments
    @Test
    public void testCoordinateSystem3iFullConv() {
            testCoordinateSystem3iConv(594, 456, 456);
    }

    @Test
    public void testCoordinateSystem3iY1Conv() {
            testCoordinateSystem3iConv(203, 1, 908);
    }

    @Test
    public void testCoordinateSystem3iZ1Conv() {
            testCoordinateSystem3iConv(203, 908, 1);
    }

    @Test
    public void testCoordinateSystem3iX1Conv() {
            testCoordinateSystem3iConv(1, 908, 450);
    }

    @Test
    public void testCoordinateSystem3iY1Z1Conv() {
            testCoordinateSystem3iConv(908, 1, 1);
    }

    @Test
    public void testCoordinateSystem3iZ1X1Conv() {
            testCoordinateSystem3iConv(1, 345, 1);
    }

    // Big Values min max arguments
    @Test
    public void testCoordinateSystem3iFullMinMaxConv() {
            testCoordinateSystem3iConv(-310, -191, -231, 194, 456, 456);
    }

    @Test
    public void testCoordinateSystem3iY1MinMaxConv() {
            testCoordinateSystem3iConv(-301, 0, -211, 203, 0, 908);
    }

    @Test
    public void testCoordinateSystem3iZ1MinMaxConv() {
            testCoordinateSystem3iConv(-131, -439, 0, 203, 908, 0);
    }

    @Test
    public void testCoordinateSystem3iX1MinMaxConv() {
            testCoordinateSystem3iConv(0, -513, -123, 0, 908, 450);
    }

    @Test
    public void testCoordinateSystem3iY1Z1MinMaxConv() {
            testCoordinateSystem3iConv(-321, 0, 0, 908, 0, 0);
    }

    @Test
    public void testCoordinateSystem3iZ1X1MinMaxConv() {
            testCoordinateSystem3iConv(0, -97, 0, 0, 345, 0);
    }

    // Loop tests
    @Test
    public void loopTestConv() {
            for (int i = 0; i < 30; i++)
                for (int j = 0; j < 30; j++)
                    for (int k = 0; k < 30; k++)
                        testCoordinateSystem3iDeconv(i, j, k);
    }

    @Test
    public void loopTestMinMaxConv() {
            for (int i = -7; i < 7; i++)
                for (int i2 = i; i2 < 7; i2++)
                    for (int j = -7; j < 7; j++)
                        for (int j2 = j; j2 < 7; j2++)
                            for (int k = -7; k < 7; k++)
                                for (int k2 = k; k2 < 7; k2++)
                                    testCoordinateSystem3iConv(i, j, k, i2, j2, k2);
    }


    private void testCoordinateSystem3iConv(int width, int height, int depth) {
        CoordinateSystem3i c = new CoordinateSystem3i(width - 1, height - 1, depth - 1);
        boolean[] arr = new boolean[c.getConvValue() + 1];

        //System.out.println(CoordinateSystem3i.toString(c.size));
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                for (int k = 0; k < depth; k++) {
                    Vector3i vec = new Vector3i(i, j, k);
                    int co = c.conv(vec);
                    assert vec.equals(c.deconv(co));
                    //System.out.println(c.deconv(co)+" "+vec);
                    //System.out.println(co + " " + i + " " + j + " " + k);
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

    private void testCoordinateSystem3iConv(int minX, int minY, int minZ, int maxX, int maxY, int maxZ) {
        CoordinateSystem3i c = new CoordinateSystem3i(minX, maxX, minY, maxY, minZ, maxZ);
//        System.out.println(c);
//        System.out.println(c.getMaxNumber());
        boolean[] arr = new boolean[c.getConvValue() + 1];

        //System.out.println(CoordinateSystem3i.toString(c.size));
        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                for (int k = minZ; k <= maxZ; k++) {
                    Vector3i vec = new Vector3i(i, j, k);
                    int co = c.conv(vec);
                    // System.out.println(c.deconv(co)+" "+vec);
                    assert vec.equals(c.deconv(co));
                    //System.out.println(CoordinateSystem3i.toString(new Vector3i(i, j, k)) + " " + co);
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

    @Test
    public void testCoordinateSystem3iDeconv1() {
        testCoordinateSystem3iDeconv(10, 20, 30);
    }

    @Test
    public void testCoordinateSystem3iDeconv2() {
        testCoordinateSystem3iDeconv(10, 1, 30);
    }

    @Test
    public void testCoordinateSystem3iDeconv3() {
        testCoordinateSystem3iDeconv(10, 20, 1);
    }

    @Test
    public void testCoordinateSystem3iDeconv4() {
        testCoordinateSystem3iDeconv(1, 20, 30);
    }

    private void testCoordinateSystem3iDeconv(int width, int height, int depth) {
        CoordinateSystem3i c = new CoordinateSystem3i(width - 1, height - 1, depth - 1);
        for (int i = 0; i < c.getConvValue(); i++) {
            assert (c.checkCoords(c.deconv(i)));
        }
    }

    @Test
    public void testCoordinateSystem3iDeconvMinMax1() {
        testCoordinateSystem3iDeconv(-10, -20, -30, 10, 20, 30);
    }

    @Test
    public void testCoordinateSystem3iDeconvMinMax2() {
        testCoordinateSystem3iDeconv(-10, -0, -30, 10, 0, 30);
    }

    @Test
    public void testCoordinateSystem3iDeconvMinMax3() {
        testCoordinateSystem3iDeconv(-10, -20, 0, 10, 20, 0);
    }

    @Test
    public void testCoordinateSystem3iDeconvMinMax4() {
        testCoordinateSystem3iDeconv(0, -20, -30, 0, 20, 30);
    }


    private void testCoordinateSystem3iDeconv(int minX, int minY, int minZ, int maxX, int maxY, int maxZ) {
        CoordinateSystem3i c = new CoordinateSystem3i(minX, maxX, minY, maxY, minZ, maxZ);
        for (int i = 0; i < c.getConvValue(); i++) {
            assert (c.checkCoords(c.deconv(i)));
        }
    }


}
