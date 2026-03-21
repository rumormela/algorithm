import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, K;
    static boolean[] visited;
    static List<Integer>[] list;
    static int ans = 0;


    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        visited[1] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int nxt : list[cur]) {
                if(!visited[nxt]) {
                    ans++;
                    q.add(nxt);
                    visited[nxt] = true;
                }
            }
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];

        visited = new boolean[N+1];
        for(int i=1;i<=N;i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<K;i++) {
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
