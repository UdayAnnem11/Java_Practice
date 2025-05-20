package DSA.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graph {
    private Map<Integer,List<Integer>> adj ;
    
    public Graph() {
        adj = new HashMap<>();
    }

    public void addEdge (int u , int v) {
        adj.putIfAbsent(u, new ArrayList<>());
        adj.putIfAbsent(v, new ArrayList<>());
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public void printGraph() {
        for (int node : adj.keySet()) {
            System.out.print(node + " -> ");
            for(int neighbour : adj.get(node)){
                System.out.print(neighbour + " ");
            }
            System.out.println();
        }
    }

    public void breadthFirstSearch (int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);

        while(!queue.isEmpty()){
            int node = queue.poll();
            System.out.print(node + " ");

            for(int neighbour : adj.get(node)){
                if(!visited.contains(neighbour)){
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
    }

    public void depthFirstSerach(int node , Set<Integer> visited) {
        visited.add(node);
        System.out.print(node + " ");
        for(int neighbour : adj.get(node)) {
            if(!visited.contains(neighbour)){
                depthFirstSerach(neighbour, visited);
            }
        }
    }

    public static void main(String [] args) {
        Graph g = new Graph();
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3,1);
        g.depthFirstSerach(0, new HashSet<>());
        g.printGraph();
        g.breadthFirstSearch(1);
    }
}
