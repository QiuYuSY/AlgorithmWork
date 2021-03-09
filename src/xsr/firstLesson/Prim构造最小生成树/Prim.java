package xsr.firstLesson.Prim构造最小生成树;


import java.util.Arrays;

public class Prim {
    public static void main(String[] args) {
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verxs = data.length;
        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000}};

        MGraph graph = new MGraph(verxs);
        MinTree minTree = new MinTree();
        minTree.createGraph(graph, verxs, data, weight);

        minTree.showGraph(graph);

        minTree.prim(graph,0);
    }

}

//创建最小生成树
class MinTree {
    /**
     * 创建图的邻接矩阵
     *
     * @param graph  图对象
     * @param verxs  图对应的顶点个数
     * @param data   图的各个顶点的值
     * @param weight 图的邻接矩阵
     */
    public void createGraph(MGraph graph, int verxs, char data[], int[][] weight) {
        int i, j;
        for (i = 0; i < verxs; i++) {//顶点
            graph.data[i] = data[i];
            for (j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    //显示图的邻接矩阵
    public void showGraph(MGraph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    //编写prim算法，得到最小生成树

    /**
     * @param graph 图
     * @param v     表示从图的第几个顶点开始生成
     */
    public void prim(MGraph graph, int v) {
        //visited[] 标记顶点是否被访问过,默认为0
        int visited[] = new int[graph.verxs];
        for (int i = 0; i < graph.verxs; i++) {
            visited[i] = 0;
        }

        //把当前节点设为访问过
        visited[v] = 1;
        //h1,h2 记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000; //将minWeight初始成一个大数，后面在被遍历的过程中被替换
        for (int k = 1; k < graph.verxs; k++) {

            for (int i = 0; i < graph.verxs; i++) {//i结点表示被访问过的结点
                for (int j = 0; j < graph.verxs; j++) {//j结点表示被访问过的结点
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight){
                        //替换minWeight
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }

                }
            }

            System.out.println("边<"+graph.data[h1] + "," + graph.data[h2] + ">权值："+minWeight);
            visited[h2] = 1;
            minWeight = 10000;
        }
    }
}

class MGraph {
    int verxs;//表示顶点个数
    char[] data;//存放节点数据
    int[][] weight;//存放边，邻接矩阵

    public MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}

