package coordinateSystemTest;

import jMath.aoklyunin.github.com.vector.Vector2i;
import jMath.aoklyunin.github.com.coordinateSystem.CoordinateSystem2i;

import org.junit.Test;

public class TestCoordinateSystem2i {
    // Big Values size arguments
    @Test
    public void testCoordinateSystem2iFullConv() {
            testCoordinateSystem2iConv(104, 202);
    }

    @Test
    public void testCoordinateSystem2iY1Conv() {
            testCoordinateSystem2iConv(203, 1);
    }

    @Test
    public void testCoordinateSystem2iX1Conv() {
            testCoordinateSystem2iConv(1, 908);
    }

    // Big Values min max arguments
    @Test
    public void testCoordinateSystem2iFullMinMaxConv() {
            testCoordinateSystem2iConv(-203, 104, -300, 202);
    }

    @Test
    public void testCoordinateSystem2iY1MinMaxConv() {
            testCoordinateSystem2iConv(-141, 0, 0, 203);
    }

    @Test
    public void testCoordinateSystem2iX1MinMaxConv() {
            testCoordinateSystem2iConv(0, 0, -213, 908);
    }

    // Loop tests
    @Test
    public void loopTestConv() {
            for (int i = 0; i < 30; i++)
                for (int j = 0; j < 30; j++)
                    testCoordinateSystem2iConv(i, j);
    }

    @Test
    public void loopTestMinMaxConv() {
            for (int i = -7; i < 7; i++)
                for (int i2 = i; i2 < 7; i2++)
                    for (int j = -7; j < 7; j++)
                        for (int j2 = j; j2 < 7; j2++)
                            testCoordinateSystem2iConv(i, i2, j, j2);
    }


    @Test
    public void testCoordinateSystem2iDeconv1() {
            testCoordinateSystem2iDeconv(10, 20);
    }

    @Test
    public void testCoordinateSystem2iDeconv2() {
            testCoordinateSystem2iDeconv(10, 1);
    }

    @Test
    public void testCoordinateSystem2iDeconv3() {
            testCoordinateSystem2iDeconv(1, 20);
    }


    @Test
    public void testCoordinateSystem2iDeconvMinMax1() {
            testCoordinateSystem2iDeconv(-10, 10, -20, 20);
    }

    @Test
    public void testCoordinateSystem2iDeconvMinMax2() {
            testCoordinateSystem2iDeconv(-10, 10, 0, 0);
    }

    @Test
    public void testCoordinateSystem2iDeconvMinMax3() {
            testCoordinateSystem2iDeconv(0, 0, -20, 20);
    }


    private void testCoordinateSystem2iConv(int width, int height) {
        CoordinateSystem2i c = new CoordinateSystem2i(width - 1, height - 1);
        boolean[] arr = new boolean[c.getConvValue() + 1];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Vector2i vec = new Vector2i(i, j);
                int co = c.conv(vec);
                if (!vec.equals(c.deconv(co))) {
                    System.out.println(vec + " " + c.deconv(co) + " " + co
                    );
                    System.out.println(c);
                }
                assert vec.equals(c.deconv(co));
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

    private void testCoordinateSystem2iConv(int minX, int maxX, int minY, int maxY) {
        CoordinateSystem2i c = new CoordinateSystem2i(minX, maxX, minY, maxY);
        boolean[] arr = new boolean[c.getConvValue() + 1];

        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                Vector2i vec = new Vector2i(i, j);
                int co = c.conv(vec);
                arr[co] = true;
                if (!vec.equals(c.deconv(co))) {
                    System.out.println(vec + " " + c.deconv(co) + " " + co);
                    System.out.println(c);
                }
                assert vec.equals(c.deconv(co));
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

    private void testCoordinateSystem2iDeconv(int width, int height) {
        CoordinateSystem2i c = new CoordinateSystem2i(width - 1, height - 1);
        for (int i = 0; i < c.getConvValue(); i++) {
            assert (c.checkCoords(c.deconv(i)));
        }
    }

    private void testCoordinateSystem2iDeconv(int minX, int maxX, int minY, int maxY) {
        CoordinateSystem2i c = new CoordinateSystem2i(minX, maxX, minY, maxY);
        for (int i = 0; i < c.getConvValue(); i++) {
            assert (c.checkCoords(c.deconv(i)));
        }
    }

}
