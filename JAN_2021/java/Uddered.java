import java.io.*;
import java.util.*;
public class Uddered {
    public static String a;
    public static String h;
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        a = r.readLine();
        h = r.readLine();
        r.close();
        int l = h.length();
        int temp=-1;
        int count=0;
        for (int i=0;i<l;i++){
            if (a.indexOf(String.valueOf(h.charAt(i)))>temp){
                temp = a.indexOf(String.valueOf(h.charAt(i)));
            }else{
                temp = a.indexOf(String.valueOf(h.charAt(i)));
                count++;
            }
        }
        count++;
        System.out.println(count);
    }
}
