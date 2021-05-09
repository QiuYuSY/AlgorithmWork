package xsr.seventhLesson;

public class MaxProfit {
    static int M = 5;
    static int N = 6;
    public static void main(String[] args) {
        int[][] dp = new int[M][N];
        int[][] f = {{0, 0, 0, 0, 0, 0},
                    {0, 11, 12, 13, 14, 15},
                    {0, 0, 5, 10, 15, 20},
                    {0, 2, 10, 30, 32, 40},
                    {0, 20, 21, 22, 23, 24}
                    };


        System.out.println("最大利益："+maxprofit(dp,f,5,4));
    }

    public static int maxprofit(int dp[][],int f[][],int money,int number){
        for (int i=1;i<=number;i++)
        {
            for (int j=0;j<=money;j++)
            {
                dp[i][j]=0;
                for (int k=0;k<=j;k++)
                {
                    if (dp[i][j]<f[i][k]+dp[i-1][j-k])
                        dp[i][j]=f[i][k]+dp[i-1][j-k];
                }
            }
        }
        return dp[number][money];
    }
}
