import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
            
        int[] answer = new int[photo.length];
        Map<String, Integer> a = new HashMap<>();
        
        for(int i = 0; i<name.length; i++){
            a.put(name[i], yearning[i]);
        }
        
        Integer score;
        int sum;
        
        
        for(int i = 0; i<photo.length; i++){
            sum = 0;
            
            for(String p : photo[i]){
                score = a.get(p);
                
                if(score != null){
                    sum += score;
                }
            }
            
            answer[i] = sum;
        }
        
        return answer;
    }
}