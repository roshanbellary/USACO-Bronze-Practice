import java.util.*;
import java.io.*;
public class Factory {
    public static int N;
    public static int[] a;
    public static int[] b;
    public static boolean[] c;
    public static boolean complete(boolean[] s){
        for (int i=0;i<N;i++){
            if (s[i]==false){
                return false;
            }
        }
        return true;
    }
    public static void check(int j, boolean[] s){
        s[j]=true;
        for (int i=0;i<N-1;i++){
            if (b[i]==j){
                if (s[a[i]]!=true){
                    Factory.check(a[i], s);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("factory.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        a = new int[N-1];
        b = new int[N-1];
        c = new boolean[N];
        for (int i=0;i<N-1;i++){
            st = new StringTokenizer(r.readLine());
            a[i] = Integer.parseInt(st.nextToken())-1;
            b[i] = Integer.parseInt(st.nextToken())-1;
        }
        r.close();
        int index=-1;
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                c[j]=false;
            }
            Factory.check(i, c);
            if (Factory.complete(c)){
                index = i;
                break;
            }
        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("factory.out")));
        pw.print(index+1);
        pw.close();
    }
}
