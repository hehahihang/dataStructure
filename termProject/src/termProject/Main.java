package termProject;
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Random random = new Random(100); //씨드값을 부여한다.
		long [] arr = new long [n+1];//n개의 랜덤한 정수가 들어갈 배열을 선언한다.
		for(int i=1;i<=n;i++) {
			arr[i] = random.nextInt(); //랜덤함수를 통해 입력받는다.
		}
		
		Arrays.sort(arr);//구간 내에 최대값과 최소값의 합계를 구하기 위해 배열을 정렬
		
		int k = Integer.parseInt(br.readLine());
		for(int i=0;i<k;i++) {
			String [] str = br.readLine().split(" ");
			int start = Integer.parseInt(str[0]); //구간 start
			int finish = Integer.parseInt(str[1]);//구간 finish
			long sum = 0;
			
			for(int j=start;j<=finish;j++)
				sum += arr[j];
			
			System.out.println(arr[start]+" "+arr[finish]+" "+sum);
			//최소값 , 최대값, 구간 합계 출력
		}
	}
}
