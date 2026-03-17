import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static boolean[] visited;
    static int[] arr;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int depth, int start) {
        if(depth == M) {

            for(int i=0;i<M;i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for(int i=start;i<N;i++) {
            result[depth] = arr[i];
            dfs(depth+1, i);
            result[depth] = 0;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        arr = new int[N];
        result = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0, 0);
        System.out.println(sb.toString());
    }
}
