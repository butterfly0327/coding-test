import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        int[] answer = new int[id_list.length];
        
        
        
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i = 0; i<id_list.length; i++){
            list.add(new ArrayList<>());
        }
        
        Map<String, Integer> id = new HashMap<>();
        
        for(int i = 0; i<id_list.length; i++){
            id.put(id_list[i], i);
        }
        
        int[] stop = new int[id_list.length];
        
        for(int i = 0; i<report.length; i++){
            
            String[] cur = report[i].split(" ");
            String reporter = cur[0];
            String reported = cur[1];
            
            int reporternum = id.get(reporter);
            int reportednum = id.get(reported);
            
            if(!list.get(reporternum).contains(reportednum)){
                list.get(reporternum).add(reportednum);
                stop[reportednum]++;
            }
        }
        
        for(int i = 0; i<id_list.length; i++){
            
            if(stop[i] >= k){
                
                for(int j = 0; j<id_list.length; j++){
                    if(list.get(j).contains(i)){
                        answer[j]++;
                    }
                }
                
            } 
        }
        
        
        return answer;
    }
}