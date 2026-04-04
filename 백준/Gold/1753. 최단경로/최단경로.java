import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node>{
        int vertex;
        int cost;
        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int V, E, K;
    static List<Node>[] list;
    static int[] res;
    static int INF = 0x3f3f3f3f;

    static void func() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(K, 0));
        res[K] = 0;

        while(!q.isEmpty()) {
            Node cur = q.poll();
            int vertex = cur.vertex;
            int cost = cur.cost;

            for(Node nxt : list[vertex]) {
                if(res[nxt.vertex] <= res[cur.vertex]+nxt.cost) continue;
                res[nxt.vertex] = res[cur.vertex]+nxt.cost;
                q.add(new Node(nxt.vertex, res[nxt.vertex]));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        res = new int[V+1];
        list = new ArrayList[V+1];
        for(int i=1;i<=V;i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<E;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v,cost));
        }

        Arrays.fill(res, INF);

        func();

        for(int i=1;i<=V;i++) {
            if(res[i] == 0x3f3f3f3f) System.out.println("INF");
            else System.out.println(res[i]);
        }

    }
}
