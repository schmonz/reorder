package com.schmonz.kata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

public class ReorderTests {
	private Integers set;

	@Before
	public void setup() {
		set = new Integers(10, 20, 30, 40, 50);
	}

	@Test
	public void object_equals() {
		assertEquals(new Integers(10, 20, 30, 40, 50), set);
		assertNotEquals(new Integers(20, 30, 40, 50), set);
		assertNotEquals(new Integers(10, 20, 30, 40, 50, 60), set);
		assertNotEquals(new Integers(10, 20, 50, 40, 50), set);
		assertNotEquals(new Integers(10, 30, 50, 40, 20), set);
	}

	@Test
	public void move_to_same_position_is_a_noop() {
		assertEquals(set, set.move(1, 1, 1));
	}

	@Test
	public void move_single_element_to_later_position() {
		assertEquals(new Integers(10, 30, 20, 40, 50), set.move(1, 1, 3));
	}

	@Test
	public void move_single_element_to_earlier_position() {
		assertEquals(new Integers(20, 10, 30, 40, 50), set.move(1, 1, 0));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void move_single_element_past_the_end() {
		set.move(1, 1, 6);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void move_single_element_before_the_start() {
		set.move(1, 1, -1);
	}

	@Test
	public void move_multiple_elements_to_later_position() {
		assertEquals(new Integers(40, 10, 20, 30, 50), set.move(0, 2, 4));
	}

	@Test
	public void move_multiple_elements_to_earlier_position() {
		assertEquals(new Integers(30, 40, 50, 10, 20), set.move(2, 4, 0));
	}

	// how about move(which, where)?
}
