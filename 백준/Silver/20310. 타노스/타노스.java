import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[2];
        boolean[] visited = new boolean[str.length()];
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i) == '1') arr[1]++;
            else arr[0]++;
        }

        arr[0] = arr[0] / 2;
        arr[1] = arr[1] / 2;
        int legnth1 = str.length()-1;
        int legnth2 = 0;
        while (arr[0] > 0) {
            if(str.charAt(legnth1) == '0') {
                visited[legnth1] = true;
                arr[0]--;
            }
            legnth1-=1;
        }

        while (arr[1] > 0) {
            if(str.charAt(legnth2) == '1') {
                visited[legnth2] = true;
                arr[1]--;
            }
            legnth2+=1;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<str.length();i++) {
            if(!visited[i]) {
                sb.append(str.charAt(i));
            }
        }

        System.out.println(sb.toString());

    }
}
