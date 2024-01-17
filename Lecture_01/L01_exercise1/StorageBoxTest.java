import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StorageBoxTest {

	@Test
	void testIsEmpty() {
		StorageBox a = new StorageBox();
		assertTrue(a.isEmpty());

		a.push(new Object());
		assertFalse(a.isEmpty());

		a.push(new Object());
		assertFalse(a.isEmpty());

		a.pop();
		assertFalse(a.isEmpty());

		a.pop();
		assertTrue(a.isEmpty());

		a.pop();
		assertTrue(a.isEmpty());

	}

	@Test
	public void testIsFull() {
		// Test case 1: Capacity is 3, and we add 3 elements
		StorageBox storageBox1 = new StorageBox(3);
		storageBox1.push("Item 1");
		storageBox1.push("Item 2");
		storageBox1.push("Item 3");
		assertTrue(storageBox1.isFull(), "Test case 1 failed");

		// Test case 2: Capacity is 2, and we add 1 element
		StorageBox storageBox2 = new StorageBox(2);
		storageBox2.push("Item 1");
		assertFalse(storageBox2.isFull(), "Test case 2 failed");

		// Test case 3: Capacity is 1 (default), and we add 2 elements
		StorageBox storageBox3 = new StorageBox();
		storageBox3.push("Item 1");
		storageBox3.push("Item 2");
		assertTrue(storageBox3.isFull(), "Test case 3 failed");
	}

	@Test
	void testPush() {
		StorageBox a = new StorageBox();
		Object[] xs = new Object[7];
		for (int i = 0; i < xs.length; i++) {
			xs[i] = new Integer(i);
		}

		for (int i = 0; i < xs.length; i++) {
			a.push(xs[i]);
			assertEquals(xs[i], a.top());
		}

	}

	@Test
	void testPopAndTop() {
		StorageBox a = new StorageBox();
		Object[] xs = new Object[7];
		for (int i = 0; i < xs.length; i++) {
			xs[i] = new Integer(i);
		}

		assertNull(a.pop());
		for (int i = 0; i < xs.length; i++) {
			a.push(xs[i]);
		}

		for (int i = xs.length - 1; i >= 0; i--) {
			assertEquals(xs[i], a.top());
			assertEquals(xs[i], a.pop());
			if (i > 0)
				assertEquals(xs[i - 1], a.top());
			else
				assertNull(a.top());
		}
	}

}