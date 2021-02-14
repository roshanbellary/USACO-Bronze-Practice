import java.io.*;
import java.util.*;
class Herding{
    public static int[] v = new int[3];
    public static int min;
    public static int max;
    public static void traverse(){
        if ((v[1]==v[0]+1)&&(v[2]==v[1]+1)){
            min=0;
        }else if ((v[1]==v[0]+2)||(v[2]==v[1]+2)){
            min=1;
        }else{
            min=2;
        }
        if ((v[2]-v[1])<(v[1]-v[0])){
            max = (v[1]-v[0])-1;
        }else{
            max = (v[2]-v[1])-1;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r  = new BufferedReader(new FileReader("herding.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        for (int i=0;i<3;i++){
            v[i]=Integer.parseInt(st.nextToken());
        }
        r.close();
        Arrays.sort(v);
        Herding.traverse();
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
        pw.println(min);
        pw.print(max);
        pw.close();
    }
}