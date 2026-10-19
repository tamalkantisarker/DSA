import java.util.*;
import java.lang.*;
class Pair3 {
    int node;
    int weight;
    Pair3(int node, int weight){
        this.node = node;
        this.weight = weight;
    }
}
public class Prim {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int V,E;
        V = sc.nextInt();
        E = sc.nextInt();
        ArrayList<ArrayList<Pair3>> adj = new ArrayList<>();
        for(int i=0;i<V+1;i++){
            adj.add(new ArrayList<>());
        }
        int u,v,w;
        for(int i=0;i<E;i++){
            u = sc.nextInt();
            v = sc.nextInt();
            w = sc.nextInt();
            adj.get(u).add(new Pair3(v,w));
            adj.get(v).add(new Pair3(u,w));
        }
        boolean visited[] = new boolean[V+1];
        Arrays.fill(visited,false);
        PriorityQueue<Pair3> pq = new PriorityQueue<>(
                (a,b) -> a.weight - b.weight);
        pq.add(new Pair3(1,0));
        int cost = 0;
        while(!pq.isEmpty()){
            Pair3 p = pq.poll();
            int no = p.node;
            int weight = p.weight;
            if(visited[no]) continue;
            else{
                cost+=weight;
                visited[no]=true;
                for(Pair3 neigh:adj.get(no)){
                    if(!visited[neigh.node]){
                        pq.add(new Pair3(neigh.node, neigh.weight));
                    }
                }
            }
        }
        System.out.println(cost);
    }
}
