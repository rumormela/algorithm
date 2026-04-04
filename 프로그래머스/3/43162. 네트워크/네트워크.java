import java.util.*;

class Solution {
    
    static boolean[] visited;
    
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                answer++;
                visited[i] = true;
                Queue<Integer> q = new ArrayDeque<>();
                q.add(i);
                
                while(!q.isEmpty()) {
                    int cur = q.poll();
                    System.out.println(cur);
                    for(int nxt=0;nxt<computers[0].length;nxt++) {
                        if(nxt == cur) continue;
                        if(!visited[nxt] && computers[cur][nxt] == 1) {
                            visited[nxt] = true;
                            q.add(nxt);
                        }
                    }
                }
            }
        }
        
        
        
        return answer;
    }
}