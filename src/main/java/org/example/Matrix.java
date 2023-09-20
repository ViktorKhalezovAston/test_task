package org.example;

import java.util.ArrayList;
import java.util.List;

public class Matrix {

    private int verticalSize;
    private int horizontalSize;
    private Element[][] array;
    private List<Element> neighbours;

    public Matrix(int vertical, int horizontal) {
        verticalSize = vertical;
        horizontalSize = horizontal;
        array = new Element[vertical][horizontal];
        fillArray();
        neighbours = new ArrayList<>();
    }

    public Element[] getNeighboursOfElement(Element element) {
       if(hasElement(element)) {
           int x = element.getX();
           int y = element.getY();

           addNeighbour(new Element(x + 1, y));
           addNeighbour(new Element(x + 1, y - 1));
           addNeighbour(new Element(x, y - 1));
           addNeighbour(new Element(x - 1, y - 1));
           addNeighbour(new Element(x - 1, y));
           addNeighbour(new Element(x - 1, y + 1));
           addNeighbour(new Element(x, y + 1));
           addNeighbour(new Element(x + 1, y + 1));
       }
        return neighbours.stream().toArray(Element[]::new);
    }

    private boolean hasElement(Element element) {
        int x = element.getX();
        int y = element.getY();
        if(x < 0 || x > verticalSize - 1 || y < 0 || y > horizontalSize - 1) {
            return false;
        }
        return true;
    }

    private boolean addNeighbour(Element element) {
        if(hasElement(element)) {
            neighbours.add(element);
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
