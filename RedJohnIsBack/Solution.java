import java.io.*;

public class Solution{
    
    private static int GetAnswer(int n){
        
        return Primes(Bricks(n));
    }
    
    public static int Bricks(int N){
			if(N<=3)	return 1;
			
			int[] p=new int[N+1];
			p[0]=0;
			p[1]=p[2]=p[3]=1;
			p[4]=2;
			for(int i=5;i<=N;i++) p[i]=p[i-1]+p[i-4];
			
			return p[N];
	}
    
    public static int Primes(int n){
        if(n<2) return 0;
        
        int p[]=new int[n+1];
        
        for(int i=2;i<=n;i++){
            if(p[i]==0){
                int j=i*2;
                while(j<=n){
                    p[j]=1;
                    j+=i;
                }
            }
        }
        
        int ans=0;
        for(int i=2;i<=n;i++) if(p[i]==0) ans++;
        
        return ans;
    }
    public static void main(String args[]) throws Exception{
        BufferedReader br=new BufferedReader(new  InputStreamReader(System.in));
        String line=br.readLine();
        
        int T=Integer.parseInt(line);
        
        for(int i=0;i<T;i++){
            System.out.println(GetAnswer(Integer.parseInt(br.readLine())));
        }
    }
}
