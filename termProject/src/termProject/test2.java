package termProject;

import java.util.*;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//������ ���� ������� �ʵ��� �õ尪�� �ο��Ѵ�.
		Random rand = new Random(1);
		
		//n���� �����͸� �������� ����
		int n = sc.nextInt();
		int [] arr = new int [n];
		for(int i=0;i<n;i++) {
			arr[i] = rand.nextInt();
		}

		//k���� ������ �����Ѵ�.
		int k = sc.nextInt();
		int [] s = new int [k];
		int [] e = new int [k];

		for(int i=0;i<k;i++) {
			int a = rand.nextInt(n);
			int b = rand.nextInt(n);
			if(a>b) {
				int tmp = a;
				a = b;
				b = tmp;
			}
			s[i] = a;
			e[i] = b;
		}
		
		for(int i=0;i<k;i++) {
			long min = Integer.MAX_VALUE;
			long max = 0;
			long sum = 0;
			
			int start = s[i];
			int end = e[i];
			for(int j=start;j<=end;j++) {
				if(arr[j]>max)
					max = arr[j];
				if(arr[j]<min)
					min = arr[j];
				
				sum+=arr[j];
			}
			System.out.println(min+" "+max+" "+sum);
		}
	}
}