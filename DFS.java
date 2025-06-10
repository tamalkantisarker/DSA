
// This is the code for DFS -- depth first search
// This is the real code for dfs
import java.io.*;
import java.util.*;

class Graph {
    File file;

    Graph(File file) {
        this.file = file;
    }

    void DFS() {
        try {
            if (!file.exists()) {
                System.out.println("Error: File not found!");
                return;
            }
            int p = 0;
            Scanner sc = new Scanner(file);
            int x = sc.nextInt();
            int y = sc.nextInt();
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for (int i = 0; i <= x; i++) {
                list.add(new ArrayList<>());
            }
            for (int i = 0; i < y; i++) {
                int v = sc.nextInt();
                int u = sc.nextInt();
                list.get(v).add(u);
            }
            sc.close();
            boolean[] visited = new boolean[x + 1];
            for (int i = 1; i <= x; i++) {
                if (!visited[i]) {
                    dfs(i, list, visited);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void dfs(int node, ArrayList<ArrayList<Integer>> list, boolean[] visited) {
        visited[node] = true;
        System.out.println(node);
        for (int neighbor : list.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, list, visited);
            }
        }
    }
}

public class DFS {
    public static void main(String[] args) {
        File file = new File("Index.txt");
        Graph g = new Graph(file);
        g.DFS();
    }
}