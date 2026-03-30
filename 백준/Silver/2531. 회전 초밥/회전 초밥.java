import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, d, k, c;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[N+1];

        for(int i=1;i<=N;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int res = 0;
        for(int i=1;i<=N;i++) {
            visited = new boolean[3001];
            int cnt = 0;
            if(!visited[c]) {
                visited[c] = true;
                cnt++;
            }
            for(int j=i;j<=i+k-1;j++) {
                if(j == N) {
                    if(!visited[arr[j]]) {
                        visited[arr[j]] = true;
                        cnt++;
                    }
                }
                else {
                    if(!visited[arr[j%N]]) {
                        visited[arr[j%N]] = true;
                        cnt++;
                    }
                }
            }
            res = Math.max(res, cnt);
        }
        System.out.println(res);

    }
}
