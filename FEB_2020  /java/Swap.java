import java.io.*;
import java.util.*;
public class Swap {
    public static int N;
    public static int K;
    public static int[] C;
    public static int[] A;
    public static int[] B;
    public static void swap(int i, int j){
        int temp=0;
        if ((j-i+1)%2==0){
                for (int z=i;z<=(j+i-1)/2;z++){
                    temp=C[j-z+i];
                    C[j-z+i]=C[z];
                    C[z]=temp;
                }
        }else{
            for (int z=i;z<(j+i)/2;z++){
                temp = C[j-z+i];
                C[j-z+i]=C[z];
                C[z]=temp;
            }
        }
    }
    public static void simulate(){
        for (int c=0;c<(K%N);c++){
            Swap.swap(A[0],A[1]);
            Swap.swap(B[0],B[1]);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("swap.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = new int[N];
        A=new int[2];
        B=new int[2];
        for (int i=0;i<N;i++){
            C[i]=i;
        }
        st = new StringTokenizer(r.readLine());
        A[0]=Integer.parseInt(st.nextToken())-1;
        A[1]=Integer.parseInt(st.nextToken())-1;
        st = new StringTokenizer(r.readLine());
        B[0]=Integer.parseInt(st.nextToken())-1;
        B[1]=Integer.parseInt(st.nextToken())-1;
        Swap.simulate();
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
        for (int i=0;i<N;i++){
            pw.println(C[i]+1);
        }
        pw.close();
    }
}
