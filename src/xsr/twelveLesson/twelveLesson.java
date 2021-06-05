package xsr.twelveLesson;

import java.util.Scanner;

public class twelveLesson {
    static int n,m;//顶点数，可用颜色数
    static int[][] a = new int[100][100];//存储图的邻接矩阵
    static int[] x = new int[100];//当前解
    static int sum=0;//找到的找色方案

    public static void main(String[] args) {
        input();
        color();
        while(true){
            if (sum>0){
                System.out.printf("着色方案数为：%d\n", sum);
            }else{
                System.out.println("NO");
                break;
            }
        }

    }
    public static void input(){
        System.out.println("输入顶点数n和着色数m:");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        System.out.println("输入无向图的邻接矩阵:");
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++)
                a[i][j] = scanner.nextInt();
            System.out.println();
        }

    }
    public static int ok(int k){
        for(int j=1;j<=n;j++)
            if(a[k][j] == 1 && (x[j]==x[k]))return 0;
        return 1;
    }
    public static void backtrack(int t){
        if(t>n)
        {
            sum++;
        }
        else
            for(int i=1;i<=m;i++)
            {
                x[t]=i;
                if(ok(t)==1)backtrack(t+1);
                x[t]=0;
            }
    }

    public static int color()
    {
        sum=0;
        backtrack(1);
        return sum;
    }



}

