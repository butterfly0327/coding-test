import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        
        
        String[] result = new String[4];
        
        StringBuilder sb = new StringBuilder();
        
        Map<Character, Integer> a = new HashMap<>();
        
        a.put('R', 0);
        a.put('T', 0);
        a.put('C', 0);
        a.put('F', 0);
        a.put('J', 0);
        a.put('M', 0);
        a.put('A', 0);
        a.put('N', 0);
        
        for(int i = 0; i<survey.length; i++){
            String what = survey[i];
            
            char low = what.charAt(0);
            char high = what.charAt(1);
            
            int se = choices[i];
            
            int lownum = a.get(low);
            int highnum = a.get(high);
            
            
            if(se <= 3){
                
                if(se == 1){
                    a.put(low, lownum + 3);                  
                } else if(se == 2){
                    a.put(low, lownum + 2);
                } else if(se == 3){
                    a.put(low, lownum + 1);
                }
                
            } else if(se >= 5){
                
                if(se == 5){
                    a.put(high, highnum + 1);
                } else if(se == 6){
                    a.put(high, highnum + 2);
                } else if(se == 7){
                    a.put(high, highnum + 3);
                }
            }
        }
        
        
        if(a.get('R') >= a.get('T')){
            result[0] = "R";
        } else if(a.get('T') > a.get('R')){
            result[0] = "T";
        } 
        
        if(a.get('C') >= a.get('F')){
            result[1] = "C";
        } else if(a.get('F') > a.get('C')){
            result[1] = "F";
        } 
        
        if(a.get('J') >= a.get('M')){
            result[2] = "J";
        } else if(a.get('M') > a.get('J')){
            result[2] = "M";
        } 
        
        if(a.get('A') >= a.get('N')){
            result[3] = "A";
        } else if(a.get('N') > a.get('A')){
            result[3] = "N";
        } 
        
        for(int i = 0; i<4; i++){
            sb.append(result[i]);
        }
        
        
        String answer = sb.toString();
        
        return answer;
    }
}