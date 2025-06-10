import java.util.*;

class Pair {
    int node;
    int wt;

    Pair(int node, int wt) {
        this.node = node;
        this.wt = wt;
    }
}

public class Dijkstra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V, E;
        V = sc.nextInt();
        E = sc.nextInt();
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) {
            adj.add(new ArrayList<>());
        }
        int u, v, w;
        for (int i = 0; i < E; i++) {
            u = sc.nextInt();
            v = sc.nextInt();
            w = sc.nextInt();
            adj.get(u).add(new Pair(v, w));
        }
        boolean[] visited = new boolean[V + 1];
        int[] dist = new int[V + 1];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.wt - b.wt));
        int source = sc.nextInt();
        dist[source] = 0;
        pq.add(new Pair(source, 0));
        while (!pq.isEmpty()) {
            Pair k = pq.poll();
            int node = k.node;
            int wt = k.wt;
            if (visited[node])
                continue;
            else {
                visited[node] = true;
                for (Pair child : adj.get(node)) {
                    if (dist[node] + child.wt < dist[child.node]) {
                        dist[child.node] = dist[node] + child.wt;
                        pq.add(new Pair(child.node, dist[child.node]));
                    }
                }
            }
        }
        for (int i = 1; i <= V; i++) {
            if (i != source && dist[i] != INF) {
                System.out.print(dist[i] + " ");
            } else if (dist[i] == INF) {
                System.out.print("-1" + " ");
            }
        }
        System.out.println();
    }

}
