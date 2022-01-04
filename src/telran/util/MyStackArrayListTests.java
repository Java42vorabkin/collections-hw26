package telran.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyStackArrayListTests {
MyStackArrayList myStackArrayList;
Stack<Integer> stack;
Integer elements[] = {
	10, -10, 20, 40, 40, -8, 3	
};
	@BeforeEach
	void setUp() throws Exception {
		myStackArrayList = new MyStackArrayList();
		stack = new Stack<>();
		for(Integer num: elements) {
			myStackArrayList.push(num);
			stack.push(num);
		}
		
	}

	@Test
	void testPop() {
		allPops();
		boolean flException = false;
		try {
			myStackArrayList.pop();
		} catch (NoSuchElementException e) {
			flException = true;
		}
		assertTrue(flException);
	}

	private void allPops() {
		for (int i = 0; i < elements.length; i++) {
			assertEquals(stack.pop(), myStackArrayList.pop());
		}
	}

	@Test
	void testIsEmpty() {
		assertFalse(myStackArrayList.isEmpty());
		allPops();
		assertTrue(myStackArrayList.isEmpty());
	}

	@Test
	void testPush() {
		Integer num = 1000;
		try {
			myStackArrayList.push(num);
			stack.push(num);
			allPops();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		MyStackArrayList tmpStack = new MyStackArrayList();
		boolean flException = false;
		try {
			for(int i=0; i<=MyStackArrayList.MAX_LENGTH; i++) {
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
		assertEquals(Collections.max(stack), myStackArrayList.max());
		int nPops = 3;
		pops(nPops);
		assertEquals(Collections.max(stack), myStackArrayList.max());
		nPops = 2;
		pops(nPops);
		assertEquals(Collections.max(stack), myStackArrayList.max());
		
	}

	private void pops(int nPops) {
		for(int i = 0; i < nPops; i++) {
			stack.pop();
			myStackArrayList.pop();
		}
	}

}
