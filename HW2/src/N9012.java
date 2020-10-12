import java.io.*;
import java.util.*;

public class N9012 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Character> st;
		while(n-->0) {
			st = new Stack<>();
			String tmp = br.readLine();
			boolean flag = true;
			
			for(int i=0;i<tmp.length();i++) {
				char k = tmp.charAt(i);
				if(k=='(') {
					st.push(k);
				}
				else {
					if(!st.isEmpty()) {
						st.pop();
					}
					else {
						flag = false;
						break;
					}
				}
			}
			if(!st.isEmpty() || !flag)
				System.out.println("NO");
			else
				System.out.println("YES");
		}
	}
}
