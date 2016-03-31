package edu.iis.mto.bsearch;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.hamcrest.Matchers;
import org.junit.Test;

public class BinarySearchTest {

	@Test
	public void test() {
		int[] seq =  new int[]{5};
		SearchResult result = BinarySearch.search(5,seq);
		assertThat(result.isFound(),equalTo(true));
	}
	
	@Test
	public void testFoundNot() {
		int[] seq =  new int[]{4};
		SearchResult result = BinarySearch.search(5,seq);
		assertThat(result.isFound(),equalTo(false));
	}
	
	@Test
	public void testMoreThanOneIsFirst() {
		int[] seq =  new int[]{4,5,7,8,9};
		SearchResult result = BinarySearch.search(4,seq);
		assertThat(result.isFound(),equalTo(true));
		assertThat(result.getPosition(),equalTo(1));
	}
	
	@Test
	public void testMoreThanOneisLast() {
		int[] seq =  new int[]{4,5,7,8,9};
		SearchResult result = BinarySearch.search(9,seq);
		assertThat(result.isFound(),equalTo(true));
		assertThat(result.getPosition(),equalTo(seq.length));
	}
	
	@Test
	public void testMoreThanOneIsMiddle() {
		int[] seq =  new int[]{4,5,7,8,9};
		SearchResult result = BinarySearch.search(7,seq);
		assertThat(result.isFound(),equalTo(true));
		assertThat(result.getPosition(),equalTo((int) seq.length / 2 + 1));
	}
	
	@Test
	public void testMoreThanOneIsNotIn() {
		int[] seq =  new int[]{4,5,7,8,9};
		SearchResult result = BinarySearch.search(3,seq);
		assertThat(result.isFound(),equalTo(false));
	}
	
	@Test
	public void testThrowsException() {
		int[] seq =  new int[]{};
		boolean throwed = false;
		try{
			SearchResult result = BinarySearch.search(4, seq);
			assertThat(result.isFound(),equalTo(true));
		}
		catch(IllegalArgumentException x)
		{
			throwed = true;
		}
		assertTrue(throwed);
		
	}
	
	

}
