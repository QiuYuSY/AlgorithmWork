package xsr.eleventhLesson;


public class Huffma {
    static int MAX= 100;
    public static void main(String[] args) {
        int n;
        int arr[] = { 5,5,10,10,10,15,20,25 };
        n = arr.length;
        PtrHuffman pRoot = createHuffmanTree(arr,n);
        System.out.println(("==========各节点的哈夫曼树编码==========\n"));
        HuffmanCoding(pRoot, 0);
        System.out.println();
    }
    public static PtrHuffman createHuffmanTree(int arr[],int n) {
        PtrHuffman[] ptrArr = new PtrHuffman[MAX];
        PtrHuffman ptr, pRoot = null;

        for (int i = 0; i < n; i++) {  //初始化结构体指针数组,数组中每一个元素为一个结构体指针类型
            ptr = new PtrHuffman();
            ptr.data = arr[i];
            ptr.left = ptr.right = null;
            ptrArr[i] = ptr;
        }

        for (int i = 1; i < n; i++) {  //进行 n-1 次循环建立哈夫曼树
            //k1表示森林中具有最小权值的树根结点的下标,k2为次最小的下标
            int k1 = -1, k2 = 0;
            for (int j = 0; j < n; j++) {
                if (ptrArr[j] != null && k1 == -1) {
                    k1 = j;
                    continue;
                }
                if (ptrArr[j] != null) {
                    k2 = j;
                    break;
                }
            }
            //将指针数组中的指针指向的最小值赋值给索引号为k1的,次小值赋值给索引号为k2的
            for (int j = k2; j < n; j++) {
                if (ptrArr[j] != null) {
                    if (ptrArr[j].data < ptrArr[k1].data) {
                        k2 = k1;
                        k1 = j;
                    }
				else if (ptrArr[j].data < ptrArr[k2].data) {
                        k2 = j;
                    }
                }
            }
            //由最小权值树和次最小权值树建立一棵新树,pRoot指向树根结点
            pRoot = new PtrHuffman();
            pRoot.data = ptrArr[k1].data + ptrArr[k2].data;
            pRoot.left = ptrArr[k1];
            pRoot.right = ptrArr[k2];

            ptrArr[k1] = pRoot; //将指向新树的指针赋给ptrArr指针数组中k1位置
            ptrArr[k2] = null; //k2位置为空
        }

        return pRoot;
    }
   static int[] arr = new int[20];

    public static void HuffmanCoding(PtrHuffman ptrTree, int len) {
        if (ptrTree != null) {
            if (ptrTree.left == null && ptrTree.right == null) {
                System.out.println("结点为"+ptrTree.data+"的编码: ");
                for (int i = 0; i < len; i++) {
                    System.out.printf("%d", arr[i]);
                }
                System.out.println();
            }
            else {
                arr[len] = 0;
                HuffmanCoding(ptrTree.left, len + 1);
                arr[len] = 1;
                HuffmanCoding(ptrTree.right, len + 1);
            }
        }
    }
}



class PtrHuffman {
    int  data;  //哈夫曼树中节点的权值
    PtrHuffman left;
    PtrHuffman right;
}



