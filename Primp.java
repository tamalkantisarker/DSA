import java.util.*;
import java.lang.*;
class Pair1{
    int node;
    int wt;
    Pair1(int node,int wt){
        this.node = node;
        this.wt = wt;
    }
}
public class Primp{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V,E;
        V = sc.nextInt();
        E = sc.nextInt();
        ArrayList<ArrayList<Pair1>>adj = new ArrayList<>();
        for(int i=0;i<V+1;i++){
            adj.add(new ArrayList<>());
        }
        int u,v,w;
        for(int i=0;i<E;i++){
            u = sc.nextInt();
            v = sc.nextInt();
            w = sc.nextInt();
            adj.get(u).add(new Pair1(v,w));
            adj.get(v).add(new Pair1(u,w));
        }
        PriorityQueue<Pair1>pq = new PriorityQueue<>((a,b)->(a.wt - b.wt));
        pq.add(new Pair1(1,0));
        int cost = 0;
        boolean[] visited = new boolean[V+1];
        while(!pq.isEmpty()){
            Pair1 k = pq.poll();
            int node = k.node;
            int wt = k.wt;
            if(visited[node]) continue;
            else{
                cost+=wt;
                visited[node]=true;
                for(Pair1 p : adj.get(node)){
                    if(!visited[p.node]){
                        pq.add(new Pair1(p.node,p.wt));
                    }
                }
            }
        }
        System.out.println("Total cost : "+cost);
    }
}