
// Bridge code
import java.util.*;

public class BRIDGE {
    static int timer = 0;

    public static void dfs(int node, ArrayList<ArrayList<Integer>> list, boolean[] visited, int[] in, int[] low,
            Vector<Integer> bridge, int parent) {
        visited[node] = true;
        in[node] = low[node] = timer;
        timer++;
        for (int fed : list.get(node)) {
            if (parent == fed) {
                continue;
            }
            if (!visited[fed]) {
                dfs(fed, list, visited, in, low, bridge, node);
                low[node] = Math.min(low[fed], low[node]);
                if (low[fed] > in[node]) {
                    bridge.add(fed);
                    bridge.add(node);
                }
            } else {
                low[node] = Math.min(low[fed], low[node]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= x; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < y; i++) {
            int p = sc.nextInt();
            int q = sc.nextInt();
            list.get(p).add(q);
            list.get(q).add(p);
        }
        boolean[] visited = new boolean[x + 1];
        int[] in = new int[x + 1];
        int[] low = new int[x + 1];
        Vector<Integer> bridge = new Vector<>();
        int parent = -1;
        for (int i = 1; i <= x; i++) {
            if (!visited[i]) {
                dfs(i, list, visited, in, low, bridge, -1);
            }
        }
        for (int i = 0; i < bridge.size(); i += 2) {
            System.out.print(bridge.get(i) + " ");
            System.out.println(bridge.get(i + 1));
        }
    }
}
