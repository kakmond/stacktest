package ku.util.test;

import static org.junit.Assert.*;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import ku.util.Stack;
import ku.util.StackFactory;

/**
 * JUnit tests of the Stack interface.
 * 
 * @author Wongsathorn Panichkurkul
 *
 */
public class StackTest {

	private Stack<String> stack;

	/** "Before" method is run before each test. */
	@Before
	public void setUp() {
		StackFactory.setStackType(0);
		stack = makeStack(3);
	}

	/** Test a new Stack that is correct or not. */
	@Test
	public void newStackIsEmpty() {
		assertTrue(stack.isEmpty());
		assertFalse(stack.isFull());
		assertEquals(0, stack.size());
	}

	/** Test if capacity of Stack is zero */
	@Test
	public void testCapacityZero() {
		stack = makeStack(0);
		assertTrue(stack.isEmpty());
		assertTrue(stack.isFull());
	}

	/** pop() should throw an EmptyStackException if stack is empty */
	@Test(expected = java.util.EmptyStackException.class)
	public void testPopEmptyStack() {
		Assume.assumeTrue(stack.isEmpty());
		stack.pop();
		fail("Pop empty stack should throw exception");
	}

	/**
	 * Test peak() method that return a correct element and not remove from
	 * Stack.
	 */
	@Test
	public void testPeek() {
		stack.push("element 1");
		assertEquals("element 1", stack.peek());
		stack.push("element 2");
		assertEquals("element 2", stack.peek());
		stack.push("element 3");
		assertEquals("element 3", stack.peek());
		assertEquals(3, stack.size());
	}

	/** Test size of Stack by push , peek and pop. */
	@Test
	public void testSize() {
		stack.push("element 1");
		assertEquals(1, stack.size());
		stack.peek();
		assertEquals(1, stack.size());
		stack.pop();
		assertEquals(0, stack.size());
	}

	/** push() should throw IllegalStateException if stack is full. */
	@Test(expected = IllegalStateException.class)
	public void testOverflow() {
		stack.push("element 1");
		stack.push("element 2");
		stack.push("element 3");
		stack.push("element 4");
		stack.push("element 5");
		fail("push more than capacity should throw IllegalStateException");
	}

	/** push() should throw InvalidArgumentException if parameter is null. */
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testNullParameter() {
		stack.push(null);
		fail("null argument should throw InvalidArgumentException");
	}

	/** Test capacity() method. */
	@Test
	public void testCapacity() {
		assertEquals(3, stack.capacity());
		stack = makeStack(5);
		assertEquals(5, stack.capacity());
	}

	/** Test pop() method. */
	@Test
	public void testPop() {
		stack.push("element 1");
		stack.push("element 2");
		stack.push("element 3");
		assertEquals("element 3", stack.pop());
		assertEquals(2, stack.size());
	}

	/** Test isFull() method. */
	@Test
	public void testIsFull() {
		stack.push("element 1");
		stack.push("element 2");
		assertFalse(stack.isFull());
		stack.push("element 3");
		assertTrue(stack.isFull());
	}

	/** A method to create stacks, so we can change implementation. */
	private Stack makeStack(int capacity) {
		return (Stack<String>) StackFactory.makeStack(capacity);
	}
}
