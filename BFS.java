This is the code for BFS
import java.util.*;
class Bfs {
   void b(ArrayList<ArrayList<Integer>> list, int startNode) {
       boolean[] visited = new boolean[list.size()];
       Queue<Integer> q = new LinkedList<>();
       visited[startNode] = true;
       q.add(startNode);
       while (!q.isEmpty()) {
           int current = q.poll();
           System.out.print(current + " ");
           for (int neighbor : list.get(current)) {
               if (!visited[neighbor]) {
                   visited[neighbor] = true;
                   q.add(neighbor);
               }
           }
       }
   }
}
public class BFS {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int m = sc.nextInt();
       ArrayList<ArrayList<Integer>> list = new ArrayList<>();
       for (int i = 0; i <= n; i++) {
           list.add(new ArrayList<>());
       }
       for (int i = 0; i < m; i++) {
           int u = sc.nextInt();
           int v = sc.nextInt();
           list.get(u).add(v);
           list.get(v).add(u);
       }
       int start = sc.nextInt();
       Bfs bfs = new Bfs();
       bfs.b(list, start);
   }
}
