import java.util.*;
import java.io.*;
public class BadMilk {
    public static int N;
    public static int D;
    public static int M;
    public static int S;
    public static int[] p;
    public static int[] m;
    public static int[] dt;
    public static int[] s;
    public static int[] ts;
    public static int max=0;
    public static int check(int i){
        int t=0;
        boolean[] in = new boolean[N];
        while (t<=Math.max(dt[D-1], ts[S-1])){
            for (int j=0;j<S;j++){
                if (ts[j]==t){
                    if (in[s[j]-1]==false){
                        return -1;
                    }
                }
            }
            for (int j=0;j<D;j++){
                if (dt[j]==t){
                    if (m[j]==i){// if the touched milk is contaminated 
                        in[p[j]-1]=true;//then set 
                    }
                }
            }
            t++;
        }
        int count=0;
        for (int k=0;k<N;k++){;
            if (in[k]==true){
                count++;
            }
        }
        return count;
    }
    public static void simulate(){
        for (int i=1;i<=M;i++){
            int store=BadMilk.check(i);
            if (store>=0){
                if (max<store){
                    max=store;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("badmilk.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        p = new int[D];
        m = new int[D];
        dt = new int[D];
        s = new int[S];
        ts = new int[S];
        for (int i=0;i<D;i++){
            st = new StringTokenizer(r.readLine());
            p[i]=Integer.parseInt(st.nextToken());
            m[i]=Integer.parseInt(st.nextToken());
            dt[i]=Integer.parseInt(st.nextToken());
        }
        for (int i=0;i<S;i++){
            st = new StringTokenizer(r.readLine());
            s[i]=Integer.parseInt(st.nextToken());
            ts[i]=Integer.parseInt(st.nextToken());
        }
        BadMilk.simulate();
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("badmilk.out")));
        pw.print(max);
        pw.close();
    }
}
