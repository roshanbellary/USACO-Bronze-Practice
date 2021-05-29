import java.util.*;
import java.io.*;
public class TTT {
    public static String[][] c = new String[3][3];
    public static ArrayList<String> i = new ArrayList<String>();
    public static ArrayList<String> t1 = new ArrayList<String>();
    public static ArrayList<String> t2 = new ArrayList<String>();
    public static boolean checki(String[] a){
        String temp="";
        for (int i=0;i<2;i++){
            if (a[i].equals(a[i+1])){
                temp=a[i+1];
            }else{
                return false;
            }
        }
        for (int j=0;j<i.size();j++){
            if (i.get(j).equals(temp)){
                return true;
            }
        }
        i.add(temp);
        return true;
    }
    public static void checkt(String[] a){
        boolean used=false;
        String temp1="";
        String temp2="";
        if (a[0].equals(a[2])){
            used=true;
            temp1=a[0];
            temp2=a[2];
        }
        if (a[2].equals(a[1])){
            used=true;
            temp1=a[1];
            temp2=a[2];
        }
        if (a[0].equals(a[1])){
            used=true;
            temp1=a[0];
            temp2=a[1];
        }
        if (used){
            for (int j=0;j<t1.size();j++){
                if ((t1.get(j).equals(temp1))&&(t2.get(j).equals(temp2))){
                    return;
                }
                else if ((t1.get(j).equals(temp2))&&(t2.get(j).equals(temp1))){
                    return;
                }
            }
            t1.add(temp1);
            t2.add(temp2);
        }else{
            return;
        }
    }
    public static void traverse(){
        for (int i=0;i<3;i++){
            boolean x =TTT.checki(c[i]);
            if (!x){
                TTT.checkt(c[i]);
            }
        }
        for (int i=0;i<3;i++){
            String[] temp = {c[0][i],c[1][i], c[2][i]};
            boolean x = TTT.checki(temp);
            if (!x){
                TTT.checkt(temp);
            }
        }
        String[] temp = {c[0][0],c[1][1],c[2][2]};
        boolean x = TTT.checki(temp);
        if (!x){
            TTT.checkt(temp);
        }
        String[] temp1 = {c[0][2],c[1][1],c[2][0]};
        boolean x1 = TTT.checki(temp);
        if (!x1){
            TTT.checkt(temp);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("tttt.in"));
        for (int i=0;i<3;i++){
            StringTokenizer st = new StringTokenizer(r.readLine());
            String store = st.nextToken();
            for (int j =0;j<3;j++){
                c[i][j]=String.valueOf(store.charAt(j));
            }
        }
        r.close();
        TTT.traverse();
        PrintWriter pw  = new PrintWriter(new BufferedWriter(new FileWriter("tttt.out")));
        pw.println(i.size());
        pw.print(t1.size());
        pw.close();
    }
}
