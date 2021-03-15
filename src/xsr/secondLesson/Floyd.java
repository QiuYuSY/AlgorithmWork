package xsr.secondLesson;

import java.util.Arrays;

public class Floyd {
    private static final int INF = 10000;

    public static void main(String[] args) {
        int[][] matrix = {
                {0,2,6,4},
                {INF,0,3,INF},
                {7,INF,0,1},
                {5,INF,12,0}
        };

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }

        for (int k = 0; k < matrix.length ; k++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[i][j] > matrix[i][k] + matrix[k][j]){
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }

    }
}
