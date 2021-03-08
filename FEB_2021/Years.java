import java.io.*;
import java.util.*;
public class Years {
    public static ArrayList<Edge>[] e;
    public static int N;
    public static int difference=0;
    public static String[] years = {"Ox","Tiger","Rabbit","Dragon","Snake","Horse","Goat","Monkey","Rooster","Dog","Pig","Rat"};
    public static boolean[] visited;
    public static class Edge{
        int i,w;
        public Edge(int _i, int _w){
            i=_i;
            w=_w;
        }
    }
    public static class Cow{
        int y;
        String name;
        public Cow(int _y, String _name){
            y=_y;
            name=_name;
        }
    }
    public static void dfs(int start, int finish, boolean[] visited, int diff){
        if (start==finish){
            difference=diff;
            return;
        }
        visited[start]=true;
        for (int i=0;i<e[start].size();i++){
            if (!visited[e[start].get(i).i]){
                Years.dfs(e[start].get(i).i, finish, visited, diff+e[start].get(i).w);
            }
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(r.readLine());
        e = new ArrayList[N+1];
        for (int i=0;i<N+1;i++){
            e[i]=new ArrayList<Edge>();
        }
        ArrayList<Cow> cows = new ArrayList<Cow>();
        cows.add(new Cow(0,"Bessie"));
        for (int i=0;i<N;i++){
            int direction = 0;
            String[] store = r.readLine().split(" ");
            String name1 = store[0];
            String name2 = store[7];
            if (store[3].equals("previous")){
                direction=-1;
            }else{
                direction=1;
            }
            int ind_f = -1;
            int ind_s = -1;
            for (int j=0;j<cows.size();j++){
                if (cows.get(j).name.equals(name1)){
                    ind_f=j;
                }
                if (cows.get(j).name.equals(name2)){
                    ind_s=j;
                }
            }
            int diff = -1;
            for (int j=0;j<12;j++){
                if (years[j].equals(store[4])){
                    diff=j;
                }
            }
            if (ind_f<0){
                cows.add(new Cow(diff, name1));
                ind_f=cows.size()-1;
            }
            if (ind_s<0){
                cows.add(new Cow(diff, name2));
                ind_s=cows.size()-1;
            }
            if (direction>0){
                e[ind_f].add(new Edge(ind_s, -direction*(12-(cows.get(ind_s).y-diff))));
                e[ind_s].add(new Edge(ind_f, direction*(12-(cows.get(ind_s).y-diff)))); 
            }else{
                e[ind_f].add(new Edge(ind_s, -direction*(12+cows.get(ind_s).y-diff)));
                e[ind_s].add(new Edge(ind_f, direction*(12+cows.get(ind_s).y-diff)));
            }
        }
        int ind_b = -1;
        int ind_e=-1;
        for (int i=0;i<N;i++){
            if (cows.get(i).name.equals("Bessie")){
                ind_b=i;
            }
            if (cows.get(i).name.equals("Elsie")){
                ind_e=i;
            }
        }
        visited = new boolean[cows.size()];
        Years.dfs(ind_b, ind_e, visited,0);
        System.out.println(Math.abs(difference));
    }
}
