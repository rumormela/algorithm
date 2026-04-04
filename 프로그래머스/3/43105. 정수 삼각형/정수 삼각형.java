import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int height = triangle.length;
        int[][] res = new int[height][height];
        res[0][0] = triangle[0][0];
        
        for(int i=1;i<height;i++) {
            for(int j=0;j<triangle[i].length;j++) {
                if(j == 0) res[i][j] = res[i-1][j] + triangle[i][j];
                else if(j == height-1) res[i][j] = res[i-1][j-1] + triangle[i][j];
                else res[i][j] = Math.max(res[i-1][j-1], res[i-1][j])+triangle[i][j];
            }    
        }
                
        for(int i=0;i<height;i++) {
            answer = Math.max(answer, res[height-1][i]);
        }
        
        return answer;
    }
}