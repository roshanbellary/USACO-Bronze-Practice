import java.util.*;
import java.io.*;
public class Paint {
    public static int a;
    public static int b;
    public static int c;
    public static int d;
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("paint.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        r.close();
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("paint.out")));
        if ((Math.min(a,d)==d)||(Math.max(b,c)==c)){
            pw.print((b-c)+(d-a));
            pw.close();
        }else{
            pw.print(Math.max(b,d)-Math.min(a,c));
            pw.close();
        }
    }
}
