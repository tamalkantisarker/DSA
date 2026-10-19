import java.util.*;
import java.lang.*;

class DisjointSet {
    int parent[];
    int rank[];
    DisjointSet(int V) {
        parent = new int[V + 1];
        rank = new int[V + 1];
        for (int i = 0; i < V+1; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }
    int findparent(int node) {
        if (node == parent[node]) {
            return node;
        }
        else {
            return parent[node] = findparent(parent[node]);
        }
    }
    void union_by_rank(int u, int v) {
        u = findparent(u);
        v = findparent(v);
        if (u == v) {
            return;
        }
        else if (rank[u] > rank[v]) {
            parent[v] = u;
        }
        else if (rank[v] > rank[u]) {
            parent[u] = v;
        }
        else {
            parent[u] = v;
            rank[v]++;
        }
    }
}

public class Krushkal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V, E;
        V = sc.nextInt();
        E = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int u, v, w;
        for (int i = 0; i < E; i++) {
            u = sc.nextInt();
            v = sc.nextInt();
            w = sc.nextInt();
            ArrayList<Integer> l = new ArrayList<>(Arrays.asList(u, v, w));
            adj.add(l);
        }
        int cost = 0;
        Comparator<ArrayList<Integer>> cmp = new Comparator<ArrayList<Integer>>() {
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return Integer.compare(o1.get(2), o2.get(2));
            }
        };
        Collections.sort(adj, cmp);
        DisjointSet dj = new DisjointSet(V);
        for (int i = 0; i < E; i++) {
            u = adj.get(i).get(0);
            v = adj.get(i).get(1);
            w = adj.get(i).get(2);
            if (dj.findparent(u) != dj.findparent(v)) {
                dj.union_by_rank(u, v);
                cost += w;
            }
        }
        System.out.println(cost);
    }
}
