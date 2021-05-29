import java.io.*;
import java.util.*;
public class Photos {
    public static int N;
    public static int odds=0;
    public static int evens=0;
    public static boolean check(int g){
        if (g%2==0){
            int ge=g/2;
            int go=g/2;
            if ((evens<ge)&&(odds<go)){
                return false;
            }else if (evens<ge){
                if ((odds-go)%2==1){
                    return false;
                }
                if ((ge-evens)*2>(odds-go)){
                    return false;
                }else{
                    return true;
                }
            }else if (odds<go){
                return false;
            }else{
                if ((odds-go)%2==1){
                    return false;
                }else{
                    return true;
                }
            }

        }else{
            int ge=g/2+1;
            int go=g/2;
            if ((evens<ge)&&(odds<go)){
                return false;
            }else if (evens<ge){
                if ((odds-go)%2==1){
                    return false;
                }
                if ((ge-evens)*2>(odds-go)){
                    return false;
                }else{
                    return true;
                }
            }else if (odds<go){
                return false;
            }else{
                if ((odds-go)%2==1){
                    return false;
                }else{
                    return true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(r.readLine());
        String s = r.readLine();
        String[] n = s.split(" ");
        for (int i=0;i<N;i++){
            if (Integer.parseInt(n[i])%2==0){
                evens++;
            }else{
                odds++;
            }
        }
        int temp=-1;
        for (int i=N;i>=1;i--){
            if (Photos.check(i)){
                temp=i;
                break;
            }
        }
        System.out.println(temp);

    }
}
