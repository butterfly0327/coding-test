import java.io.*;
import java.util.*;

class Solution {
    
    public static int[][] drx = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    public static boolean[][] visited;
    public static int N, M, sum;
    public static Queue<int[]> q;
    public static ArrayList<Integer> answer;
    
    public static void find(String[] maps){
        
        int x, y, nx, ny;
        int[] cur = new int[2];
        
        while(!q.isEmpty()){

            cur = q.poll();
            x = cur[0];
            y = cur[1];
            
            for(int i = 0; i<4; i++){
    
                nx = x + drx[i][0];
                ny = y + drx[i][1];
                
                if(nx < 0 || nx >= N || ny < 0 || ny >= M)continue;
                if(visited[nx][ny] || maps[nx].charAt(ny) == 'X')continue;
                sum += maps[nx].charAt(ny) - '0';
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
            
        
        }
        
        answer.add(sum); 
    }
    
    
    public int[] solution(String[] maps) {
        
        N = maps.length;
        M = maps[0].length();
        
        visited = new boolean[N][M];
        q = new ArrayDeque<>();
        answer = new ArrayList<>();
        
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(visited[i][j] || maps[i].charAt(j) == 'X')continue;
                q.offer(new int[]{i, j});
                visited[i][j] = true;
                sum = maps[i].charAt(j) - '0';
                find(maps);
            }
        }
        
        if(answer.size() == 0){
            int[] res = new int[1];
            res[0] = -1;
            return res;
        } else {
            Collections.sort(answer);
            int[] res = new int[answer.size()];
            int index = 0;
            for(int i : answer){
                res[index++] = i;
            }
            return res;
        }
    }
}