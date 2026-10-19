import java.util.*;
import java.lang.*;
class Pair{
    int node;
    int wt;
    Pair(int node, int wt){
        this.node = node;
        this.wt = wt;
    }
}
public class Dijkstra{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V,E;
        V = sc.nextInt();
        E = sc.nextInt();
        ArrayList<ArrayList<Pair>>adj = new ArrayList<>();
        for(int i=0;i<V+1;i++){
            adj.add(new ArrayList<>());
        }
        int u,v,w;
        for(int i=0;i<E;i++){
            u = sc.nextInt();
            v = sc.nextInt();
            w = sc.nextInt();
            adj.get(u).add(new Pair(v,w));
        }
        int source = sc.nextInt();
        boolean[] visited = new boolean[V+1];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->(a.wt - b.wt));
        pq.add(new Pair(source,0));
        int[] dist = new int[V+1];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);
        dist[source] = 0;
        while(!pq.isEmpty()){
            Pair node = pq.poll();
            int p1 = node.node;
            int p2 = node.wt;
            if(visited[p1]){
                continue;
            }
            visited[p1] = true;
            for(Pair child : adj.get(p1)){
                int child_node = child.node;
                int child_wt = child.wt;
                if(dist[p1]+child_wt < dist[child_node]){
                    dist[child_node] = dist[p1] + child_wt;
                    pq.add(new Pair(child_node,dist[child_node]));
                }
            }
        }
        for(int i=1;i<=V;i++){
            if(i!=source && dist[i]!=INF){
                System.out.print(dist[i]+" ");
            }
            else if(dist[i]==INF){
                System.out.print("-1"+ " ");
            }
        }
        System.out.println();
    }
}


















