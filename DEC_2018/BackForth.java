import java.util.*;
import java.io.*;
public class BackForth {
    public static ArrayList<Integer> b1 = new ArrayList<Integer>();
    public static ArrayList<Integer> b2 = new ArrayList<Integer>();
    public static ArrayList<Integer> results = new ArrayList<Integer>();
    public static void simulate(int m, int c1, int c2, ArrayList<Integer> x, ArrayList<Integer> y){
        if (m>=4){
            for (int i=0;i<results.size();i++){
                if (c1==results.get(i)){
                    return;
                }
            }
            results.add(c1);
            return;
        }
        if (m%2==0){
            int size = x.size();
            for (int i=0;i<size;i++){
                int val = x.get(i);
                ArrayList<Integer> store1 = (ArrayList<Integer>)x.clone();
                ArrayList<Integer> store2 = (ArrayList<Integer>)y.clone();
                store2.add(store1.get(i));
                store1.remove(Integer.valueOf(store1.get(i)));
                int n=m+1;
                BackForth.simulate(n, c1-val, c2+val, store1, store2);
            }
        }else{
            int size = y.size();
            for (int i=0;i<size;i++){
                int val = y.get(i);
                ArrayList<Integer> store1 = (ArrayList<Integer>)x.clone();
                ArrayList<Integer> store2 = (ArrayList<Integer>)y.clone();
                store1.add(store2.get(i));
                store2.remove(Integer.valueOf(store2.get(i)));
                int n = m+1;
                BackForth.simulate(n, c1+val, c2-val, store1, store2);
            }
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("backforth.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        for (int i=0;i<10;i++){
            b1.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(r.readLine());
        for (int i=0;i<10;i++){
            b2.add(Integer.parseInt(st.nextToken()));
        }
        BackForth.simulate(0, 1000, 1000, b1, b2);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("backforth.out")));
        pw.print(results.size());
        pw.close();
    }
}
