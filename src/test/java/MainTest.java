import org.example.Element;
import org.example.Main;
import org.junit.jupiter.api.Assertions;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class MainTest {

    private Element element;
    private Element[][] array;

    @ParameterizedTest
    @MethodSource("getMiddleElements")
    void getNeighbours_ShouldReturnEightNeighbours_WhenElementInTheMiddleOfArray(Element middleElement) {
        array = getFilledArray(5, 5);

        Element[] neighbours = Main.getNeighbours(middleElement, array);

        Assertions.assertEquals(8, neighbours.length);
    }

    @ParameterizedTest
    @MethodSource("getSideElements")
    void getNeighbours_ShouldReturnFiveNeighbours_WhenElementInTheSideOfArray(Element sideElement) {
        array = getFilledArray(5, 5);

        Element[] neighbours = Main.getNeighbours(sideElement, array);

        Assertions.assertEquals(5, neighbours.length);
    }

    @ParameterizedTest
    @MethodSource("getAngleElements")
    void getNeighbours_ShouldReturnThreeNeighbours_WhenElementInTheAngleOfArray(Element angleElement) {
        array = getFilledArray(5, 5);

        Element[] neighbours = Main.getNeighbours(angleElement, array);

        Assertions.assertEquals(3, neighbours.length);
    }


    @ParameterizedTest
    @MethodSource("getInvalidElements")
    void getNeighbours_ShouldReturnEmptyArray_WhenElementIsInvalid(Element invalidElement) {
        array = getFilledArray(3, 3);

        Element[] neighbours = Main.getNeighbours(invalidElement, array);

        Assertions.assertEquals(0, neighbours.length);
    }


    @ParameterizedTest
    @MethodSource("getInvalidArrays")
    void getNeighbours_ShouldReturnEmptyArray_WhenArrayIsInvalid(Element[][] invalidArray) {
        element = new Element(5, 5);

        Element[] neighbours = Main.getNeighbours(element, invalidArray);

        Assertions.assertEquals(0, neighbours.length);

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
                new Element (4, 4),
                new Element(4, 1),
                new Element (1, 4));
    }

    static Stream<Element[][]> getInvalidArrays() {
      return Stream.of(null,
              getFilledArray(0, 0),
              getFilledArray(3, 0),
              getFilledArray(0, 3),
              getFilledArray(3, 3),
              getFilledArray(6, 3),
              getFilledArray(2, 6));
   }

    static Element[][] getFilledArray(int vertical, int horizontal) {
        Element[][] array = new Element[vertical][horizontal];
        for(int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = new Element(i, j);
            }
        }
        return array;
    }

}
