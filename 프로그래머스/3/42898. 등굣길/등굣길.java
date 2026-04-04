import java.util.*;

class Solution {
    
    static int[][] res;
    
    static int func(int y, int x, int[][] puddles) {
        if(y < 0 || x < 0 || res[y][x] == -2) return 0;
        if(res[y][x] != -1) return res[y][x];
        return res[y][x] = (func(y-1,x,puddles)+func(y,x-1,puddles))%1000000007;
    }
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        res = new int[n][m];
        
        for(int i=0;i<n;i++) {
            Arrays.fill(res[i], -1);
        }
        
        for (int[] p : puddles) {
            res[p[1]-1][p[0]-1] = -2;
        }
        
        res[0][0] = 1;
        
        return func(n-1,m-1,puddles);
    }
}