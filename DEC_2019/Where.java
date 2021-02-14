import java.util.*;
import java.io.*;
public class Where {
    public static int N;
    public static void main(String[] args)throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("whereami.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine());
        int mink = N;
        String l = st.nextToken();
        for (int k=0;k<N;k++){
            String[] x = new String[N-k];
            boolean works=true;
            for (int i=0;i<N-k;i++){
                boolean dup=false;
                x[i]=l.substring(i, i+k+1);
                for (int z=0;z<i;z++){
                    if (x[i].equals(x[z])){
                        dup=true;
                        break;
                    }
                }
                if (dup){
                    works=false;
                    break;
                }
            }
            if (works){
                mink=k;
                break;
            }
        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("whereami.out")));
        pw.print(mink+1);
        pw.close();
    }
}
