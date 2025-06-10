
// Articulation point
import java.util.*;

public class Main {
    static int timer = 0;

    public static void dfs(int node, ArrayList<ArrayList<Integer>> list, boolean[] visited, int[] in, int[] low,
            int[] mark, int parent) {
        visited[node] = true;
        int child = 0;
        in[node] = low[node] = timer;
        timer++;
        for (int fed : list.get(node)) {
            if (fed == parent) {
                continue;
            }
            if (!visited[fed]) {
                dfs(fed, list, visited, in, low, mark, node);
                low[node] = Math.min(low[node], low[fed]);
                if (low[fed] >= in[node] && parent != -1) {
                    mark[node] = 1;
                }
                child++;
            } else {
                low[node] = Math.min(low[node], in[fed]);
            }
        }
        if (child > 1 && parent == -1) {
            mark[node] = 1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < y; i++) {
            int p = sc.nextInt();
            int q = sc.nextInt();
            list.get(p).add(q);
            list.get(q).add(p);
        }
        boolean[] visited = new boolean[x];
        int[] in = new int[x];
        int[] low = new int[x];
        int[] mark = new int[x];
        int parent = -1;
        for (int i = 0; i < x; i++) {
            if (!visited[i]) {
                dfs(i, list, visited, in, low, mark, parent);
            }
        }
        int count = 0;
        for (int i = 0; i < x; i++) {
            if (mark[i] == 1) {
                count++;
            }
        }
        System.out.println(count);
    }
}
