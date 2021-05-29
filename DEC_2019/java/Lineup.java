// implements the heap algorithm which gives all possible permutations
import java.io.*;
import java.util.*;
public class Lineup {
    public static int N;
    public static String[] n = {"Sue", "Buttercup", "Blue", "Betsy", "Bessie", "Bella", "Belinda","Beatrice"};
    public static String[] x;
    public static String[] y; 
    public static String min="";
    public static int count=0;
    public static int find(String[] a, String s){
        for (int i=0;i<8;i++){
            if (a[i].equals(s)){
                return i;
            }
        }
        return -1;
    }
    public static void check(String[] a){
        boolean z = true;
        for (int i=0;i<N;i++){
            if (Math.abs(Lineup.find(a, x[i])-Lineup.find(a, y[i]))!=1){
                z = false;
            }
        }
        if (z){
            String temp="";
            for (int i=0;i<8;i++){
                temp+=a[i];
            }
            if (temp.compareTo(min)<0){
                min = temp;
                for (int i=0;i<8;i++){
                    n[i]=a[i];
                }
            }
        }
    }
    public static void heap(String[] a, int n){
        if (n==1){
            Lineup.check(a);
            return;
        }else{
            for (int i=0;i<n;i++){
                heap(a,n-1);
                if (n%2==1){
                    String temp=a[0];
                    a[0]=a[n-1];
                    a[n-1]=temp;
                }else{
                    String temp=a[i];
                    a[i]=a[n-1];
                    a[n-1]=temp;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("/Users/roshanb/Documents/USACO/lineup.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        x = new String[N];
        y = new String[N];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(r.readLine());
            x[i] = st.nextToken();
            st.nextToken();
            st.nextToken();
            st.nextToken();
            st.nextToken();
            y[i] = st.nextToken();
        }
        r.close();
        for (int i=0;i<8;i++){
            min=min+n[i];
        }
        Lineup.heap(n.clone(), 8);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));
        for (int i=0;i<8;i++){
            pw.println(n[i]);
        }
        pw.close();
    }
}
