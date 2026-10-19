import java.util.*;
public class Belmanp{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V,E;
        V = sc.nextInt();
        E = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int u,v,w;
        for(int i=0;i<E;i++){
            u = sc.nextInt();
            v = sc.nextInt();
            w = sc.nextInt();
            ArrayList<Integer>l = new ArrayList<>(Arrays.asList(u,v,w));
            adj.add(l);
        }
        int source = sc.nextInt();
        int []dist = new int[V+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[source] = 0;
        for(int i=0;i<V-1;i++){
            for(int j=0;j<E;j++){
                int st = adj.get(j).get(0);
                int end = adj.get(j).get(1);
                int wt = adj.get(j).get(2);
                if(dist[st]!=Integer.MAX_VALUE && dist[end]>dist[st]+wt){
                    dist[end] = dist[st]+wt;
                }
            }
        }
        for(int i=1;i<=V;i++){
            if(i!=source && dist[i]!=Integer.MAX_VALUE){
                System.out.print(dist[i]+" ");
            }
            else if(dist[i]==Integer.MAX_VALUE){
                System.out.println("-1"+" ");
            }
        }
        System.out.println();
    }
}