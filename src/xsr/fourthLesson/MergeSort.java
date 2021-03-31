package xsr.fourthLesson;


public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3,2,8,74,15,64,44,4};
        int[] result = mergeSort(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+"\t");
        }
    }

    public static int[] mergeSort(int[] arr){
        if (arr.length == 1){
            return arr;
        }
        int left = 0;
        int right = arr.length-1;
        int mid = (left + right)/2;
        int[] sonArr1 = new int[mid-left+1];
        int[] sonArr2 = new int[right-mid];
        for (int i = 0; i <= mid; i++) {
            sonArr1[i] = arr[i];
        }
        int temp = 0;
        for (int j = mid+1; j <= right; j++) {
            sonArr2[temp] = arr[j];
            temp++;
        }

        return merge(mergeSort(sonArr1), mergeSort(sonArr2));
    }

    public static int[] merge(int[] sonArr1,int[] sonArr2 ){
        int length = sonArr1.length + sonArr2.length;
        int[] mergeArr = new int[length];
        int index = 0;
        int i=0,j=0;
        while (i < sonArr1.length && j < sonArr2.length){
            if (sonArr1[i] <= sonArr2[j]){
                mergeArr[index] = sonArr1[i];
                i++;
            }else {
                mergeArr[index] = sonArr2[j];
                j++;
            }
            index++;
        }
        for (int k = i; k < sonArr1.length; k++) {
            mergeArr[index] = sonArr1[k];
            index++;
        }

        for (int k = j; k < sonArr2.length; k++) {
            mergeArr[index] = sonArr2[k];
            index++;
        }

        return mergeArr;
    }
}
