package xsr.thirdLesson;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arrs = {1,2,3,4,5,6,7,8,9,10,12,18,21,25,29,31,37,46,49,51,52,57,59};
        int searchNumber = 52;
        int left = 0;
        int right = arrs.length - 1;
        int mid;
        int index = 0;
        while (left < right){
            mid = (left+right)/2;
            if (searchNumber == arrs[mid]){
                index = mid;
                break;
            }else if (searchNumber < arrs[mid]){
                right = mid;
            }else if (searchNumber > arrs[mid]) {
                left = mid;
            }
        }
        System.out.println(searchNumber+"在数组中的下标为"+ index);
    }
}
