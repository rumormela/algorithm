import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node{
        int y;
        int x;
        int day;
        public Node(int y, int x, int day) {
            this.y = y;
            this.x = x;
            this.day = day;
        }
    }

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int cnt;
    static Queue<Node> q = new ArrayDeque<>();
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int ans = -1;

    static void bfs() {

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int y = cur.y;
            int x = cur.x;
            int day = cur.day;
            if(--cnt == 0) {
                ans = day;
                break;
            }
            for(int i=0;i<4;i++) {
                int ny = y+dy[i];
                int nx = x+dx[i];
                if(ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                if(map[ny][nx] == 0 && !visited[ny][nx]) {
                    q.add(new Node(ny,nx,day+1));
                    visited[ny][nx] = true;
                    map[ny][nx] = 1;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        cnt = N*M;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                int a = Integer.parseInt(st.nextToken());
                map[i][j] = a;
                if(a == -1) cnt-=1;
                else if(a == 1) {
                    q.add(new Node(i,j,0));
                    visited[i][j] = true;
                }
            }
        }
        bfs();
        System.out.println(ans);
    }
}