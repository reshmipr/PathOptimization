package com.telstra.optimisepath.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Path {

	@Id
	private String pathId;
	private Integer numOfNodes;
	private String adjacencyMatrix;
	private String optimalPath;
	private Integer optimalCost;

	public Path(Integer numOfNodes, String adjacencyMatrix, String optimalPath, Integer optimalCost) {
		super();
		this.numOfNodes = numOfNodes;
		this.adjacencyMatrix = adjacencyMatrix;
		this.optimalPath = optimalPath;
		this.optimalCost = optimalCost;
	}

	public Path() {
	}

	public Integer getNumOfNodes() {
		return numOfNodes;
	}

	public void setNumOfNodes(Integer numOfNodes) {
		this.numOfNodes = numOfNodes;
	}

	public String getAdjacencyMatrix() {
		return adjacencyMatrix;
	}

	public void setAdjacencyMatrix(String adjacencyMatrix) {
		this.adjacencyMatrix = adjacencyMatrix;
	}

	public String getOptimalPath() {
		return optimalPath;
	}

	public void setOptimalPath(String optimalPath) {
		this.optimalPath = optimalPath;
	}


	public String getPathId() {
		return pathId;
	}

	public void setPathId(String pathId) {
		this.pathId = pathId;
	}

	public Integer getOptimalCost() {
		return optimalCost;
	}

	public void setOptimalCost(Integer optimalCost) {
		this.optimalCost = optimalCost;
	}

	@Override
	public String toString() {
		return "Path [pathId=" + pathId + ", numOfNodes=" + numOfNodes + ", adjacencyMatrix=" + adjacencyMatrix
				+ ", optimalPath=" + optimalPath + ", optimalCost=" + optimalCost + "]";
	}

	

}
