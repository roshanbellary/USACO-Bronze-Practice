import java.io.*;
import java.util.*;
public class Promote {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("promote.in"));
        int[] b = new int[4];
        int[] a = new int[4];
        int[] res = new int[3];
        for (int i=0;i<4;i++){
            StringTokenizer st = new StringTokenizer(r.readLine());
            b[i] = Integer.parseInt(st.nextToken());
            a[i] = Integer.parseInt(st.nextToken());
        }
        r.close();
        res[2] = a[3]-b[3];
        res[1] = (a[2]-b[2])+res[2];
        res[0] = (a[1]-b[1])+res[1];
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("promote.out")));
        pw.println(res[0]);
        pw.println(res[1]);
        pw.println(res[2]);
        pw.close();
    }
}
