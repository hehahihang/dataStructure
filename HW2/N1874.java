import java.io.*;
import java.util.*;
public class N1874 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());//n�� �Է¹޴´�.
		Stack<Integer> st = new Stack<>();
		ArrayList<String> arrlist = new ArrayList<>();//push�� pop�� �ش��ϴ� +,-�� �Է¹��� ArrayList
		
		int [] arr = new int [n]; // �Է¹��� �������� ���� �迭
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int idx = 0; //���� ���� index��ġ�� üũ�� ����
		for(int i=1;i<=n;i++) {
			st.push(i);
			arrlist.add("+");
			while(!st.isEmpty() && st.peek() == arr[idx]) {
				st.pop();
				arrlist.add("-");
				idx++;
			}
		}
		
		if(!st.isEmpty()) {
			System.out.println("NO");
		}
		else {
			for(int i=0;i<arrlist.size();i++)
				System.out.println(arrlist.get(i));
		}
	}
}
