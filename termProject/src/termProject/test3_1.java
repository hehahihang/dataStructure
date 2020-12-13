//세그먼트 트리를 이용한 풀이
package termProject;

import java.util.*;

public class test3_1 {
	static long [] sumTree; //구간의 합을 저장할 배열
	static long [] maxTree; //구간의 최대값을 저장할 배열
	static long [] minTree; //구간의 최소값을 저장할 배열
	static int [] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Random rand = new Random(20);
		
		//1. n개의 숫자를 랜덤하게 생성하여 배열에 저장합니다.
		int n = sc.nextInt();
		arr = new int [n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		int leng = (int)(Math.pow(n, 2));
		sumTree = new long [n*4];
		maxTree = new long [n*4];
		minTree = new long [n*4];
		
		
		//구간합을 가지고있는 tree를 생성한다.
		//0번인덱스부터, n-1번 인덱스까지, 최상위 노드를 1로
		initSum(0,n-1,1);
		initMax(0,n-1,1);
		initMin(0,n-1,1);
		
		//2. k개의 구간을 랜덤으로 생성합니다.
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
			System.out.println("합 : "+sum(0,n-1,1,s,e)+" 최대 : "+max(0,n-1,1,s,e)+"최소 : "+min(0,n-1,1,s,e));
		}
	}

	//구간의 합을 구하기 위해서 전체 배열에서 각 구간의 합을 담은 sumTree 초기화.
	private static long initSum(int start, int end, int node) {
		//최상위 노드이거나, 자식 노드들의 구간합이 모두 정해진 경우
		if(start==end)
			return sumTree[node] = arr[start]; //구간의 합을 저장하는 배열 tree에 저장한다.
		
		int mid = (start+end)/2;

		//현재 node의 값 == 하위 노드드를 두부분으로 나누어 더하며 자식 노드들의 구간합을 구한다.
		sumTree[node] += initSum(start,mid,node*2);
		sumTree[node] += initSum(mid+1,end,node*2+1);
		return sumTree[node];
	}
	
	//합계 세그먼트 트리
	private static long sum(int start, int end, int node, int left, int right) {
		if(left>end || right<start)
			return 0;
	
		if(left<=start && end<=right) {
			return sumTree[node];
		}
		
		int mid = (start+end)/2;
		return sum(start,mid,node*2,left,right) + sum(mid+1,end,node*2+1,left,right);
	}
	
	//구간에서의 최대값 초기화
	private static long initMax(int start, int end, int node) {
		if(start==end)
			return maxTree[node] = arr[start];
		int mid = (start+end)/2;

		return maxTree[node] = Math.max(initMax(start,mid,node*2), initMax(mid+1,end,node*2+1));
	}
	
	//최대값 세그먼트 트리 검색
	private static long max(int start, int end, int node, int left, int right) {
		//구간 밖으로 나간 경우
		if(left>end || right<start)
			return 0;
		
		//구간안에 들어온 경우에는 최대값을 뽑아주면됌
		if(left<=start && end<=right) {
			return maxTree[node];
		}
		
		int mid = (start+end)/2;
		return Math.max(max(start,mid,node*2,left,right),max(mid+1,end,node*2+1,left,right));
	}
	
	//구간에서의 최소값 초기화
	private static long initMin(int start, int end, int node) {
		//최상위 노드이거나, 자식 노드들의 구간합이 모두 정해진 경우
		if(start==end)
			return minTree[node] = arr[start]; //구간의 합을 저장하는 배열 tree에 저장한다.
		
		int mid = (start+end)/2;

		//최소값에 해당하는 노드는 양쪽에서 더 작은것을 찾아서 넣는다.
		return minTree[node] = Math.min(initMin(start,mid,node*2), initMin(mid+1,end,node*2+1));
	}
	
	//최소값 세그먼트트리 찾기
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

