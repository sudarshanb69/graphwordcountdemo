package org.sample.test.graph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Sudarshan Bandi
 * 
 * Test GraphWalker functionality
 *
 */
public class GraphWalkerTest {
	private GNode node1 = null, node11 = null, node12 = null, node13 = null;

	@Before
	public void setUp() throws Exception {
		GNode node111 = new MyGraphNodeImpl("node111");
		GNode node112 = new MyGraphNodeImpl("node112");
		List<GNode> node11Children = new ArrayList<>();
		node11Children.add(node111);
		node11Children.add(node112);
		node11 = new MyGraphNodeImpl("node11", node11Children);
		
		GNode node121 = new MyGraphNodeImpl("node121");
		List<GNode> node12Children = new ArrayList<>();
		node12Children.add(node121);
		node12 = new MyGraphNodeImpl("node12", node12Children);
		
		node13 = new MyGraphNodeImpl("node13");
		
		List<GNode> node1Children = new ArrayList<>();
		node1Children.add(node11);
		node1Children.add(node12);
		node1Children.add(node13);
		node1 = new MyGraphNodeImpl("node1", node1Children);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testWalkGraphNoNodes() {
		List<GNode> nodeList = new GraphWalker().walkGraph(null);
		
		assertTrue(nodeList.isEmpty());
		System.out.println(nodeList);
	}

	@Test
	public void testWalkGraphOneNodeNoChildren() {
		List<GNode> nodeList = new GraphWalker().walkGraph(node13);
		
		assertEquals(nodeList.size(), 1);
		System.out.println(nodeList);
	}

	@Test
	public void testWalkGraphOneNodeWithOneChild() {
		List<GNode> nodeList = new GraphWalker().walkGraph(node12);
		
		assertEquals(nodeList.size(), 2);
		System.out.println(nodeList);

	}
	
	@Test
	public void testWalkGraphOneNodeWithTwoChildren() {
		List<GNode> nodeList = new GraphWalker().walkGraph(node11);
		
		assertEquals(nodeList.size(), 3);
		System.out.println(nodeList);
	}
	

	@Test
	public void testWalkGraph() {
		/*
		             n1
		         /   |   \
		        /    |    \
		     n11    n12   n13
		    /  \     |     
		   /    \    |
		 n111  n112 n121
		 */
		
		List<GNode> nodeList = new GraphWalker().walkGraph(node1);
		
		assertEquals(nodeList.size(), 7);
		System.out.println(nodeList);
	}
}
