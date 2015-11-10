package scratchpad;

public class Test {

	public static void main(String[] args) {
		StackOfIntegers stack = new StackOfIntegers();
		stack.push(5);
		stack.push(2);
		stack.push(13);
		stack.peek();
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}
