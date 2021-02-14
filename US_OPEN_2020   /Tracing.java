import java.io.*;
import java.util.*;
public class Tracing {
    public static int N;
    public static int T;
    public static boolean[] state;
    public static int[] times;
    public static int[] x;
    public static int[] y;
    public static int infected=0;
    public static int min;
    public static int max=0;
    public static int counter=0;
    public static void simulate(int i){
        boolean[] infection = new boolean[N];
        int[] interactions = new int[N];
        boolean possible = false;
        for (int k=1;k<=T;k++){
            for (int j=0;j<N;j++){
                infection[j] = false;
                interactions[j] = 0;
            }
            infection[i]=true;
            for (int t=1;t<=250;t++){
                for (int m=0;m<T;m++){
                    if (times[m]==t){
                        if ((infection[x[m]]==true)&&(infection[y[m]]==true)){
                            interactions[x[m]]++;
                            interactions[y[m]]++;
                        }
                        else if ((infection[x[m]])==true){
                            if (interactions[x[m]]<k){
                                infection[y[m]]=true;
                            }
                            interactions[x[m]]++;
                        }
                        else if ((infection[y[m]])==true){
                            if (interactions[y[m]]<k){
                                infection[x[m]]=true;
                            }
                            interactions[y[m]]++;
                        }
                    }
                }
            }
            boolean works=true;
            for (int z=0;z<N;z++){
                if (infection[z]!=state[z]){
                    works=false;
                }
            }
            if (works){
                possible=true;
                if(k<min){
                    min=k;
                }
                if (k>max){
                    max=k;
                }
            }
        }
        if (possible){
            counter++;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("tracing.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(String.valueOf(st.nextToken()));
        T = Integer.parseInt(String.valueOf(st.nextToken()));
        state = new boolean[N];
        times = new int[T];
        x = new int[T];
        y = new int[T];
        min = T;
        st = new StringTokenizer(r.readLine());
        String states = st.nextToken();
        for (int i=0;i<N;i++){
            if (String.valueOf(states.charAt(i)).equals("1")){
                state[i]=true;
            }else{
                state[i]=false;
            }
        }
        for (int i=0;i<T;i++){
            st = new StringTokenizer(r.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            x[i] = Integer.parseInt(st.nextToken())-1;
            y[i] = Integer.parseInt(st.nextToken())-1;
        }
        r.close();
        for (int i=0;i<N;i++){
            Tracing.simulate(i);
        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("tracing.out")));
        if (max==T){
            pw.print(counter+" "+min+" Infinity");
        }else{
            pw.print(counter+" "+min+" "+max);
        }
        pw.close();
    }
}
