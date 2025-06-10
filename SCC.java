// This is code Strongly connected components
import java.util.*;
class Check{
    int x,y;
    Check(int x,int y) {
        this.x = x;
        this.y = y;
    }
    void check1(){
        ArrayList<ArrayList<Integer>>list = new ArrayList<>();
        ArrayList<ArrayList<Integer>>list1 = new ArrayList<>();
        for(int i=0;i<=x;i++){
            list1.add(new ArrayList<>());
        }
        for(int i=0;i<=x;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<y;i++){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            list.get(n).add(m);
            list1.get(m).add(n);
        }
        boolean [] visited = new boolean[x+1];
        boolean [] visited1 = new boolean[x+1];
        Stack<Integer>s = new Stack();
        for(int i=1;i<=x;i++){
            if(!visited[i]){
                dfs(list,i,visited,s);
            }
        }
        int count = 0;
        while(!s.empty()){
            int current = s.pop();
            if(!visited1[current]){
                dfs2(list1,current,visited1);
                count++;
            }
        }
        System.out.println(count);
    }
    void dfs2(ArrayList<ArrayList<Integer>>list1,int node,boolean[]visited1){
        visited1[node] = true;
        for(int fed : list1.get(node)){
            if(!visited1[fed]){
                dfs2(list1,fed,visited1);
            }
        }
    }
    void dfs(ArrayList<ArrayList<Integer>>list,int node,boolean[]visited,Stack<Integer>s){
        visited[node] = true;
        for(int fed : list.get(node)){
            if(!visited[fed]){
                dfs(list,fed,visited,s);
            }
        }
        s.push(node);
    }
}
public class SCC{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        Check c = new Check(x,y);
        c.check1();
    }
}