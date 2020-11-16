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
			int qNum = myqueue.remove(); //하나를 뺀다.
			
			//스택이 비어있다면 큐에서 뽑은 숫자를 스택에 push
			if(mystack.isEmpty()) {
				mystack.push(qNum);
			}
			//반대 경우
			else {
				//스택이 비어있지 않다면 계속 반복하여 수행한다.
				while(!mystack.isEmpty()) {
					int sNum = mystack.peek();
					if(sNum>qNum) { 
						//스택 최상위 숫자가 큐에서 꺼낸 숫자보다 크다면 스택에 큐에서 꺼낸 숫자를 넣고 해당 while문을 빠져나온다. 
						mystack.push(qNum);
						break;
					}
					//스택 최상위 숫자가 작거나 같가면 큐에 스택의 숫자를 뽑아서 넣는다.
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