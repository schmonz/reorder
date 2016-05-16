package com.schmonz.kata;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

public class Integers {
	private List<Integer> elements;

	public Integers(Integer... integers) {
		this.elements = new ArrayList<>(asList(integers));
	}

	@Override
	public boolean equals(Object o) {
		if (null == o) {
			return false;
		}

		List<Integer> listOfIntegers = ((Integers) o).elements;
		return listOfIntegers.equals(elements);
	}

	public Integers move(int start, int end, int inFrontOfIndex) {
		List<Integer> slice = copyAndRemoveSlice(start, end);
		int offsetForRemovedSlice = (inFrontOfIndex < start) ? 0 : slice.size();
		elements.addAll(inFrontOfIndex - offsetForRemovedSlice, slice);
		return new Integers(elements.toArray(new Integer[0]));
	}

	private List<Integer> copyAndRemoveSlice(int start, int end) {
		List<Integer> slice = elements.subList(start, end + 1);
		List<Integer> deepCopy = new ArrayList<>(slice);
		slice.clear();
		return deepCopy;
	}
}
