import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0,0,-1,1};

    static class Node{
        int y;
        int x;
        int cnt;
        public Node(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }

    static void bfs() {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0,0,1));
        visited[0][0] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();
            int y = cur.y;
            int x = cur.x;
            int cnt = cur.cnt;
            if(y == N-1 && x == M-1) {
                System.out.println(cnt);
                break;
            }

            for(int i=0;i<4;i++) {
                int ny = y+dy[i];
                int nx = x+dx[i];
                if(ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                if(map[ny][nx] == 1 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    q.add(new Node(ny, nx, cnt+1));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++) {
            String str = br.readLine();
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        bfs();

    }
}