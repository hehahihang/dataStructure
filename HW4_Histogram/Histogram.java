import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Histogram {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //가로의 칸수
		int [] arr = new int [n]; //각 직사각형의 높이
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		//결과
		int result = histo(arr,n);
		System.out.println(result);
	}
	
	public static int histo(int [] arr,int n) {
		return histogram(arr,0,n-1);
	}
	
	public static int histogram(int [] arr,int left, int right) {
		//인덱스 값이 같다면, 하나의 직사각형만 존재하는 것이므로 해당 직사각형의 높이를 return (너비는 1으로 고정이기 때문)
		if(left==right) {
			return arr[left];
		}
		
		//아니라면, 중앙값 :mid를 설정하고 분할정복
		int mid = (left+right)/2;
		
		//계속 양쪽으로 나눠서 양쪽에서 더 큰 넓이를 반환한다.
		int maxLeft = histogram(arr,left,mid);
		int maxRight = histogram(arr,mid+1,right);
		int answer = Math.max(maxLeft, maxRight); //각각의 높은 넓이를 먼저 구한다.
		
		int l = mid;
		int r = mid+1;
		int height = Math.min(arr[l], arr[r]); //높이가 더 작은걸 찾고 그쪽을 높이로 하여 확장
		answer = Math.max(answer, height*2); //mid를 기준으로 너비가 겹치는 
		
		//인덱스 범위를 벗어나기 전까지만 계속 l을 감소시키거나 r을 증가시킨다.
		while(left<l || right>r) {
			//둘다 만족한다면
			//직사각형의 높이 중 더 큰쪽으로 확장한다.
			if(left<l && right>r) {
				if(arr[l-1]<arr[r+1]) {
					r++;
					//확장한 이후에 높이는 작은것을 기준으로 하기때문에 Math.min 수행
					height = Math.min(height, arr[r]);
				}
				else {
					l--;
					height = Math.min(height, arr[l]);
				}
			}
			//인덱스범위가 왼쪽으로만 확장할 수 있다면
			else if(left<l) {
				l--;
				height = Math.min(height, arr[l]);
			}
			//인덱스 범위가 오른쪽으로만 확장할 수 있다면
			else if(right>r) {
				r++;
				height = Math.min(height, arr[r]);
			}
			
			//결과 값은 (높이x너비)
			answer = Math.max(answer, height * (r-l+1));
		}
		return answer;
	}
}