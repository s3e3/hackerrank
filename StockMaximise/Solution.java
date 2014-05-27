import java.io.*;

public class Solution{
    
    private static int MaxIndex(long a[],int k){
			
			for(int i=k+1;i<a.length;i++) if(a[i]>a[k]){
				//System.err.println("input ind: "+k+"Index found:" + i);
				return i;
			}
			//System.err.println("Index not found");
			return -1;
		}
    
    public static long GetAnswer(long a[]){
       long p=0,s=0;
			int q=-1;
			int flag=0;
			for(int i=0;i<a.length-1;i++){
				if(q==i)	flag=0;
				
				if(a[i+1]>a[i]){
					p-=a[i];	
					s++;
					if((i+1)==a.length-1){
						p+=s*a[i+1];
						s=0;
					}
				}
				else if(a[i+1]<=a[i]){
					if(flag==0){	q=MaxIndex(a,i);	if(q>i) flag=1;	}
					if(flag==1){
						p-=a[i];	s++;
					}
					if(flag==0 && s>0){
						p+=s*a[i];
						s=0;
					}
				}
				//System.out.println(a[i]+" p: "+p+" s: "+s);
			}
			return p;
    }
    public static void main(String args[]) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        int T=Integer.parseInt(br.readLine());
        
        for(int i=0;i<T;i++){
            int N=Integer.parseInt(br.readLine());
            String[] split=br.readLine().split("\\s+");
            long[] a=new long[N];
            for(int j=0;j<N;j++) a[j]=Integer.parseInt(split[j]);
            
            System.out.println(GetAnswer(a));
        }
    }
}
