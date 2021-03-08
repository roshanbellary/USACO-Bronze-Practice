import java.io.*;
import java.util.*;
public class Comfortable{
    public static int N;
    public static Points[] g;
    public static class Points{
        int x,y;
        public Points(int _x, int _y){
            x=_x;
            y=_y;
        }
        public int compareTo(Points n){
            if (x==n.x){
                return Integer.compare(y,n.y);
            }else{
                return Integer.compare(x, n.x);
            }
        }
    }
    public static void count(int i){
        Points[] j = new Points[i+1];
        for (int z=0;z<=i;z++){
            j[z]=g[z];
        }
        Arrays.sort(j);
    }
    public static void main(String[] args)throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(r.readLine());
        g = new Points[N];
        for (int i=0;i<N;i++){
            String[] store = r.readLine().split(" ");
            g[i] = new Points(Integer.parseInt(store[0]),Integer.parseInt(store[1]));
        }
        r.close();
    }
}