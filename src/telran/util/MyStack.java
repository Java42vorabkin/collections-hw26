package telran.util;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * 
 * all specified below methods should be written with complexity O[1] 
 *
 */
public class MyStack {
//TODO fields
	static int MAX_LENGTH = 100;
	// This LinkedList saves all of MyStack Elements
	private LinkedList<Integer> stack = new LinkedList<>();
	// The last element of this LinkedList is always Max element of My Stack
	private LinkedList<Integer> maxElements = new LinkedList<>();
	// Done
	/*
	 * removes the last element and returns it
	 * if the stack is empty an exception "NoSuchElementException" should be thrown
	 */
	Integer pop () {
		//TODO
		if (stack.isEmpty()) {
			throw new NoSuchElementException();
		}
		int res = stack.removeLast();
		if (res == maxElements.getLast()) {
			maxElements.removeLast();
		}
		return res;
//		Done
	}
	/**
	 * 
	 * @return true it the stack is empty
	 */ 
	boolean isEmpty() {
		//TODO
		return stack.isEmpty();
//		Done
	}
	/**
	 * adds the given element at the end of the stack
	 * @param element
	 */
	void push(Integer element) throws Exception{
		//TODO
		if(stack.size() >= MAX_LENGTH) {
			throw new Exception("Stack is full");
		}
		stack.add(element);
		if (maxElements.isEmpty() || element >= maxElements.getLast()) {
			maxElements.add(element);
		}
//		Done
	}
	/**
	 * 
	 * @return maximal element existing in the stack
	 */
	Integer max() {
		if (maxElements.isEmpty()) {
			throw new NoSuchElementException();
		}
		return maxElements.getLast();
//		Done
	}
}
