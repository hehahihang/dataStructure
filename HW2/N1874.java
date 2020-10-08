import java.io.*;
import java.util.*;
public class N1874 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());//n을 입력받는다.
		Stack<Integer> st = new Stack<>();
		ArrayList<String> arrlist = new ArrayList<>();//push와 pop에 해당하는 +,-를 입력받을 ArrayList
		
		int [] arr = new int [n]; // 입력받을 수열값에 대한 배열
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int idx = 0; //수열 값의 index위치를 체크할 변수
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
