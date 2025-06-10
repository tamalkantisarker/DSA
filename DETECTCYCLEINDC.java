
// This is the code for cycle detection in directed graph
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
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < y; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            list.get(u).add(v);
        }
        boolean[] visited = new boolean[x + 1];
        boolean[] recStack = new boolean[x + 1];
        for (int i = 1; i <= x; i++) {
            if (!visited[i]) {
                if (dfs1(i, list, visited, recStack)) {
                    System.out.println("Cycle has been found");
                    return;
                }
            }
        }

        System.out.println("No cycle has been found");
    }

    boolean dfs1(int node, ArrayList<ArrayList<Integer>> list, boolean[] visited, boolean[] recStack) {
        visited[node] = true;
        recStack[node] = true;
        for (int neighbor : list.get(node)) {
            if (!visited[neighbor]) {
                if (dfs1(neighbor, list, visited, recStack)) {
                    return true;
                }
            } else if (recStack[neighbor]) {
                return true;
            }
        }
        recStack[node] = false;
        return false;
    }
}

public class DETECTCYCLEINDC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        DFS d = new DFS(x, y);
        d.dfs();
    }
}