import java.util.*;

class Solution {
    
    static int[] arr;
    static int K;
    static int res = 0;
    
    static void dfs(int depth, int result) {
        if(depth == arr.length) {
            
            if(result == K) res++;
            
            return;
        }
        
        dfs(depth+1, result+arr[depth]);
        dfs(depth+1, result-arr[depth]);
        
    }
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        arr = new int[numbers.length];
        K = target;
        arr = Arrays.copyOf(numbers, numbers.length);
        dfs(0, 0);
        
        
        return res;
    }
}