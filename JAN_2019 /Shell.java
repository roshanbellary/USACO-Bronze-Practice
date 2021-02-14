import java.io.*;
import java.util.*;
public class Shell {
    public static int N;
    public static int max=0;
    public static int[] e;
    public static int[] o;
    public static int[] g;
    public static void simulate(){
        for (int i=1;i<4;i++){
            int j=i;
            int temp=0;
            for (int z=0;z<N;z++){
                if (e[z]==j){
                    j=o[z];
                }else if(o[z]==j){
                    j=e[z];
                }
                if (g[z]==j){
                    temp++;
                }
            }
            if (temp>max){
                System.out.println(i+" "+temp);
                max=temp;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("shell.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        e = new int[N];
        o = new int[N];
        g = new int[N];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(r.readLine());
            e[i]=Integer.parseInt(st.nextToken());
            o[i]=Integer.parseInt(st.nextToken());
            g[i]=Integer.parseInt(st.nextToken());
        }
        r.close();
        Shell.simulate();
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));
        pw.print(max);
        pw.close();
    }
}
