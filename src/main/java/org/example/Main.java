package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите вертикальную длину массива:");
        int vertical = scanner.nextInt();
        System.out.println("Введите горизонтальную длину массива:");
        int horizontal = scanner.nextInt();

        Matrix matrix = new Matrix(vertical, horizontal);

        matrix.print();

        Element element = new Element(1, 3);

        Element[] neighbours = matrix.getNeighboursOfElement(element);

        System.out.println("Соседи: " + Arrays.toString(neighbours));
    }

}