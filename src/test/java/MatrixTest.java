import org.example.Element;
import org.example.Matrix;
import org.junit.jupiter.api.Assertions;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class MatrixTest {

    private Matrix matrix = new Matrix(5, 5);
    private Element element;

    @ParameterizedTest
    @MethodSource("getMiddleElements")
    void getNeighboursOfElement_ShouldReturnEightNeighbours_WhenElementInTheMiddleOfArray(Element middleElement) {
        Element[] neighbours = matrix.getNeighboursOfElement(middleElement);

        Assertions.assertEquals(8, neighbours.length);
    }

    @ParameterizedTest
    @MethodSource("getSideElements")
    void getNeighboursOfElement_ShouldReturnFiveNeighbours_WhenElementInTheSideOfArray(Element sideElement) {
        Element[] neighbours = matrix.getNeighboursOfElement(sideElement);

        Assertions.assertEquals(5, neighbours.length);
    }

    @ParameterizedTest
    @MethodSource("getAngleElements")
    void getNeighboursOfElement_ShouldReturnThreeNeighbours_WhenElementInTheAngleOfArray(Element angleElement) {
        Element[] neighbours = matrix.getNeighboursOfElement(angleElement);

        Assertions.assertEquals(3, neighbours.length);
    }

    @ParameterizedTest
    @MethodSource("getInvalidElements")
    void getNeighboursOfElement_ShouldReturnEmptyArray_WhenElementIsInvalid(Element invalidElement) {
        Element[] neighbours = matrix.getNeighboursOfElement(invalidElement);

        Assertions.assertEquals(0, neighbours.length);
    }

    @ParameterizedTest
    @MethodSource("getMatrixesWithDifferentSizes")
    void getNeighboursOfElement_ShouldReturnNotNullArray_WhenMatrixHasDifferentSizes(Matrix matrixWithDifSize) {
        matrix = matrixWithDifSize;

        Element element = new Element(0, 0);

        Element[] neighbours = matrix.getNeighboursOfElement(element);

        Assertions.assertNotNull(neighbours);
        Assertions.assertTrue(neighbours.length >= 0);
    }

    static Stream<Element> getMiddleElements() {
        return Stream.of(new Element(1, 1),
                new Element(1, 3),
                new Element(2, 2),
                new Element(3, 1),
                new Element(3, 3));
    }

    static Stream<Element> getSideElements() {
        return Stream.of(new Element(2, 0),
                new Element(0, 2),
                new Element(2, 4),
                new Element(4, 2));
    }

    static Stream<Element> getAngleElements() {
        return Stream.of(new Element(0, 0),
                new Element(0, 4),
                new Element(4, 0),
                new Element(4, 4));
    }

    static Stream<Element> getInvalidElements() {
        return Stream.of(new Element(-1, -1),
                new Element(-1, 1),
                new Element(1, -1 ),
                new Element (5, 5),
                new Element(5, 1),
                new Element (1, 5));
    }

    static Stream<Matrix> getMatrixesWithDifferentSizes() {
        return Stream.of(new Matrix(0, 0),
                new Matrix(1, 1),
                new Matrix(5, 0),
                new Matrix(0, 5));
    }

}
