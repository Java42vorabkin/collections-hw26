package telran.util;

import java.util.NoSuchElementException;

/**
 * 
 * all specified below methods should be written with complexity O[1] 
 *
 */
public class MyStackArray {
//TODO fields
	// This array saves all of MyStackArray Elements
	static int MAX_LENGTH = 100;
	private Integer stack[] = new Integer[MAX_LENGTH];
	private int stack_index = 0;
	// The last element of this array is always max element of stack
	private Integer maxElements[] = new Integer[MAX_LENGTH];
	private int max_index = 0;
	
	// Done
	/*
	 * removes the last element and returns it
	 * if the stack is empty an exception "NoSuchElementException" should be thrown
	 */
	Integer pop () {
		//TODO
		if(stack_index==0) {
			throw new NoSuchElementException();
		}
		int res = stack[--stack_index];
		if (res == maxElements[max_index-1]) {
			max_index--;
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
		return stack_index==0;
//		Done
	}
	/**
	 * adds the given element at the end of the stack
	 * @param element
	 */
	void push(Integer element) throws Exception {
		//TODO
		if(stack_index>=MAX_LENGTH) {
			throw new Exception("Stack is full");
		}
		stack[stack_index++] = element;
		if (max_index==0 || element >= maxElements[max_index-1]) {
			maxElements[max_index++] = element;
		}
//		Done
	}
	/**
	 * 
	 * @return maximal element existing in the stack
	 */
	Integer max() {
		if (max_index==0) {
			throw new NoSuchElementException();
		}
		return maxElements[max_index-1];
//		Done
	}
}
