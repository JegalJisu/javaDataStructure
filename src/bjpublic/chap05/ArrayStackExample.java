package bjpublic.chap05;

public class ArrayStackExample {
	private Object[] stack;
	private int top;
	
	public ArrayStackExample(int length) {
		// 빈 스택은 top = -1로 표현
		this.top = -1;
		this.stack = new Object[length];
	}
	
	/**
	 * 데이터 삽입
	 * @param data
	 */
	public void push(Object data) {
		if (top == stack.length - 1) {
			throw new StackOverflowError();
		}
		
		stack[++top] = data;
	}
	
	/**
	 * 데이터 가져오기
	 * @return Object
	 */
	public Object pop() {
		if (top == -1) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		Object temp = stack[top];
		stack[top--] = null;
		return temp;
	}
	
	/**
	 * 현재 스택의 마지막 데이터를 가져온다.
	 * @return Object
	 */
	public Object peek() {
		return stack[top];
	}
	
	/**
	 * 스택이 비었는지 확인
	 * @return boolean
	 */
	public boolean empty() {
		return top == -1;
	}
}
