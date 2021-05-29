import java.util.*;
import java.io.*;

import java.io.*;
public class Rutting {
    public static int N;
    public static boolean[] d;
    public static int[] x;
    public static int[] y;
    public static ArrayList<Integer> a1 = new ArrayList<Integer>();
    public static ArrayList<Integer> b1 = new ArrayList<Integer>();
    public static ArrayList<Integer> t1 = new ArrayList<Integer>();
    public static int[] a;
    public static int[] b;
    public static int[] t;
    public static int[] ruts;
    public static int max;
    public static void simulate(int i, int j){
        if (d[i]==d[j]){
            if (d[i]){
                if (y[i]!=y[j]){
                    return;
                }
                if (x[i]>x[j]){
                    a1.add(j);
                    b1.add(i);
                    t1.add(x[i]-x[j]);
                }else{
                    a1.add(i);
                    b1.add(j);
                    t1.add(x[j]-x[i]);
                }
            }else{
                if (x[i]!=x[j]){
                    return;
                }
                if (y[i]>y[j]){
                    a1.add(j);
                    b1.add(i);
                    t1.add(y[i]-y[j]);
                }else{
                    a1.add(j);
                    b1.add(i);
                    t1.add(y[j]-y[i]);
                }
            }
        }
        if ((d[i]==true)&&(d[j]==false)){
            if ((x[j]<x[i])||(y[i]<y[j])){
            }else if ((x[j]-x[i])>(y[i]-y[j])){
                a1.add(i);
                b1.add(j);
                t1.add(x[j]-x[i]);
            }else if ((x[j]-x[i])<(y[i]-y[j])){
                a1.add(j);
                b1.add(i);
                t1.add(y[i]-y[j]);
            }
        }
        if ((d[i]==false)&&(d[j]==true)){
            if ((x[i]<x[j])||(y[j]<y[i])){
            }else if ((x[i]-x[j])>(y[j]-y[i])){
                a1.add(j);
                b1.add(i);
                t1.add(x[i]-x[j]);
            }else if ((x[i]-x[j])<(y[j]-y[i])){
                a1.add(i);
                b1.add(j);
                t1.add(y[j]-y[i]);
            }
        }
    }
    public static void convert(){
        a = new int[t1.size()];
        b = new int[t1.size()];
        t = new int[t1.size()];
        for (int i=0;i<t1.size();i++){
            a[i]=a1.get(i);
            b[i]=b1.get(i);
            t[i]=t1.get(i);
        }
    }
    public static void find_max(){
        for (int i=0;i<t.length;i++){
            if (t[i]>max){
                max=t[i];
            }
        }
    }
    public static void sort(){
        for (int i=0;i<t.length;i++){
            for (int j=0;j<i;j++){
                if (t[i]<t[j]){
                    int temp1=t[j];
                    int temp3=a[j];
                    int temp5=b[j];
                    for (int z=j;z<i;z++){
                        int temp2=t[z+1];
                        t[z+1]=temp1;
                        temp1=temp2;
                        int temp4=a[z+1];
                        a[z+1]=temp3;
                        temp3=temp4;
                        int temp6=b[z+1];
                        b[z+1]=temp5;
                        temp5=temp6;
                    }
                    t[j]=temp1;
                    a[j]=temp3;
                    b[j]=temp5;
                    break;
                }
            }
        }
    }
    public static void simulation(){
        int[] times = new int[N];
        for (int i=0;i<N;i++){
            times[i]=Integer.MAX_VALUE;
        }
        for (int i=0;i<t.length;i++){
            if ((times[a[i]]==Integer.MAX_VALUE)&&(times[b[i]]==Integer.MAX_VALUE)){
                times[a[i]]=t[i];
            }
        }
        ruts=times;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(r.readLine());
        d = new boolean[N];
        x = new int[N];
        y = new int[N];
        ruts = new int[N];
        for (int i=0;i<N;i++){
            String[] line = r.readLine().split(" ");
            if (line[0].equals("E")){
                d[i]=true;
                x[i]= Integer.parseInt(line[1]);
                y[i]=Integer.parseInt(line[2]);
            }else{
                d[i]=false;
                x[i]= Integer.parseInt(line[1]);
                y[i]=Integer.parseInt(line[2]);
            }
        }
        for (int i=0;i<N;i++){
            ruts[i]=Integer.MAX_VALUE;
        }
        for (int i=0;i<N;i++){
            for (int j=i+1;j<N;j++){
                Rutting.simulate(i,j);
            }
        }
        Rutting.convert();
        Rutting.find_max();
        Rutting.sort();
        Rutting.simulation();
        for (int i=0;i<N;i++){
            if (ruts[i]==Integer.MAX_VALUE){
                System.out.println("Infinity");
            }else{
                System.out.println(ruts[i]);
            }
        }
    }
}
