import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> order = new HashMap<>();
        
         for(int i = 0; i<players.length; i++){
             order.put(players[i], i);
         }
        
        for(int i = 0; i<callings.length; i++){
            String cur = callings[i];
            int index = order.get(cur);
            
            String temp = players[index - 1];
            players[index - 1] = cur;
            players[index] = temp;
            
            order.put(temp, index);
            order.put(cur, index - 1);
            
            
        }
        
        
        return players;
    }
}