import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Histogram {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //������ ĭ��
		int [] arr = new int [n]; //�� ���簢���� ����
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		//���
		int result = histo(arr,n);
		System.out.println(result);
	}
	
	public static int histo(int [] arr,int n) {
		return histogram(arr,0,n-1);
	}
	
	public static int histogram(int [] arr,int left, int right) {
		//�ε��� ���� ���ٸ�, �ϳ��� ���簢���� �����ϴ� ���̹Ƿ� �ش� ���簢���� ���̸� return (�ʺ�� 1���� �����̱� ����)
		if(left==right) {
			return arr[left];
		}
		
		//�ƴ϶��, �߾Ӱ� :mid�� �����ϰ� ��������
		int mid = (left+right)/2;
		
		//��� �������� ������ ���ʿ��� �� ū ���̸� ��ȯ�Ѵ�.
		int maxLeft = histogram(arr,left,mid);
		int maxRight = histogram(arr,mid+1,right);
		int answer = Math.max(maxLeft, maxRight); //������ ���� ���̸� ���� ���Ѵ�.
		
		int l = mid;
		int r = mid+1;
		int height = Math.min(arr[l], arr[r]); //���̰� �� ������ ã�� ������ ���̷� �Ͽ� Ȯ��
		answer = Math.max(answer, height*2); //mid�� �������� �ʺ� ��ġ�� 
		
		//�ε��� ������ ����� �������� ��� l�� ���ҽ�Ű�ų� r�� ������Ų��.
		while(left<l || right>r) {
			//�Ѵ� �����Ѵٸ�
			//���簢���� ���� �� �� ū������ Ȯ���Ѵ�.
			if(left<l && right>r) {
				if(arr[l-1]<arr[r+1]) {
					r++;
					//Ȯ���� ���Ŀ� ���̴� �������� �������� �ϱ⶧���� Math.min ����
					height = Math.min(height, arr[r]);
				}
				else {
					l--;
					height = Math.min(height, arr[l]);
				}
			}
			//�ε��������� �������θ� Ȯ���� �� �ִٸ�
			else if(left<l) {
				l--;
				height = Math.min(height, arr[l]);
			}
			//�ε��� ������ ���������θ� Ȯ���� �� �ִٸ�
			else if(right>r) {
				r++;
				height = Math.min(height, arr[r]);
			}
			
			//��� ���� (����x�ʺ�)
			answer = Math.max(answer, height * (r-l+1));
		}
		return answer;
	}
}