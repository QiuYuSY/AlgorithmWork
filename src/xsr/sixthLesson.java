package xsr;

import java.util.Arrays;

public class sixthLesson {
    static int r = 5;

    public static void main(String[] args) {
        int[] arr = {3,2,8,74,15,64,44,4,5};
        int m = select(arr,0,arr.length-1,4);
        System.out.println(m);
    }

    private static int select(int[] A, int low, int high, int k) {
        int num = high - low + 1;
        int group = (int) Math.ceil(1.0 * num / r);

        int[] M = new int[group];

        for (int i = 0; i < group; i++) {
            Arrays.sort(A, low + r * i, low + r * i + (num > r * i + r ? r : num - i * r));
            M[i] = A[low + r * i + (num > r * i + r ? r : num - i * r) / 2];
        }

        int mid = M.length <= 2 ? M[0] : select(M, 0, M.length - 1, M.length / 2);
        int[] S1 = new int[num];
        int[] S2 = new int[num];
        int numS1, numS2, numS3;
        numS1 = numS2 = numS3 = 0;

        for (int i = low; i <= high; i++) {
            if (A[i] < mid) {
                S1[numS1++] = A[i];
            } else if (A[i] == mid) {
                numS3++;
            } else {
                S2[numS2++] = A[i];
            }
        }
        if (numS1 >= k) {
            return select(S1, 0, numS1 - 1, k);
        } else if (numS1 + numS3 >= k) {
            return mid;
        } else {
            return select(S2, 0, numS2 - 1, k - numS1 - numS3);
        }

    }

}
