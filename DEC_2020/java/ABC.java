import java.util.*;
import java.io.*;
public class ABC {
    public static int[] n = new int[7];
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        for (int i=0;i<7;i++){
            n[i]=in.nextInt();
        }
        Arrays.sort(n);
        int sum = n[6];
        int a = n[0];
        int temp1=0;
        int temp2=0;
        boolean b = false;
        for (int i=1;i<6;i++){
            for (int j=i+1;j<6;j++){
                if (n[i]+n[j]==sum-a){
                    temp1=n[i];
                    temp2=n[j];
                    b=true;
                    break;
                }
            }
            if(b){
                break;
            }
        }
        System.out.print(a+" "+Math.min(temp1,temp2)+" "+Math.max(temp1,temp2));
    }
}
