package org.sample.test.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Sudarshan Bandi
 * 
 * Implements graph walking functionality
 */
public class GraphWalker {
	
	/**
	 * Walks the graph starting from root node
	 * @param node
	 * @return
	 */
	public List<GNode> walkGraph(GNode node) {
		List<GNode> nodeList = new ArrayList<>();
		if (node != null) {
			nodeList.add(node);
			GNode[] children = node.getChildren();
			for (GNode childNode : children) {
				nodeList.addAll(walkGraph(childNode));
			}
		}
		
		return nodeList;
	}
	
	/**
	 * Prints all paths from root node
	 * 
	 * @param node
	 * @return
	 */
	public List<List<GNode>> paths(GNode node) {
		List<List<GNode>> pathList = new ArrayList<>();
		if (node == null) {
			// nothing to add to the path list
		} else if (node.getChildren().length == 0) {
			List<GNode> nodeList = new ArrayList<>();
			nodeList.add(node);
			pathList.add(nodeList);
		} else {
			for (GNode child : node.getChildren()) {
				List<List<GNode>> childPathList = paths(child);
				for (List<GNode> path : childPathList) {
					//Add self to the beginning of the path
					path.add(0, node);
					
					//Add path to the list of node paths
					pathList.add(path);
				}
			}
		}
		return pathList;
	}
}
