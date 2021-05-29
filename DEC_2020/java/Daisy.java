import java.util.*;
import java.io.*;
public class Daisy {
    public static int N;
    public static int p[];
    public static int count=0;
    public static void check(int i, int j){
        int sum=0;
        for (int z=i;z<=j;z++){
            sum+=p[z];
        }
        for (int z=i;z<=j;z++){
            if (p[z]*(j-i+1)==sum){
                count++;
                break;
            }
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        p = new int[N];
        for (int i=0;i<N;i++){
            p[i] = in.nextInt();
            count++;
        }
        in.close();
        for (int i=0;i<N;i++){
            for (int j=i+1;j<N;j++){
                check(i,j);
            }
        }
        System.out.print(count);
    }
}
