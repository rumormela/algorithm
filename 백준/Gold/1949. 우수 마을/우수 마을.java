import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static List<Integer>[] adj;
    static int[] a;
    static int[] d1;
    static int[] d2;

    static int res = 0;

    static void dfs(int cur, int par) {
        d1[cur] = a[cur];
        d2[cur] = 0;

        for(int nxt : adj[cur]) {
            if(nxt == par) continue;
            dfs(nxt, cur);
            d1[cur] += d2[nxt];
            d2[cur] += Math.max(d1[nxt], d2[nxt]);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = new int[N+1];
        d1 = new int[N+1];
        d2 = new int[N+1];
        adj = new ArrayList[N+1];

        for(int i=1;i<=N;i++) {
            a[i] = Integer.parseInt(st.nextToken());
            adj[i] = new ArrayList<>();
        }

        for(int i=1;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        dfs(1, 0);
        System.out.println(Math.max(d1[1], d2[1]));

    }
}
