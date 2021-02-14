import java.io.*;
import java.util.*;
public class Traffic {
    public static int N;
    public static int[] x;
    public static int[] y;
    public static int[] s;
    public static int n1;
    public static int n2;
    public static int a1;
    public static int a2;
    public static int[] union(int i, int j){
        int temp1=x[i];
        int temp2=y[i];
        for (int z=i+1;z<=j;z++){
            if (x[z]>x[i]){
                temp1=x[z];
            }
            if (y[z]<y[i]){
                temp2=y[z];
            }
        }
        int[] temp = {temp1, temp2};
        return temp;
    }
    public static void traverse(){
        int a=0;
        int b=0;
        for (int i=0;i<N;i++){
            if (s[i]==0){
                int temp1=i;
                int k=0;
                for (int j=i+1;j<N;j++){
                    if (s[j]==0){
                        continue;
                    }else{
                        i=j-1;
                        k=j-1;
                        break;
                    }
                }
                int[] temp=Traffic.union(temp1,k);
                if (temp[0]>a){
                    a=temp[0];
                }
                if (temp[1]>b){
                    b=temp[1];
                }
                System.out.println(a+" "+b);
            }else if (s[i]==-1){
                if (y[i]>a){
                    a=0;
                }else{
                    a-=y[i];
                }
                if (x[i]>b){
                    b=0;
                }else{
                    b-=x[i];
                }
            }else{
                a+=x[i];
                b+=y[i];
            }
        }
        n1=a;
        n2=b;
    }
    public static void reverse(){
        int a=0;
        int b=0;
        for (int i=N-1;i>=0;i--){
            if (s[i]==0){
                int temp1=i;
                int k=0;
                for (int j=i-1;j>=0;j--){
                    if (s[j]==0){
                        continue;
                    }else{
                        i=j+1;
                        k=j+1;
                        break;
                    }
                }
                int[] temp=Traffic.union(k,temp1);
                if (temp[0]>a){
                    a=temp[0];
                }
                if (temp[1]>b){
                    b=temp[1];
                }
                System.out.println(a+" "+b);
            }else if (s[i]==-1){
                a+=x[i];
                b+=y[i];
            }else{
                if (y[i]>a){
                    a=0;
                }else{
                    a-=y[i];
                }
                if (x[i]>b){
                    b=0;
                }else{
                    b-=x[i];
                }
            }
        }
        a1=a;
        a2=b;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("/Users/roshanb/Documents/USACO/traffic.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        s = new int[N];
        x = new int[N];
        y = new int[N];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(r.readLine());
            String store = st.nextToken();
            if (store.equals("on")){
                s[i]=1;
                x[i]=Integer.parseInt(st.nextToken());
                y[i]=Integer.parseInt(st.nextToken());
            }else if (store.equals("off")){
                s[i]=-1;
                x[i]=Integer.parseInt(st.nextToken());
                y[i]=Integer.parseInt(st.nextToken());
            }else{
                s[i]=0;
                x[i]=Integer.parseInt(st.nextToken());
                y[i]=Integer.parseInt(st.nextToken());
            }
        }
        r.close();
        Traffic.traverse();
        Traffic.reverse();
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("traffic.out")));
        pw.println(a1+" "+a2);
        pw.println(n1+" "+n2);
        System.out.println(a1+" "+a2);
        System.out.println(n1+" "+n2);
        pw.close();
    }
}
