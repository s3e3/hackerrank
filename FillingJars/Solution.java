import java.io.*;

public class Solution{
public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        
        String split[]=line.split("\\s+");
        
        int N=Integer.parseInt(split[0]);
        int M=Integer.parseInt(split[1]);
        long sum=0;
        for(int i=0;i<M;i++){
            split=br.readLine().split("\\s+");
            long a=Integer.parseInt(split[0]);
            long b=Integer.parseInt(split[1]);
            long k=Integer.parseInt(split[2]);
            sum+=k*(b-a+1);
        }
        
        System.out.println(sum/N);
    }
}
