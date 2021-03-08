import java.io.*;
import java.util.*;
public class Path {
    public static int N;
    public static int turns=0;
    public static boolean[] results;
    public static void check(String a, String b){
        if (a.equals("N")){
            if (b.equals("E")){
                turns++;
            }else if (b.equals("W")){
                turns--;
            }
        }
        if (a.equals("S")){
            if (b.equals("W")){
                turns++;
            }else if (b.equals("E")){
                turns--;
            }
        }
        if (a.equals("E")){
            if (b.equals("N")){
                turns++;
            }else if (b.equals("S")){
                turns--;
            }
        }
        if (a.equals("W")){
            if (b.equals("S")){
                turns++;
            }else if (b.equals("N")){
                turns--;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(r.readLine());
        results = new boolean[N];
        for (int i=0;i<N;i++){
            String store = r.readLine();
            int length = store.length();
            turns=0;
            for (int j=0;j<store.length()-1;j++){
                Path.check(String.valueOf(store.charAt(j)),String.valueOf(store.charAt(j+1)));
            }
            Path.check(String.valueOf(store.charAt(length-1)), String.valueOf(store.charAt(0)));
            if (turns>0){
                results[i]=true;
            }else{
                results[i]=false;
            }
        }
        for (int i=0;i<N;i++){
            if (results[i]){
                System.out.println("CW");
            }else{
                System.out.println("CCW");
            }
        }
    }
}
