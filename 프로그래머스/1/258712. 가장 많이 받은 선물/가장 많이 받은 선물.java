import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        int answer = 0;
        
        Map<String, Integer> num = new HashMap<>();
        int[] total = new int[friends.length];
        
        for(int i = 0; i<friends.length; i++){
            num.put(friends[i], i);
        }
        
        int givep;
        int getp;
        
        
        int[][] base = new int[friends.length][friends.length];
        
        for(int i = 0; i<gifts.length; i++){
            StringTokenizer st = new StringTokenizer(gifts[i]);
            
            givep = num.get(st.nextToken());
            getp = num.get(st.nextToken());
            
            base[givep][getp]++;
        }
        
        for(int i = 0; i<friends.length; i++){
            int givetotal = 0;
            int gettotal = 0;
            
            for(int j = 0; j<friends.length; j++){
                givetotal += base[i][j];
                gettotal += base[j][i];
            }
            
            total[i] = givetotal - gettotal;
            
        }
        
        for(int i = 0; i<friends.length; i++){
            
            int nextget = 0;
            
            for(int j = 0; j<friends.length; j++){
                
                if(i == j)continue;
                
                if(base[i][j] > base[j][i]){
                    nextget++;
                } else if(base[i][j] == base[j][i]){
                    if(total[j] < total[i]){
                        nextget++;
                    }
                }
                
            }
            
            answer = Math.max(answer, nextget);
        }
        
        return answer;
    }
}