package xsr.ninthLesson;

public class lcs {
    public static String longest(String s1,String s2){

        char ch1[]=s1.toCharArray();
        char ch2[]=s2.toCharArray();

        int length1=ch1.length;
        int length2=ch2.length;

        int max=0;
        int sign=0;
        int[] mat=new int[length1];

        for(int i=0;i<length2;i++){
            for(int j=length1-1;j>=0;j--){
                if(ch2[i]==ch1[j]){
                    if(i==0 || j==0){
                        mat[j]=1;
                        if(max==0){
                            max=1;
                            sign=j;
                        }
                    }

                    else{
                        mat[j]=mat[j-1]+1;
                        if(mat[j]>max){
                            max=mat[j];
                            sign=j;
                        }
                    }
                }
                else{
                    mat[j]=0;
                }
            }
        }
        return new String(ch1, sign-max+1, max);
    }

    public static void main(String[] args) {
        String s1="erecadhssjdgd";
        String s2="abcadhssjda";

        System.out.println(longest(s1, s2));

    }
}