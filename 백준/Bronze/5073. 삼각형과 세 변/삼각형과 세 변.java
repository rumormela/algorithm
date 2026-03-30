import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int a,b,c;
    static int[] arr;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if(a == 0 && b == 0 && c == 0) {
                break;
            }
            arr = new int[3];
            visited = new int[1001];
            arr[0] = a;
            arr[1] = b;
            arr[2] = c;
            Arrays.sort(arr);

            if(arr[2] >= arr[1] + arr[0]) {
                System.out.println("Invalid");
                continue;
            }

            for(int i=0;i<3;i++) {
                visited[arr[i]] += 1;
            }

            if(visited[arr[1]] == 3) {
                System.out.println("Equilateral");
            }
            else if(visited[arr[1]] == 2) {
                System.out.println("Isosceles");
            }
            else {
                System.out.println("Scalene");
            }


        }
    }
}
