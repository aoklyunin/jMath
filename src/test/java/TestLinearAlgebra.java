import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.junit.jupiter.api.Test;
import jMath.aoklyunin.github.com.linearAlgebra.*;

public class TestLinearAlgebra {
    /**
     * Провекра разложения матрицы средствами  apache
     */
    @Test
    public void testAppacheMatrixEigenDecomposition() {
        double[][] matrix = LinearAlgebra.getRandomMatrix(100, 20.0);

        RealMatrix A = new Array2DRowRealMatrix(matrix);
        EigenDecomposition eigenADecomposition = new EigenDecomposition(A);
        RealMatrix V = eigenADecomposition.getV();
        RealMatrix D = eigenADecomposition.getD();
        RealMatrix W = MatrixUtils.inverse(V);
        // проверка правых собственныхвекторов
        assert A.multiply(V).subtract(V.multiply(D)).getNorm() < 0.0001;
        // проверка левых собственных векторов
        assert W.multiply(A).subtract(D.multiply(W)).getNorm() < 0.0001;
    }
}
