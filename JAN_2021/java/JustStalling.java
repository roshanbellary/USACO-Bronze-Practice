import java.io.*;
import java.util.*;
public class JustStalling {
    public static int N;
    public static int[] a;
    public static int[] b;
    public static long count=1;
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(r.readLine());
        a = new int[N];
        b = new int[N];
        String s = r.readLine();
        String[] s1 = s.split(" ");
        for (int i=0;i<N;i++){
            a[i]=Integer.parseInt(s1[i]);
        }
        String s2 = r.readLine();
        String[] s3 = s2.split(" ");
        for (int i=0;i<N;i++){
            b[i] = Integer.parseInt(s3[i]);
        }
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i=0;i<N;i++){
            int temp=0;
            for (int j=0;j<=i;j++){
                if (b[j]>=a[i]){
                    temp=j;
                    break;
                }
            }
            count*=(i-temp+1);

        }
        System.out.print(count);
    }
}
