package com.telstra.optimisepath.algorithm;

import java.io.*;
import java.util.Scanner;


public class BellmanHeldKarpAlgorithm {

	/*
	 * GLOBAL VARIABLES
	 */
	private static int[][] distances;
	private static int finalResults[];
	private static String paths[];
	private static int counter = 0;


	public static void main(String args[]) throws IOException {

		try {
		// The path to the files with the distances is asked
		Scanner input = new Scanner(System.in);
		System.out.println("Please provide the input file path containing adjacency matrix of distance between cities.");
		String file = input.nextLine();

		// The size of the distance matrix is asked
		System.out.println("Please provide the number of nodes");
		int size = input.nextInt();

		// Global variables are initialized considering the size of the matrix
		int numSolutions = factorial(size - 1);
		distances = new int[size][size];
		finalResults = new int[numSolutions];
		paths = new String[numSolutions];

		// The file in that location is opened
		FileReader f = new FileReader(file);
		BufferedReader b = new BufferedReader(f);

		// Our matrix is filled with the values of the file matrix
		for (int row = 0; row < size; row++) {

			// Every value of each row is read and stored
			String line = b.readLine();
			String[] values = line.trim().split("\\s+");

			for (int col = 0; col < size; col++) {
				distances[row][col] = Integer.parseInt(values[col]);
			}
		}

		// Closing file
		b.close();

	
		// Start algorithm
		String path = "";
		int[] vertices = new int[size - 1];

		// Filling the initial vertices array with the proper values
		for (int i = 1; i < size; i++) {
			vertices[i - 1] = i;
		}

		
		int distance = calculateDistance(0, vertices, path, 0);

		int optimal = 0;
		for (int i = 0; i < numSolutions; i++) {

			// When we reach the optimal one, its index is saved
			if (finalResults[i] == distance) {
				optimal = i;
			}
		}
		System.out.println();
		System.out.print("Path: " + paths[optimal] + ". Distance = " + finalResults[optimal] );
	}catch(Exception e) {
		
	}
		
	}

	/*
	 * 
	 * 
	 */

	public static int calculateDistance(int initial, int vertices[], String path, int unitCost) {

		// We concatenate the current path and the vertex taken as initial
		path = path + Integer.toString(initial) + " - ";
		int length = vertices.length;
		int newCostUntilHere;

		// Exit case, if there are no more options to evaluate (last node)
		if (length == 0) {

			// Both results, numerical distances and paths to those distances, are stored
			paths[counter] = path + "0";
			finalResults[counter] = unitCost + distances[initial][0];

			counter++;
			return (distances[initial][0]);
		}

		// if there are more than 1 node
		else {

			int[][] newVertices = new int[length][(length - 1)];
			int costCurrentNode, costChild;
			int bestCost = Integer.MAX_VALUE;

			// For each of the nodes of the list
			for (int i = 0; i < length; i++) {

				// Each recursion new vertices list is constructed
				for (int j = 0, k = 0; j < length; j++, k++) {

					// The current child is not stored in the new vertices array
					if (j == i) {
						k--;
						continue;
					}
					newVertices[i][k] = vertices[j];
				}

				// Cost of arriving the current node from its parent
				costCurrentNode = distances[initial][vertices[i]];

				// Here the cost to be passed to the recursive function is computed
				newCostUntilHere = costCurrentNode + unitCost;

				// RECURSIVE CALLS TO THE FUNCTION IN ORDER TO COMPUTE THE COSTS
				costChild = calculateDistance(vertices[i], newVertices[i], path, newCostUntilHere);

				// The cost of every child + the current node cost is computed
				int totalCost = costChild + costCurrentNode;

				// Finally we select from the minimum from all possible children costs
				if (totalCost < bestCost) {
					bestCost = totalCost;
				}
			}

			return (bestCost);
		}
	}

	// Factorial function used to calculate the number of solutions
	public static int factorial(int n) {

		if (n <= 1) {
			return 1;
		} else {
			return (n * factorial(n - 1));
		}
	}
}