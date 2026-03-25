import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int func(int length) {
        int a = 1;
        for(int i=0;i<length;i++) {
            a*=10;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int length = N.length();

        int res = 0;

        for(int i=1;i<=length;i++) {

            if(length == i) {
                int b = func(length-1);
                int a = Integer.parseInt(N);
                res += (a-b+1)*length;
            }
            else {
                int b = func(i-1);
                int a = func(i);
                res += (a-b)*i;
            }

        }

        System.out.println(res);

    }
}
