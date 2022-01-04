package telran.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * 
 * all specified below methods should be written with complexity O[1] 
 *
 */
public class MyStackArrayList {
//TODO fields
	static int MAX_LENGTH = 100;
	// This ArrayList saves all of MyStackArrayList Elements
	private ArrayList<Integer> stack = new ArrayList<>();
	// The last element of this ArrayList is always Max element of My Stack
	private ArrayList<Integer> maxElements = new ArrayList<>();
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
		int res = stack.remove(stack.size() -1);
		if (res == maxElements.get(maxElements.size()-1)) {
			maxElements.remove(maxElements.size()-1);
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
	void push(Integer element) throws Exception {
		//TODO
		if(stack.size() >= MAX_LENGTH) {
			throw new Exception("Stack is full");
		}
		stack.add(element);
		if (maxElements.isEmpty() || element >= maxElements.get(maxElements.size()-1)) {
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
		return maxElements.get(maxElements.size()-1);
//		Done
	}
}
