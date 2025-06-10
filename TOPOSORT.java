this is the code for topological sort
import java.io.*;
import java.util.*;
class Graph {
    File file;
    Graph(File file) {
        this.file = file;
    }
    void topologicalSort() {
        try {
            if (!file.exists()) {
                System.out.println("Error: File not found!");
                return;
            }
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
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < x; i++) {
                if (!visited[i]) {
                    dfs(i, list, visited, stack);
                }
            }
            System.out.println("Topological Sort:");
            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
            System.out.println();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    void dfs(int node, ArrayList<ArrayList<Integer>> list, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for (int neighbor : list.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, list, visited, stack);
            }
        }
        stack.push(node);
    }
}
public class TOPOSORT {
    public static void main(String[] args) {
        File file = new File("Index.txt");
        Graph g = new Graph(file);
        g.topologicalSort();
    }
}
