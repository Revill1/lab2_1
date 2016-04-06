package edu.iis.mto.bsearch;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.hamcrest.Matchers;
import org.junit.Test;

public class BinarySearchTest {

	@Test
	public void isElementFoundInSequence_oneElement() {
		int[] seq = new int[] {5};
		SearchResult result = BinarySearch.search(5, seq);
		assertThat(result.isFound(), equalTo(true));
	}

	@Test
	public void isElementFoundNotInSequence_oneElement() {
		int[] seq = new int[] {4};
		SearchResult result = BinarySearch.search(5, seq);
		assertThat(result.isFound(), equalTo(false));
	}

	@Test
	public void isElementFirstInSequence_moreThanOneElement() {
		int[] seq = new int[] { 4, 5, 7, 8, 9 };
		SearchResult result = BinarySearch.search(4, seq);
		assertThat(result.isFound(), equalTo(true));
		assertThat(result.getPosition(), equalTo(1));
	}

	@Test
	public void isElementLastInSequence_moreThanOneElement() {
		int[] seq = new int[] { 4, 8, 9 };
		SearchResult result = BinarySearch.search(9, seq);
		assertThat(result.isFound(), equalTo(true));
		assertThat(result.getPosition(), equalTo(seq.length));
	}

	@Test
	public void isElementMiddleInSequence_moreThanOneElement() {
		int[] seq = new int[] { 4, 5, 7, 8, 9 ,10};
		SearchResult result = BinarySearch.search(7, seq);
		assertThat(result.isFound(), equalTo(true));
		if (seq.length % 2 == 0) {
			assertThat(result.getPosition(), equalTo((int) seq.length / 2));
		} else {
			assertThat(result.getPosition(), equalTo((int) seq.length / 2 + 1));
		}
	}

	@Test
	public void isElementFoundNotInSequence_moreThanOneElement() {
		int[] seq = new int[] { 4, 6, 7, 8, 11 };
		SearchResult result = BinarySearch.search(3, seq);
		assertThat(result.isFound(), equalTo(false));
	}

	@Test(expected = IllegalArgumentException.class)
	public void isThrowingExceptionForNoEements() {
		int[] seq = new int[] {};
		boolean throwed = false;

		SearchResult result  = BinarySearch.search(3,seq);
	}

	@Test
	public void isElementFoundInSequence_wrongSequenceOrder() {
		int[] seq = new int[] { 4, 6, 3, 8, 2 };
		SearchResult result = BinarySearch.search(3, seq);
		assertThat(result.isFound(), equalTo(true));
	}
	
	@Test
	public void isElementMiddleInSequence_moreThanOneElement_wrongSequenceOrder() {
		int[] seq = new int[] { 4, 3, 7, 2, 9 ,1, 10};
		SearchResult result = BinarySearch.search(2, seq);
		assertThat(result.isFound(), equalTo(true));
		if (seq.length % 2 == 0) {
			assertThat(result.getPosition(), equalTo((int) seq.length / 2));
		} else {
			assertThat(result.getPosition(), equalTo((int) seq.length / 2 + 1));
		}
	}
	
	@Test 
	public void isEqual() {
		int[] seq = new int[] { 4, 6, 3, 8, 2 };
		int[] other = new int[] {3,5,6,7,8,9};
		SearchResult result = BinarySearch.search(3, seq);
		SearchResult otherResult = BinarySearch.search(2,other);
		
		assertThat(result.equals(otherResult), equalTo(false));
	}
	
}
