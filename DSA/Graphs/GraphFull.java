package DSA.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;



public class GraphFull {

    static class Pair {
        int node;
        int weight;

        Pair(int node , int weight) {
            this.node = node ;
            this.weight = weight ;
        }
    }
    private Map<Integer, List<Pair>> adj;
    public GraphFull(){
        adj = new HashMap<>();
    }

    public void addEdge(int u, int v, int w, boolean directed){
        adj.putIfAbsent(u, new ArrayList<>());
        adj.get(u).add(new Pair(v,w));
        if(!directed){
            adj.putIfAbsent(v, new ArrayList<>());
            adj.get(v).add(new Pair(u,w));
        }
    }

    public void PrintGraph(){
        for(int node : adj.keySet()){
            System.out.print(node + " -> ");
            for(Pair p : adj.get(node)){
                 System.out.print("(" + p.node + ", w=" + p.weight + ") ");
            }
            System.out.println();
        }
    }
    
    public void BFS(int start){
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>() ;
        visited.add(start);
        queue.add(start);

        while(!queue.isEmpty()){
            int node = queue.poll();
            System.out.print(node + " -> ");
            for(Pair p : adj.getOrDefault(node,new ArrayList<>())){
                if(!visited.contains(p.node)){
                    visited.add(p.node);
                    queue.add(p.node);
                }
            }
        }
    }

    public void DFS(int start , Set<Integer> visited){
        visited.add(start);
        System.out.print(start + " -> ");
        for(Pair p : adj.getOrDefault(start, new ArrayList<>())){
            if(!visited.contains(p.node)){
                DFS(p.node, visited);
            }
        }
    }
    public static void main(String [] args ){
        GraphFull g = new GraphFull();
        g.addEdge(0, 1, 2, true);
        g.addEdge(0, 2, 4, true);
        g.addEdge(1, 2, 1, true);
        g.addEdge(1, 3, 7, true);
        g.addEdge(2, 4, 3, true);
        g.addEdge(3, 5, 1, true);
        g.addEdge(4, 3, 2, true);
        g.addEdge(4, 5, 5, true);

        g.PrintGraph();

        g.BFS(0);

        System.out.println();

        g.DFS(0, new HashSet<>());

    }
}
