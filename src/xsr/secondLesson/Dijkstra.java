package xsr.secondLesson;

public class Dijkstra {
    private static final int INF = 10000;

    public static void main(String[] args) {
        int[][] matrix = {
                //a,b,c,d,e,f,g,h
                {0,1,INF,INF,INF,INF,INF,INF},
                {INF,0,INF,2,INF,INF,INF,INF},
                {2,INF,0,INF,INF,INF,INF,INF},
                {INF,INF,1,0,INF,8,INF,INF},
                {INF,INF,INF,2,0,INF,2,INF},
                {INF,INF,INF,INF,2,0,INF,INF},
                {INF,INF,INF,INF,INF,3,0,3},
                {INF,INF,INF,INF,INF,2,INF,0},
        };

        int[] dis = {0,1,INF,INF,INF,INF,INF,INF};
        for (int k = 0; k < matrix.length; k++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (dis[i] > dis[j] + matrix[j][i] ){
                        dis[i] = dis[j] + matrix[j][i];
                    }

                }
            }
        }

        for (int i = 0; i < dis.length; i++) {
            System.out.print(dis[i]+"    ");
        }
    }
}
