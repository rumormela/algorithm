import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, K, W;
    static int[] d;
    static int[] a;
    static List<Integer>[] adj;

    static int func(int cur) {
        if(a[cur] != -1)  return a[cur];

        a[cur] = 0;
        for(int pre : adj[cur]) {
            a[cur] = Math.max(a[cur], func(pre));
        }
        a[cur] += d[cur];

        return a[cur];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while(tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            a = new int[N+1];
            d = new int[N+1];
            adj = new ArrayList[N+1];

            st = new StringTokenizer(br.readLine());

            for(int i=1;i<=N;i++) {
                a[i] = -1;
                d[i] = Integer.parseInt(st.nextToken());
                adj[i] = new ArrayList<>();
            }

            for(int i=1;i<=K;i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                adj[y].add(x);
            }

            W = Integer.parseInt(br.readLine());

            System.out.println(func(W));

        }

    }
}
