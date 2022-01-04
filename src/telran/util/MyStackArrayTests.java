package telran.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyStackArrayTests {
MyStackArray myStackArray;
Stack<Integer> stack;
Integer elements[] = {
	10, -10, 20, 40, 40, -8, 3	
};
	@BeforeEach
	void setUp() throws Exception {
		myStackArray = new MyStackArray();
		stack = new Stack<>();
		for(Integer num: elements) {
			myStackArray.push(num);
			stack.push(num);
		}
		
	}

	@Test
	void testPop() {
		allPops();
		boolean flException = false;
		try {
			myStackArray.pop();
		} catch (NoSuchElementException e) {
			flException = true;
		}
		assertTrue(flException);
	}

	private void allPops() {
		for (int i = 0; i < elements.length; i++) {
			assertEquals(stack.pop(), myStackArray.pop());
		}
	}

	@Test
	void testIsEmpty() {
		assertFalse(myStackArray.isEmpty());
		allPops();
		assertTrue(myStackArray.isEmpty());
	}

	@Test
	void testPush() {
		Integer num = 1000;
		try {
			myStackArray.push(num);
			stack.push(num);
			allPops();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		MyStackArray tmpStack = new MyStackArray();
		boolean flException = false;
		try {
			for(int i=0; i<=MyStackArray.MAX_LENGTH; i++) {
				tmpStack.push(i);
			}
		} catch (Exception ex) {
			flException = true;
			System.out.println(ex.toString());
		}
		assertTrue(flException);
	}

	@Test
	void testMax() {
		assertEquals(Collections.max(stack), myStackArray.max());
		int nPops = 3;
		pops(nPops);
		assertEquals(Collections.max(stack), myStackArray.max());
		nPops = 2;
		pops(nPops);
		assertEquals(Collections.max(stack), myStackArray.max());
		
	}

	private void pops(int nPops) {
		for(int i = 0; i < nPops; i++) {
			stack.pop();
			myStackArray.pop();
		}
	}

}
