package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размерность массива:");
        int vertical = scanner.nextInt();
        int horizontal = scanner.nextInt();

        Element[][] array = getFilledArray(vertical, horizontal);

        printArray(array);

        Element element = new Element(0, 3);

        Element[] neighbours = getNeighbours(element, array);

        System.out.println("Соседи: " + Arrays.toString(neighbours));

    }

    public static Element[] getNeighbours(Element element, Element[][] array) {
        List<Element> neighbours = new ArrayList<>();

        if (array == null || array.length == 0 || array[0].length == 0) {
            return neighbours.stream().toArray(Element[]::new);
        }

        int x = element.getX();
        int y = element.getY();

        if(x < 0 || x > array.length - 1) {
            return neighbours.stream().toArray(Element[]::new);
        }

        if(y < 0 || y > array[0].length - 1) {
            return neighbours.stream().toArray(Element[]::new);
        }

        addElementsToNeighbours(x, y, array, neighbours);

        return neighbours.stream().toArray(Element[]::new);
    }

    private static void addElementsToNeighbours(int x, int y, Element[][] array, List<Element> neighbours) {
        if(x != array.length - 1) {
            neighbours.add(array[x + 1][y]);
        }
        if(x != array.length - 1 && y != 0) {
            neighbours.add(array[x + 1][y - 1]);
        }
        if(y != 0) {
            neighbours.add(array[x][y - 1]);
        }
        if(x != 0 && y != 0) {
            neighbours.add(array[x - 1][y - 1]);
        }
        if(x != 0) {
            neighbours.add(array[x - 1][y]);
        }
        if(x != 0 && y != array[x].length - 1) {
            neighbours.add(array[x - 1][y + 1]);
        }
        if(y != array[x].length - 1) {
            neighbours.add(array[x][y + 1]);
        }
        if(x != array.length - 1 && y != array[x].length - 1) {
            neighbours.add(array[x + 1][y + 1]);
        }
    }

    private static Element[][] getFilledArray(int vertical, int horizontal) {
        Element[][] array = new Element[vertical][horizontal];
        for(int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = new Element(i, j);
            }
        }
        return array;
    }

    private static void printArray(Element[][] array) {
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

}