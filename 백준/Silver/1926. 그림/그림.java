import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	
	static int[][] map;
	static boolean[][] visited;
	static int N, M;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int cnt = 0;
	static int max = 0;
	
	static class Node{
		int y;
		int x;
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static void bfs(int y, int x) {
		Queue<Node> q = new ArrayDeque();
		int size = 0;
		q.add(new Node(y, x));
		visited[y][x] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			y = cur.y;
			x = cur.x;
			size++;
			for(int i=0;i<4;i++) {
				int ny = y+dy[i];
				int nx = x+dx[i];
				if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
				if(!visited[ny][nx] && map[ny][nx] == 1) {
					q.add(new Node(ny, nx));
					visited[ny][nx] = true;
				}
			}
		}
		max = Math.max(size, max);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(max);
		
	}
}
