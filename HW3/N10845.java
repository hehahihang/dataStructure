import java.io.*;
import java.util.*;
public class N10845 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		LinkedList<Integer> queue = new LinkedList();
		
		while(n-->0) {
			String [] str = br.readLine().split(" ");
			String tmp = str[0];
			if(tmp.equals("push")) {
				int num = Integer.parseInt(str[1]);
				queue.add(num);
			}
			else if(tmp.equals("pop")) {
				if(queue.isEmpty()) 
					sb.append("-1\n");
				else {
					sb.append(queue.remove()+"\n");
				}
			}
			else if(tmp.equals("size")) {
				sb.append(queue.size()+"\n");
			}
			else if(tmp.equals("empty")) {
				if(queue.isEmpty())
					sb.append("1\n");
				else
					sb.append("0\n");
			}
			else if(tmp.equals("front")) {
				if(!queue.isEmpty()) {
					sb.append(queue.peekFirst()+"\n");
				}
				else
					sb.append("-1\n");
			}
			else if(tmp.equals("back")) {
				if(!queue.isEmpty()) {
					sb.append(queue.peekLast()+"\n");
				}
				else
					sb.append("-1\n");
			}
		}
		System.out.println(sb.toString());
	}
}
