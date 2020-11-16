import java.util.*;
import java.io.*;



public class queueNstack {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		myQueue<Integer> myqueue = new myQueue<>();
		myStack<Integer> mystack = new myStack<>();
		for(int i=0;i<n;i++) {
			int tmp = (int)(Math.random()*10000)+1;
			myqueue.add(tmp);
		}
		
		while(!myqueue.isEmpty()) {
			int qNum = myqueue.remove(); //�ϳ��� ����.
			
			//������ ����ִٸ� ť���� ���� ���ڸ� ���ÿ� push
			if(mystack.isEmpty()) {
				mystack.push(qNum);
			}
			//�ݴ� ���
			else {
				//������ ������� �ʴٸ� ��� �ݺ��Ͽ� �����Ѵ�.
				while(!mystack.isEmpty()) {
					int sNum = mystack.peek();
					if(sNum>qNum) { 
						//���� �ֻ��� ���ڰ� ť���� ���� ���ں��� ũ�ٸ� ���ÿ� ť���� ���� ���ڸ� �ְ� �ش� while���� �������´�. 
						mystack.push(qNum);
						break;
					}
					//���� �ֻ��� ���ڰ� �۰ų� ������ ť�� ������ ���ڸ� �̾Ƽ� �ִ´�.
					else {
						myqueue.add(mystack.pop());
					}
				}
			}
		}
		
		while(!mystack.isEmpty()) {
			sb.append(mystack.pop()+"\n");
		}
		
		System.out.println(sb.toString());
	}
}

class myQueue<E>{
	int front;
	int rear;
	E [] data;
	int size;
	
	myQueue(){
		front = rear = 0;
		size = 1024;
		data = (E[]) new Object[size];
	}
	
	public void add(E newItem) {
		data[rear] = newItem;
		rear = (rear+1)%size;
	}
	
	public E peek() {
		return data[front];
	}
	
	public E remove() {
		E removeItem = data[front];
		data[front] = null;
		front = (front+1)%size;
		return removeItem;
	}
	
	public boolean isEmpty() {
		return front==rear;
	}

}

class myStack<E>{
	private E [] data;
	private int top;
	
	public myStack() {
		data = (E[]) new Object[1024];
		top = -1;
	}
	
	public int size() {
		return top+1;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public E peek() {
		if(isEmpty())
			throw new EmptyStackException();
		else
			return data[top];
	}
	
	public void push(E newItem) {
		data[++top] = newItem;
	}
	
	public E pop() {
		E popItem = data[top];
		data[top--] = null;
		return popItem;
	}
	
}