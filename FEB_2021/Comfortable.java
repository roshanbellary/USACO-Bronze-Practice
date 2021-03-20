import java.io.*;
import java.util.*;
public class Comfortable{
    public static boolean[][] pos = new boolean[1001][1001];
    public static int N;
    public static int[] results;
    public static boolean check(int x, int y){
        if (x>1000||x<0||y<0||y>1000){
            return false;
        }else{
            if (!pos[x][y]){
                return false;
            }
        }
        int num = 0;
        if ((x-1)>=0){
            if (pos[x-1][y]){
                num++;
            }
        }
        if (x+1<=1000){
            if (pos[x+1][y]){
                num++;
            }
        }
        if ((y-1)>=0){
            if (pos[x][y-1]){
                num++;
            }
        }
        if (y+1<=1000){
            if (pos[x][y+1]){
                num++;
            }
        }
        if (num==3){
            return true;
        }
        return false;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(r.readLine());
        results = new int[N];
        int count=0;
        for (int i=0;i<N;i++){
            String[] store = r.readLine().split(" ");
            int posx = Integer.parseInt(store[0]);
            int posy = Integer.parseInt(store[1]);
            int old=0;
            if (Comfortable.check(posx-1,posy)) old++;
            if (Comfortable.check(posx+1,posy)) old++;
            if (Comfortable.check(posx,posy+1)) old++;
            if (Comfortable.check(posx,posy-1)) old++;
            count-=old;
            pos[posx][posy]=true;
            int newc=0;
            if (Comfortable.check(posx-1,posy)) newc++;
            if (Comfortable.check(posx+1,posy)) newc++;
            if (Comfortable.check(posx,posy+1)) newc++;
            if (Comfortable.check(posx,posy-1)) newc++;
            if (Comfortable.check(posx,posy)) newc++;
            count+=newc;
            if (count<0){
                count=0;
            }
            results[i]=count;
        }
        r.close();
        for (int i=0;i<N;i++){
            System.out.println(results[i]);
        }
    }
}