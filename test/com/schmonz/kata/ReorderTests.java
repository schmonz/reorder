package com.schmonz.kata;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ReorderTests {
	private Integers set;

	@Before
	public void setup() {
		set = new Integers(asList(10, 20, 30, 40, 50));
	}

	@Test
	public void set_has_an_ordering_that_is_preserved() {
		assertThat(set.getElements(), equalTo(asList(10, 20, 30, 40, 50)));
	}

	@Test
	public void move_to_same_position_is_a_noop() {
		Integers moved = set.move(1, 1, 1);

		assertThat(set.getElements(), equalTo(moved.getElements()));
	}

	@Test
	public void move_single_element_to_later_position() {
		Integers moved = set.move(1, 1, 3);

		assertThat(moved.getElements(), equalTo(asList(10, 30, 20, 40, 50)));
	}

	@Test
	public void move_single_element_to_earlier_position() {
		Integers moved = set.move(1, 1, 0);

		assertThat(moved.getElements(), equalTo(asList(20, 10, 30, 40, 50)));
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
		Integers moved = set.move(0, 2, 4);

		assertThat(moved.getElements(), equalTo(asList(40, 10, 20, 30, 50)));
	}

	@Test
	public void move_multiple_elements_to_earlier_position() {
		Integers moved = set.move(2, 4, 0);

		assertThat(moved.getElements(), equalTo(asList(30, 40, 50, 10, 20)));
	}

	// how about move(which, where)?
	// how about assertEquals(set.move(...), asList(...))?
}
