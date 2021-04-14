package xsr.fifthLesson;

import java.util.Arrays;
import java.util.Comparator;

public class ClosestDistance {
    static Points point = new Points();
    public static void main(String[] args) {
        Node[] a = new Node[10];
        createPoint(a);
        Node[] b = a.clone();
        Arrays.sort( a , new cmp1() );
        Arrays.sort( b , new cmp2() );
        double dis = closestDis(0,9,a,b,point);
        System.out.println("最近点对：");
        System.out.println("( "+point.x1+" , "+point.y1+" ),"+"( "+point.x2+" , "+point.y2+" )");
        System.out.println("最近距离："+dis);
    }
    public static void createPoint(Node[] a) {
        for(int i=0;i<10;i++)
        {
            a[i] = new Node();
            a[i].x = 10*Math.random();
            a[i].y = 10*Math.random();
            for(int j=0;j<i;j++) {
                if( a[j].x==a[i].x && a[j].y==a[i].y ) {
                    i--;
                    break;
                }
            }
        }
    }

    public static double closestDis(int left, int right, Node[] a, Node[] b,Points p){
        if(right-left==0)
            return Double.MAX_VALUE;
        else if(right-left==1) {
            p.x1 = a[left].x;
            p.x2 = a[right].x;
            p.y1 = a[left].y;
            p.y2 = a[right].y;
            return distance(left,right,a);
        }
        else {
            int mid = (left + right) / 2;
            Points c = new Points();
            Points d = new Points();

            double min1 = closestDis(left, mid, a, b, c);
            double min2 = closestDis(mid + 1, right, a, b, d);
            double mint;

            if (min1 < min2) {
                p.x1 = c.x1;
                p.x2 = c.x2;
                p.y1 = c.y1;
                p.y2 = c.y2;
                mint = min1;
            } else {
                p.x1 = d.x1;
                p.x2 = d.x2;
                p.y1 = d.y1;
                p.y2 = d.y2;
                mint = min2;
            }

            double x = a[mid].x;
            int k = 0;
            Node[] K = new Node[10];
            for (int i = 0; i < 10; i++) {
                if (mint >= Math.abs(b[i].x - x)) {
                    K[k] = new Node();
                    K[k].x = b[i].x;
                    K[k].y = b[i].y;
                    k++;
                }
            }
            for (int i = 0; i < (k - 1); i++) {
                int temp = Math.min((i + 7), k);
                for (int j = i + 1; j < temp; j++) {
                    if (distance(i, j, K) < mint) {
                        mint = distance(i, j, K);
                        p.x1 = K[i].x;
                        p.x2 = K[j].x;
                        p.y1 = K[i].y;
                        p.y2 = K[j].y;
                    }
                }
            }
            return mint;
        }
    }
    public static double distance(int i,int j,Node[] a) {  //计算距离
        double n = Math.pow(a[i].y-a[j].y, 2);
        double m = Math.pow(a[i].x-a[j].x, 2);
        double w = Math.sqrt(m+n);
        return w;
    }
}
class Node{
    public double x = 0;
    public double y = 0;
}
class Points{
    public double x1;
    public double y1;
    public double x2;
    public double y2;
}
class cmp1 implements Comparator<Node> {
    public int compare(Node a,Node b){
        if( a.x < b.x)
            return -1;
        else if(a.x >b.x)
            return 1;
        else return 0;
    }
}
class cmp2 implements Comparator<Node> {
    public int compare(Node a, Node b) {
        if (a.y < b.y)
            return -1;
        else if (a.y > b.y)
            return 1;
        else return 0;
    }
}