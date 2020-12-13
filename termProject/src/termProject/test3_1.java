//���׸�Ʈ Ʈ���� �̿��� Ǯ��
package termProject;

import java.util.*;

public class test3_1 {
	static long [] sumTree; //������ ���� ������ �迭
	static long [] maxTree; //������ �ִ밪�� ������ �迭
	static long [] minTree; //������ �ּҰ��� ������ �迭
	static int [] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Random rand = new Random(20);
		
		//1. n���� ���ڸ� �����ϰ� �����Ͽ� �迭�� �����մϴ�.
		int n = sc.nextInt();
		arr = new int [n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		int leng = (int)(Math.pow(n, 2));
		sumTree = new long [n*4];
		maxTree = new long [n*4];
		minTree = new long [n*4];
		
		
		//�������� �������ִ� tree�� �����Ѵ�.
		//0���ε�������, n-1�� �ε�������, �ֻ��� ��带 1��
		initSum(0,n-1,1);
		initMax(0,n-1,1);
		initMin(0,n-1,1);
		
		//2. k���� ������ �������� �����մϴ�.
		int k = sc.nextInt();
		long t = System.currentTimeMillis();
		for(int i=0;i<k;i++) {
			int s = rand.nextInt(n);
			int e = rand.nextInt(n);
			if(s>e) {
				int tmp = s;
				s = e;
				e = tmp;
			}
			System.out.println("�� : "+sum(0,n-1,1,s,e)+" �ִ� : "+max(0,n-1,1,s,e)+"�ּ� : "+min(0,n-1,1,s,e));
		}
	}

	//������ ���� ���ϱ� ���ؼ� ��ü �迭���� �� ������ ���� ���� sumTree �ʱ�ȭ.
	private static long initSum(int start, int end, int node) {
		//�ֻ��� ����̰ų�, �ڽ� ������ �������� ��� ������ ���
		if(start==end)
			return sumTree[node] = arr[start]; //������ ���� �����ϴ� �迭 tree�� �����Ѵ�.
		
		int mid = (start+end)/2;

		//���� node�� �� == ���� ���带 �κκ����� ������ ���ϸ� �ڽ� ������ �������� ���Ѵ�.
		sumTree[node] += initSum(start,mid,node*2);
		sumTree[node] += initSum(mid+1,end,node*2+1);
		return sumTree[node];
	}
	
	//�հ� ���׸�Ʈ Ʈ��
	private static long sum(int start, int end, int node, int left, int right) {
		if(left>end || right<start)
			return 0;
	
		if(left<=start && end<=right) {
			return sumTree[node];
		}
		
		int mid = (start+end)/2;
		return sum(start,mid,node*2,left,right) + sum(mid+1,end,node*2+1,left,right);
	}
	
	//���������� �ִ밪 �ʱ�ȭ
	private static long initMax(int start, int end, int node) {
		if(start==end)
			return maxTree[node] = arr[start];
		int mid = (start+end)/2;

		return maxTree[node] = Math.max(initMax(start,mid,node*2), initMax(mid+1,end,node*2+1));
	}
	
	//�ִ밪 ���׸�Ʈ Ʈ�� �˻�
	private static long max(int start, int end, int node, int left, int right) {
		//���� ������ ���� ���
		if(left>end || right<start)
			return 0;
		
		//�����ȿ� ���� ��쿡�� �ִ밪�� �̾��ָ��
		if(left<=start && end<=right) {
			return maxTree[node];
		}
		
		int mid = (start+end)/2;
		return Math.max(max(start,mid,node*2,left,right),max(mid+1,end,node*2+1,left,right));
	}
	
	//���������� �ּҰ� �ʱ�ȭ
	private static long initMin(int start, int end, int node) {
		//�ֻ��� ����̰ų�, �ڽ� ������ �������� ��� ������ ���
		if(start==end)
			return minTree[node] = arr[start]; //������ ���� �����ϴ� �迭 tree�� �����Ѵ�.
		
		int mid = (start+end)/2;

		//�ּҰ��� �ش��ϴ� ���� ���ʿ��� �� �������� ã�Ƽ� �ִ´�.
		return minTree[node] = Math.min(initMin(start,mid,node*2), initMin(mid+1,end,node*2+1));
	}
	
	//�ּҰ� ���׸�ƮƮ�� ã��
	private static long min(int start, int end, int node, int left, int right) {
		if(left>end || right<start)
			return Integer.MAX_VALUE;
	
		if(left<=start && end<=right) {
			return minTree[node];
		}
		
		int mid = (start+end)/2;
		return Math.min(min(start,mid,node*2,left,right),min(mid+1,end,node*2+1,left,right));
	}
}

