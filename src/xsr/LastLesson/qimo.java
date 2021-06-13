package xsr.LastLesson;

import java.util.Scanner;

public class qimo {

    public static void main(String[] args) {
        System.out.println("输入任务数n: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("输入各个任务时间: ");
        int[] time = new int[n+1];
        time[0]=0;
        for(int i=1; i<=n; i++) {
            time[i] = scanner.nextInt();
        }

        int sumTime = 0;
        for(int i = 1; i < time.length; i++){
            sumTime += time[i];
        }

        int mid = sumTime / 2;
        int [][] sum = new int [time.length][mid+1];

        for(int i = 1; i < time.length; i++){
            for(int j = 1; j <= mid; j++){
                if(j - time[i] < 0)
                    sum[i][j] = sum[i-1][j];
                else
                    sum[i][j] = Math.max(sum[i-1][j], sum[i-1][j-time[i]]+time[i]);
            }
        }

        int result = sumTime-sum[sum.length-1][sum[0].length-1];
        System.out.println("最小时间T: "+result);

    }

}