import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// The part of the program involving reading from STDIN and writing to STDOUT has been provided by us.

public class Solution {
   
	   static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	   static StringBuilder out = new StringBuilder();
	    
	    public static void sort(int arr[]){
			
			int mid=arr.length/2;
			
			if(arr.length<2)	return;
			
			int[] left=new int[mid];
			int[] right=new int[arr.length-mid];
			
			for(int i=0;i<mid;i++)	left[i]=arr[i];
			for(int i=mid;i<arr.length;i++) right[i-mid]=arr[i];
			
			sort(left);
			sort(right);
			merge(left,right,arr);
		}
		
		private static void merge(int left[],int right[],int arr[]){
			int i=0,j=0,k=0;
			
			while(i<left.length && j<right.length){
				if(left[i]<=right[j]){
					arr[k]=left[i];
					i++;
				}
				else{
					arr[k]=right[j];
					j++;
				}
				k++;
			}
			while(i<left.length){
				arr[k]=left[i];
				k++;
				i++;
			}
			while(j<right.length){
				arr[k]=right[j];
				k++;
				j++;
			}
		}

	   public static void main(String[] args) throws NumberFormatException, IOException {
	      int n = Integer.parseInt(in.readLine());
	      int k = Integer.parseInt(in.readLine());
	      int[] p = new int[n];
	      
	      for(int i = 0; i < n; i ++)         p[i] = Integer.parseInt(in.readLine());
	      
	      sort(p);
	      
	      int unfairness = p[k-1]-p[0];
	      
	      if(n>k){
	    	  for(int i=0;i<=(n-k);i++)	if(p[i+k-1]-p[i]<unfairness)	unfairness=p[i+k-1]-p[i];
	      }
	      System.out.println(unfairness);
	   }
}
