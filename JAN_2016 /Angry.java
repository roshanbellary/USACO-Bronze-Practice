import java.io.*;
import java.util.*;
public class Angry{
    public static int N;
    public static int[] x;
    public static boolean[] blasted;
    public static class Event{
        int index;
        int blast;
        public Event(int index, int blast){
            this.index=index;
            this.blast=blast;
        }
    }
    public static Queue<Event> queue = new LinkedList<Event>();
    public static void simulate(int pos, int blast){
        int min = pos-blast;
        int max = pos+blast;
        for (int i=0;i<N;i++){
            if ((x[i]>=min)&&(x[i]<=max)&&!blasted[i]){
                blasted[i]=true;
                queue.add(new Event(i,blast+1));
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new FileReader("angry.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        x = new int[N];
        blasted = new boolean[N];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(r.readLine());
            x[i] = Integer.parseInt(st.nextToken());
        }
        r.close();
        Arrays.sort(x);
        int max = 0;
        for (int i=0;i<N;i++){
            int count=0;
            simulate(x[i],1);
            int blast = 2;
            while (queue.size()>0){
                if (queue.peek().blast>blast){
                    blast++;
                }
                Event store = queue.poll();
                simulate(x[store.index],store.blast);
            }
            for (int j=0;j<N;j++){
                if (blasted[j]){
                    count++;
                    blasted[j]=false;
                }
            }
            if (count>max){
                max=count;
            }
        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
        pw.println(max);
        pw.close();
    }
}