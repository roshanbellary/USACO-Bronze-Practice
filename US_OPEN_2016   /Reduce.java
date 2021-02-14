import java.io.*;
import java.util.*;
public class Reduce {
    public static int N;
    public static int[] x;
    public static int[] y;
    public static int min=Integer.MAX_VALUE;
    public static void simulate(int i){
        int minx=40000;
        int miny=40000;
        int maxx=0;
        int maxy=0;
        for (int j=0;j<N;j++){
            if (j==i){

            }else{
                if (x[j]>maxx){
                    maxx=x[j];
                }
                if (x[j]<minx){
                    minx=x[j];
                }
                if (y[j]>maxy){
                    maxy=y[j];
                }
                if (y[j]<miny){
                    miny=y[j];
                }
            }
        }
        if (min>(maxx-minx)*(maxy-miny)){
            min=(maxx-minx)*(maxy-miny);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("reduce.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        x = new int[N];
        y = new int[N];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(r.readLine());
            x[i]=Integer.parseInt(st.nextToken());
            y[i]=Integer.parseInt(st.nextToken());
        }
        for (int i=0;i<N;i++){
            Reduce.simulate(i);
        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("reduce.out")));
        pw.print(min);
        pw.close();

    }
}
