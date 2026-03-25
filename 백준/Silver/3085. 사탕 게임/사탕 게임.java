import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static char[][] arr;
    static char[][] res;
    static int N;
    static int[] dy = {0, 1};
    static int[] dx = {1, 0};
    static int result = 0;

    static void copy() {
        res = new char[N][N];
        for(int i=0;i<N;i++) {
            res[i] = Arrays.copyOf(arr[i], N);
        }

    }

    static void count() {

        for(int i=0;i<N;i++) {
            int cnt = 0;
            char temp = ' ';
            for(int j=0;j<N;j++) {
                if(j == 0) {
                    cnt = 1;
                    temp = res[j][i];
                }
                else {
                    if(temp == res[j][i]) cnt+=1;
                    else cnt = 1;
                    temp = res[j][i];
                    result = Math.max(result, cnt);
                }
            }
        }

        for(int i=0;i<N;i++) {
            int cnt = 0;
            char temp = ' ';
            for(int j=0;j<N;j++) {
                if(j == 0) {
                    cnt = 1;
                    temp = res[i][j];
                }
                else {
                    if(temp == res[i][j]) cnt+=1;
                    else cnt = 1;
                    temp = res[i][j];
                    result = Math.max(result, cnt);
                }
            }
        }
    }

    static void func(int y, int x) {

        for(int i=0;i<2;i++) {
            int ny = dy[i]+y;
            int nx = dx[i]+x;
            if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
            copy();
            if(res[y][x] != res[ny][nx]) {

                char temp = arr[ny][nx];
                res[ny][nx] = res[y][x];
                res[y][x] = temp;

                count();

            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        for(int i=0;i<N;i++) {

            String str = br.readLine();

            for(int j=0;j<N;j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                func(i,j);
            }
        }

        System.out.println(result);

    }
}
