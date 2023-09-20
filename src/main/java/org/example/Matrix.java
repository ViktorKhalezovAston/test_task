package org.example;

import java.util.ArrayList;
import java.util.List;

public class Matrix {

    private int verticalSize;
    private int horizontalSize;
    private Element[][] array;


    public Matrix(int vertical, int horizontal) {
        verticalSize = vertical;
        horizontalSize = horizontal;
        array = new Element[vertical][horizontal];
        fillArray();
    }

    public Element[] getNeighboursOfElement(Element element) {
       List<Element> neighbours = new ArrayList<>();

        int x = element.getX();
        int y = element.getY();

        if(hasElement(x, y)) {
           checkAndAddNeighbour(x + 1, y, neighbours);
           checkAndAddNeighbour(x + 1, y - 1, neighbours);
           checkAndAddNeighbour(x, y - 1, neighbours);
           checkAndAddNeighbour(x - 1,y - 1, neighbours);
           checkAndAddNeighbour(x - 1, y, neighbours);
           checkAndAddNeighbour(x - 1, y + 1, neighbours);
           checkAndAddNeighbour(x, y + 1, neighbours);
           checkAndAddNeighbour(x + 1,y + 1, neighbours);
       }
        return neighbours.stream().toArray(Element[]::new);
    }

    private boolean hasElement(int x, int y) {
        if(x < 0 || x > verticalSize - 1 || y < 0 || y > horizontalSize - 1) {
            return false;
        }
        return true;
    }

    private boolean checkAndAddNeighbour(int x, int y, List<Element> neighbours) {
        if(hasElement(x, y)) {
            neighbours.add(array[x][y]);
            return true;
        }
        return false;
    }

    private void fillArray() {
        for(int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = new Element(i, j);
            }
        }
    }

    public void print() {
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
