package org.sample.test.graph;

/**
 * @author Sudharsan Bandi
 * 
 * Interface for a node in a graph
 */
public interface GNode {
	public String getName();
	public GNode[] getChildren();
}
