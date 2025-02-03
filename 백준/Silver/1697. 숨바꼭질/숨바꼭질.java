import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] map = new int[200001];
    static int[] cnt = new int[200001];
    static int N, K;

    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(N);
        cnt[N] = 0;

        while(!q.isEmpty()) {
            int cur = q.poll();
            if(cur-1 >= 0 && cnt[cur-1] == 0x3f3f3f3f) {
                cnt[cur-1] = cnt[cur]+1;
                q.add(cur-1);
            }
            if(cur+1 <= 200000 && cnt[cur+1] == 0x3f3f3f3f) {
                cnt[cur+1] = cnt[cur]+1;
                q.add(cur+1);
            }
            if(cur*2 <= 200000 && cnt[cur*2] == 0x3f3f3f3f) {
                cnt[cur*2] = cnt[cur]+1;
                q.add(cur*2);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Arrays.fill(cnt, 0x3f3f3f3f);
        bfs();
        System.out.println(cnt[K]);
    }
}