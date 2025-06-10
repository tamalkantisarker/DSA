
// Detect cycle in undirected graph
import java.util.*;

class DFS {
    int x, y;

    DFS(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void dfs() {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= x; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < y; i++) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            list.get(n).add(m);
            list.get(m).add(n);
        }
        boolean[] visited = new boolean[x + 1];
        for (int i = 1; i <= x; i++) {
            if (!visited[i]) {
                if (dfs1(visited, list, i, -1) == true) {
                    System.out.println("Cycle has been found");
                    return;
                }
            }
        }
        System.out.println("No cycle has been found");
    }

    boolean dfs1(boolean[] visited, ArrayList<ArrayList<Integer>> list, int node, int parent) {
        visited[node] = true;
        for (int fed : list.get(node)) {
            if (!visited[fed]) {
                if (dfs1(visited, list, fed, node) == true) {
                    return true;
                }
            } else if (fed != parent) {
                return true;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        DFS d = new DFS(x, y);
        d.dfs();
    };
}
