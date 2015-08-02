package com.benjvi.quicksort;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class QuickSortTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInteger() {
		Integer[] testList = { 120, 45443, 23, 253, 4364, 44, 23493, 1, 2, 3 };
		QuickSort<Integer> q = new QuickSort<Integer>(testList);
		ForkJoinPool p = new ForkJoinPool();
		p.invoke(q);
		System.out.println(Arrays.toString(testList));
	}

	@Test
	public void testString() {
		String[] testList = { "z", "x", "w", "a", "b", "h", "m", "f" };
		QuickSort<String> q = new QuickSort<String>(testList);
		ForkJoinPool p = new ForkJoinPool();
		p.invoke(q);
		System.out.println(Arrays.toString(testList));
	}
}
