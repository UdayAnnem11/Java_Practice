package DSA.Graphs;

import java.util.*;
import java.util.LinkedList;

public class GraphWeighted {

    // Pair class to store node and weight
    static class Pair {
        int node, weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    // Graph adjacency list (weighted)
    private Map<Integer, List<Pair>> adj;

    public GraphWeighted() {
        adj = new HashMap<>();
    }

    // Add an edge (set directed = false for undirected graph)
    public void addEdge(int u, int v, int w, boolean directed) {
        adj.putIfAbsent(u, new ArrayList<>());
        adj.get(u).add(new Pair(v, w));

        if (!directed) {
            adj.putIfAbsent(v, new ArrayList<>());
            adj.get(v).add(new Pair(u, w));
        }
    }

    // Print the graph
    public void printGraph() {
        System.out.println("Graph:");
        for (int node : adj.keySet()) {
            System.out.print(node + " -> ");
            for (Pair p : adj.get(node)) {
                System.out.print("(" + p.node + ", w=" + p.weight + ") ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // BFS
    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        System.out.print("BFS: ");
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (Pair neighbor : adj.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor.node)) {
                    visited.add(neighbor.node);
                    queue.add(neighbor.node);
                }
            }
        }
        System.out.println();
    }

    public void dijkstra(int src) {
        Map<Integer, Integer> dist = new HashMap<>();
        for (int node : adj.keySet()) {
            dist.put(node, Integer.MAX_VALUE);
        }
        dist.put(src, 0);

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.weight));
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node;

            for (Pair neighbor : adj.getOrDefault(u, new ArrayList<>())) {
                int v = neighbor.node;
                int weight = neighbor.weight;

                if (dist.get(u) + weight < dist.getOrDefault(v, Integer.MAX_VALUE)) {
                    dist.put(v, dist.get(u) + weight);
                    pq.add(new Pair(v, dist.get(v)));
                    
                }
            }
        }

        System.out.println("Dijkstra (from " + src + "):");
        for (int node : dist.keySet()) {
            System.out.println("To " + node + " -> " + dist.get(node));
        }
        System.out.println();
    }
    
    // DFS
    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        System.out.print("DFS: ");
        dfsHelper(start, visited);
        System.out.println();
    }

    private void dfsHelper(int node, Set<Integer> visited) {
        visited.add(node);
        System.out.print(node + " ");

        for (Pair neighbor : adj.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor.node)) {
                dfsHelper(neighbor.node, visited);
            }
        }
    }

    public void topologicalSort() {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        for (int node : adj.keySet()) {
            if (!visited.contains(node)) {
                topoDFS(node, visited, stack);
            }
        }

        System.out.print("Topological Sort: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    private void topoDFS(int node, Set<Integer> visited, Stack<Integer> stack) {
        visited.add(node);

        for (Pair neighbor : adj.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor.node)) {
                topoDFS(neighbor.node, visited, stack);
            }
        }

        stack.push(node);
    }

    // Main method to run everything
    public static void main(String[] args) {
        GraphWeighted g = new GraphWeighted();

        // Creating a directed weighted graph
        g.addEdge(0, 1, 2, true);
        g.addEdge(0, 2, 4, true);
        g.addEdge(1, 2, 1, true);
        
        g.printGraph();

        g.bfs(0);
        g.dfs(0);

        g.dijkstra(0);

       // g.topologicalSort(); // Only works correctly if graph is a DAG
    }
}

