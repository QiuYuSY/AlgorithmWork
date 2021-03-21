package xsr.thirdLesson;

public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr= {1,3,8,15,19,25,36,38,48,56,68,79,88,99,105,112,118,200};

        int i = insertValueSearch(arr,0,arr.length-1,105);
        System.out.println(i);
    }

    public static int insertValueSearch(int[] arr,int left, int right, int findVal){


        if (left > right || findVal < arr[0] || findVal > arr[arr.length-1]){
            return -1;
        }
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        if (arr[mid] < findVal) {
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else if (arr[mid] > findVal) {
            return insertValueSearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }
}

