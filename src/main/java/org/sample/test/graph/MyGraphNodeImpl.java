package org.sample.test.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sudarshan Bandi
 * 
 * My graph node implementation
 */
public class MyGraphNodeImpl implements GNode {
	private String name;
	private List<GNode> children;
	
	public MyGraphNodeImpl(String name) {
		super();
		this.name = name;
		this.children = new ArrayList<>();
	}

	public MyGraphNodeImpl(String name, List<GNode> children) {
		super();
		this.name = name;
		this.children = children;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public GNode[] getChildren() {
		return children.toArray(new GNode[0]);
	}

	@Override
	public String toString() {
		return getName();
	}
	
}
