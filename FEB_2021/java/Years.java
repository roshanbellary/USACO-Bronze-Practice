import java.io.*;
import java.util.*;
public class Years {
    public static int N;
    public static int difference=0;
    public static String[] years = {"Ox","Tiger","Rabbit","Dragon","Snake","Horse","Goat","Monkey","Rooster","Dog","Pig","Rat"};
    public static class Cow{
        int y;
        String name;
        int diff;
        public Cow(int _y, String _name, int diff){
            y=_y;
            name=_name;
            this.diff=diff;
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(r.readLine());
        ArrayList<Cow> cows = new ArrayList<Cow>();
        cows.add(new Cow(0,"Bessie",0));
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
            int index = -1;
            for (int z=0;z<cows.size();z++){
                if (cows.get(z).name.equals(name2)){
                    index=z;
                }
            }
            int diff = -1;
            for (int j=0;j<12;j++){
                if (years[j].equals(store[4])){
                    diff = j;
                }
            }
            if (direction>0){
                cows.add(new Cow(diff, name1, cows.get(index).diff+12+diff-cows.get(index).y));
            }else{
                cows.add(new Cow(diff, name1, cows.get(index).diff-12-cows.get(index).y+diff));
            }
        }
        for (int i=0;i<cows.size();i++){
            if (cows.get(i).name.equals("Elsie")){
                difference=cows.get(i).diff;
            }
        }
        System.out.println(Math.abs(difference));
    }
}
