import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static List<Integer>[] list;
    static boolean[] visited;
    static int ans = 0;

    static class Node {
        int name;
        int depth;

        public Node(int name, int depth) {
            this.name = name;
            this. depth = depth;
        }

        public int getDepth() {
            return depth;
        }

        public int getName() {
            return name;
        }

        public void setDepth(int depth) {
            this.depth = depth;
        }

        public void setName(int name) {
            this.name = name;
        }
    }

    static void bfs() {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(1, 0));
        visited[1] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();
            int curName = cur.name;
            int curDepth = cur.depth;
            for(int nxt : list[curName]) {
                if(!visited[nxt]) {
                    visited[nxt] = true;
                    q.add(new Node(nxt, curDepth+1));
                    if(curDepth+1 <= 2) ans++;
                }
            }
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=1;i<=n;i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);

        }

        bfs();
        System.out.println(ans);

    }
}
