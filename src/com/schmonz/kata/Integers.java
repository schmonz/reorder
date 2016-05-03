package com.schmonz.kata;

import java.util.ArrayList;
import java.util.List;

public class Integers {
	private List<Integer> elements;

	public Integers(List<Integer> elements) {
		this.elements = new ArrayList<>(elements);
	}

	public List<Integer> getElements() {
		return elements;
	}

	public Integers move(int start, int end, int inFrontOfIndex) {
		List<Integer> slice = copyAndRemoveSlice(start, end);

		int offsetForRemovedSlice = (inFrontOfIndex < start) ? 0 : slice.size();

		elements.addAll(inFrontOfIndex - offsetForRemovedSlice, slice);

		return new Integers(elements);
	}

	private List<Integer> copyAndRemoveSlice(int start, int end) {
		List<Integer> slice = elements.subList(start, end + 1);
		List<Integer> deepCopy = new ArrayList<>(slice);
		slice.clear();
		return deepCopy;
	}
}
