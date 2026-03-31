import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] arr;
    static boolean[] visited;

    static int[] func1(int[] arr) {
        int[] nxtarr = new int[arr.length];

        for(int i=0;i<arr.length;i++) {
            nxtarr[(i+1)%arr.length] = arr[i];
        }

        return nxtarr;
    }

    static boolean[] funcRobot1(boolean[] visited) {
        boolean[] nxtVisited = new boolean[visited.length];

        for(int i=0;i<visited.length;i++) {
            nxtVisited[(i+1)%visited.length] = visited[i];
        }

        return nxtVisited;
    }

    static void func2() {
        for(int i=N-2;i>=0;i--) {
            if(visited[i]) {
                if(arr[i+1] >= 1 && !visited[i+1]) {
                    arr[i+1]--;
                    visited[i+1] = true;
                    visited[i] = false;
                    exitRobot();
                }
            }
        }
    }

    static void exitRobot() {
        if(visited[N-1]) visited[N-1] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[2*N];
        visited = new boolean[N];

        for(int i=0;i<2*N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int res = 0;
        while (true) {

            // 1번
            arr = func1(arr);
            visited = funcRobot1(visited);
            exitRobot();
            // 2번
            func2();
            if(arr[0] >= 1) {
                visited[0] = true;
                arr[0]--;
            }
            int cnt = 0;
            for(int i=0;i<2*N;i++) {
                if(arr[i] == 0) cnt++;
            }
            res++;

            if(cnt >= K) {
                break;
            }
            else {
                continue;
            }

        }

        System.out.println(res);

    }
}
