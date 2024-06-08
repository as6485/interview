package javabasics.datastructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class GraphAdjList {

	ArrayList<ArrayList<Integer>> al;
	private boolean visited[];

	public GraphAdjList(int vertices) {
		al = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < vertices; i++) {
			al.add(new ArrayList<Integer>());
		}

		visited = new boolean[vertices];
	}

	public static void main(String[] args) {
		int nbrOfVertices = 6;
		GraphAdjList graph = new GraphAdjList(nbrOfVertices);
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(0, 5);

		graph.addEdge(1, 3);
		graph.addEdge(1, 4);

		graph.addEdge(2, 1);

		graph.addEdge(3, 2);
		graph.addEdge(3, 4);

		graph.print();
		System.out.println("-------- DFS --------");
		graph.dfs(0);
		graph.clearVisted();
		System.out.println();
		System.out.println("-------- BFS --------");
		graph.bfs(0);
		graph.clearVisted();
		System.out.println();
		System.out.println("-------- Topological Sort --------");
		graph.topoLogicalSort(graph, nbrOfVertices);
		graph.clearVisted();
	}

	private void topoLogicalSort(GraphAdjList graph, int nbrOfVertices) {
		// Stack to store the result
		Stack<Integer> stack = new Stack<>();

		// Call the recursive helper function to store
		// Topological Sort starting from all vertices one
		// by one
		for (int i = 0; i < nbrOfVertices; i++) {
			if (!visited[i])
				topologicalSortUtil(i, stack);
		}

		// Print contents of stack
		while (!stack.empty()) {
			System.out.print(stack.pop() + " ");
		}
	}
	private void topologicalSortUtil(int vertex,
											Stack<Integer> stack)
	{
		visited[vertex] = true;
		// Recur for all adjacent vertices
		for (int i : al.get(vertex)) {
			if (!visited[i])
				topologicalSortUtil(i, stack);
		}

		// Push current vertex to stack which stores the
		// result
		stack.push(vertex);
	}


	private void bfs(int vertex) {
		LinkedList<Integer> queue = new LinkedList();
		visited[vertex] = true;
		queue.add(vertex);

		while (queue.size() != 0) {
			vertex = queue.poll();
			System.out.print(vertex + " ");

			al.get(vertex).forEach(v -> {
				if (!visited[v]) {
					visited[v] = true;
					queue.add(v);
				}
			});
		}
	}

	private void clearVisted() {
		visited = new boolean[visited.length];
	}

	private void dfs(int vertex) {
		visited[vertex] = true;
		System.out.print(vertex + " ");

		al.get(vertex).forEach(adj -> {
			if (!visited[adj])
				dfs(adj);
		});

	}

	private void print() {
		al.forEach(System.out::println);
	}

	private void addEdge(int source, int dest) {
		// single directed
		al.get(source).add(dest);
		// bi-directional
		// al.get(dest).add(source);

	}

}
