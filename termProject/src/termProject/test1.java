package termProject;

import java.util.*;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long [] arr = new long [n+1];
		
		for(int i=1;i<=n;i++) {
			arr[i] = sc.nextInt();
		}
		
		int k = sc.nextInt();
		
		//구간 선택
		
		for(int i=0;i<k;i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			long min = Integer.MAX_VALUE;
			long max = 0;
			long sum = 0;
			
			for(int j=s;j<=e;j++) {
				if(max<arr[j])
					max = arr[j];
				if(min>arr[j])
					min = arr[j];
				
				sum += arr[j];
			}
			System.out.println(min+" "+max+" "+sum);
		}
	}
}
