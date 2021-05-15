package xsr.eighthLesson;

public class eighthLesson {
    private int[][] arr;
    private static int[][] s;
    private int[] p;

    public eighthLesson(int[] p,int[][] arr,int[][] s)
    {
        this.p=p;
        this.arr=arr;
        this.s=s;
    }
    public int[][] matrixChain()
    {
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            arr[i][i]=0;
        }
        for(int r=2;r<=n;r++)
        {
            for(int i=0;i<=arr.length-r;i++)
            {
                int j=i+r-1;
                arr[i][j]=arr[i+1][j]+p[i]*p[i+1]*p[j+1];
                s[i][j]=i;
                for(int k=i+1;k<j;k++)
                {
                    int temp=arr[i][k]+arr[k+1][j]+p[i]*p[k+1]*p[j+1];
                    if(temp<arr[i][j])
                    {
                        arr[i][j]=temp;
                        s[i][j]=k;
                    }
                }
            }
        }
        return s;
    }

    public void show(int[][] s,int start,int end)
    {
        if(start!=end)
        {
            System.out.print("(");
            show(s,start,s[start][end]);
            show(s,s[start][end]+1,end);
            System.out.print(")");
        }
        else
            System.out.print("A"+(start+1));
    }
    public static void main(String[] args)
    {
        int[] p=new int[] {30,35,15,5,10,20,25};
        int[][] arr=new int[6][6];
        int[][] s=new int[6][6];
        eighthLesson el=new eighthLesson(p,arr,s);
        s=el.matrixChain();
        System.out.println("最少乘法计算次数是"+arr[0][5]);
        System.out.println("按照如下格式计算可获得最优解");
        el.show(s,0,5);
    }

}
