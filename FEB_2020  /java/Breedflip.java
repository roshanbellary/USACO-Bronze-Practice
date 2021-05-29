import java.io.*;
import java.util.*;
public class Breedflip {
    public static int N;
    public static String A;
    public static String B;
    public static int count=0;
    public static boolean check(int i){
        if (String.valueOf(A.charAt(i)).equals(String.valueOf(B.charAt(i)))){
            return true;
        }
        return false;
    }
    public static void traverse(){
        for (int i=0;i<N;i++){
            if (!check(i)){
                for (int j=i+1;j<N;j++){
                    if (!check(j)){
                        continue;
                    }else{
                        i=j;
                        count++;
                        break;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("breedflip.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N=Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine());
        A=st.nextToken();
        st = new StringTokenizer(r.readLine());
        B=st.nextToken();
        r.close();
        Breedflip.traverse();
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("breedflip.out")));
        pw.print(count);
        pw.close();

    }
}
