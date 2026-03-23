import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[3000001];

        Arrays.fill(arr, 1000001);
        arr[1] = 0;

        for(int i=1;i<=1000000;i++) {
            arr[3*i] = Math.min(arr[i]+1, arr[3*i]);
            arr[2*i] = Math.min(arr[i]+1, arr[2*i]);
            arr[i+1] = Math.min(arr[i]+1, arr[i+1]);
        }

        System.out.println(arr[N]);

    }
}
