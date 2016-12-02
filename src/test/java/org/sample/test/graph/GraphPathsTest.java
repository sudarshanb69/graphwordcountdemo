package org.sample.test.graph;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GraphPathsTest extends GraphWalker {
	private GNode a = null, b = null, j = null;
	private List<List<GNode>> expectedPaths3Levels = null;
	private List<List<GNode>> expectedPaths2Levels = null;
	private List<List<GNode>> expectedPaths1Level = null;

	@Before
	public void setUp() throws Exception {
		j = new MyGraphNodeImpl("J");
		GNode d = new MyGraphNodeImpl("D", Arrays.asList(j));

		GNode g = new MyGraphNodeImpl("G");
		GNode h = new MyGraphNodeImpl("H");
		GNode i = new MyGraphNodeImpl("I");
		GNode c = new MyGraphNodeImpl("C", Arrays.asList(g, h, i));

		GNode e = new MyGraphNodeImpl("E");
		GNode f = new MyGraphNodeImpl("F");
		b = new MyGraphNodeImpl("B", Arrays.asList(e, f));

		a = new MyGraphNodeImpl("A", Arrays.asList(b, c, d));
		
		expectedPaths3Levels = Arrays.asList(Arrays.asList(a, b, e), 
				Arrays.asList(a, b, f),
				Arrays.asList(a, c, g),
				Arrays.asList(a, c, h),
				Arrays.asList(a, c, i),
				Arrays.asList(a, d, j));
		
		expectedPaths2Levels = Arrays.asList(Arrays.asList(b, e), 
				Arrays.asList(b, f));
		
		expectedPaths1Level = Arrays.asList(Arrays.asList(j));
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testPathsThreeLevels() {
		List<List<GNode>> pathList = new GraphWalker().paths(a);

		assertEquals(pathList.size(), 6);
		assertEquals(pathList, expectedPaths3Levels);
		System.out.println(pathList);
	}

	@Test
	public void testPathsTwoLevels() {
		List<List<GNode>> pathList = new GraphWalker().paths(b);

		assertEquals(pathList.size(), 2);
		assertEquals(pathList, expectedPaths2Levels);
		System.out.println(pathList);
	}

	@Test
	public void testPathsOneLevel() {
		List<List<GNode>> pathList = new GraphWalker().paths(j);

		assertEquals(pathList.size(), 1);
		assertEquals(pathList, expectedPaths1Level);
		System.out.println(pathList);
	}

	@Test
	public void testPathsEmptyGraph() {
		List<List<GNode>> pathList = new GraphWalker().paths(null);

		assert pathList.size() == 0;
		System.out.println(pathList);
	}

}
