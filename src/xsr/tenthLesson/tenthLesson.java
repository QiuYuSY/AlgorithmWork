package xsr.tenthLesson;

import java.util.Scanner;

public class tenthLesson {
    public static void main(String[] args) {
        int n,C,i,j=0,t=0;
        int[] W = new int[100];

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入轮船的最大载重量：");
        C = scanner.nextInt();
        System.out.println("请输入集装箱个数：");
        n = scanner.nextInt();

        System.out.println("请依次输入集装箱的重量：");


        for(i=0;i<n;i++){
            W[i] = scanner.nextInt();
        }

        MergeSort(W,0,n-1);
        while (t + W[j] <= C) {
            t += W[j];
            j++;
        }
        System.out.println("轮船最多装"+j+"个集装箱，重量分别为：");
        for(i=0;i<j;i++){
            System.out.println(W[i]+" ");
        }
    }

    public static void MergeSort(int A[],int l,int r){
        int m;
        if(l<r){
            m=(l+r)/2;
            MergeSort(A,l,m);
            MergeSort(A,m+1,r);
            Merge(A,l,m,r);
        }
    }

    public static void Merge(int A[],int l,int m,int r){
        int x = m-l+1,y=r-m;
        int i,j,k;
        int[] B = new int[x];
        int[] C = new int[y];
        for(i=0,j=l;i<x;i++,j++){
            B[i]=A[j];
        }
        for(i=0,j=m+1;i<y;i++,j++){
            C[i]=A[j];
        }
        i=0;
        j=0;
        k=l;
        while(i<x&&j<y){
            if(B[i]<=C[j]){
                A[k++]=B[i++];
            }
            else{
                A[k++]=C[j++];
            }
        }
        if(i>=x){
            while(j<y){
                A[k++]=C[j++];
            }
        }
        else{
            while(i<x){
                A[k++]=B[i++];
            }
        }
    }
}
