import java.io.*;
import java.util.*;
public class NotLast {
    public static int N;
    public static String[] names = {"Bessie", "Elsie", "Daisy", "Gertie", "Annabelle", "Maggie", "Henrietta"}
    public static int[] x = {0,0,0,0,0,0,0};
    public static void sort(){
        for (int i=N-1;i>=0;i--){
            for (int j=0;j<i;j++){
                if (x[i]<x[j]){
                    int temp = x[j];
                    String temp1 = names[j];
                    for (int z=j;z<=i;z++){
                        int temp2=x[z+1];
                        String temp3=names[z+1];
                        x[z+1]=temp;
                        names[z+1]=temp1;
                        temp=temp2;
                        temp1=temp3;
                    }
                    x[j]=temp;
                    names[j]=temp1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("/Users/roshanb/Documents/USACO/notlast.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        for (int i=0;i<N;i++){
            st = new StringTokenizer(r.readLine());
            String s = st.nextToken();
            for (int j=0;j<7;j++){
                if (names[j].equals(s)){
                    x[j]+=Integer.parseInt(st.nextToken());
                }
            }
        }
        r.close();
        NotLast.sort();
        int temp=x[0];
        int temp2=1;
        boolean e = true;
        for (int i=1;i<7;i++){
            if (x[i]==x[0]){
                continue;
            }else{
                e=false;
                temp2=i;
                break;
            }
        }
        if (e){
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("notlast.out")));
            pw.print("Tie");
            System.out.print("Tie");
            pw.close();
        }
        else{
            temp=x[temp2];
            for (int i=temp2+1;i<7;i++){
                if (x[i]==temp){
                    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("notlast.out")));
                    pw.print("Tie");
                    System.out.print("Tie");
                    pw.close();
                    break;
                }else if (x[i]>temp){
                    break;
                }
            }
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("notlast.out")));
            pw.print(names[temp2]);
            System.out.print(names[temp2]);
            pw.close();
        }
    }
}
