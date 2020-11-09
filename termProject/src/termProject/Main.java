package termProject;
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Random random = new Random(100); //���尪�� �ο��Ѵ�.
		long [] arr = new long [n+1];//n���� ������ ������ �� �迭�� �����Ѵ�.
		for(int i=1;i<=n;i++) {
			arr[i] = random.nextInt(); //�����Լ��� ���� �Է¹޴´�.
		}
		
		Arrays.sort(arr);//���� ���� �ִ밪�� �ּҰ��� �հ踦 ���ϱ� ���� �迭�� ����
		
		int k = Integer.parseInt(br.readLine());
		for(int i=0;i<k;i++) {
			String [] str = br.readLine().split(" ");
			int start = Integer.parseInt(str[0]); //���� start
			int finish = Integer.parseInt(str[1]);//���� finish
			long sum = 0;
			
			for(int j=start;j<=finish;j++)
				sum += arr[j];
			
			System.out.println(arr[start]+" "+arr[finish]+" "+sum);
			//�ּҰ� , �ִ밪, ���� �հ� ���
		}
	}
}
