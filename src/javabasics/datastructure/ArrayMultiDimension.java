package javabasics.datastructure;

import java.util.Arrays;

public class ArrayMultiDimension {

    public static void main(String[] args) {
        int rows = 4;
        int columns = 4;
        int[][] twoDimArray = twoDimensionalArray(rows, columns);
        int[][] twoDimArrayClone = twoDimArray.clone();
        int[][] twoDimArrayDeepClone = deepCopy(twoDimArray); //implemented programmatically

        System.out.println("Original 2D array is: ");
        printArray(rows, columns, twoDimArray);

        twoDimArray[0][0] = 123; //Changes to original array affects shallow clone array but doesn't affect a deep cloned array

        System.out.println("Changes to original array affects shallow clone array as well: ");
        printArray(rows, columns, twoDimArrayClone);

        System.out.println("but doesn't affect a deep cloned array: ");
        printArray(rows, columns, twoDimArrayDeepClone);
    }

    private static void printArray(int rows, int columns, int[][] arr) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] deepCopy(int[][] twoDimArray) {
        int[][] result = new int[twoDimArray.length][];
        for(int i=0; i<twoDimArray.length; i++){
            result[i] = Arrays.copyOf(twoDimArray[i], twoDimArray.length);
        }
        return result;
    }

    private static int[][] twoDimensionalArray(int rows, int columns) {
        int[][] twoDimArray = new int[rows][columns];
        int value = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                twoDimArray[i][j] = value;
                value++;
            }
        }
        return twoDimArray;
    }
}
