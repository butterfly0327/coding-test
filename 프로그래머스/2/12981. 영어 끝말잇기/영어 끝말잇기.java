import java.io.*;
import java.util.*;

class Solution {
    
    public static Set<String> s = new HashSet<>();
    public static int[] answer = {0, 0};
    public static String prev;
    public static String cur;
    
    public static boolean check(int n, String[] words){
        
        if(prev.charAt(prev.length() - 1) != cur.charAt(0) ||
           s.contains(cur)){
            return true;
        }
        
        s.add(cur);
        return false;
    }
    
    public int[] solution(int n, String[] words) {
        
        int len = words.length;
        s.add(words[0]);
        
        for(int i = 1; i<len; i++){
            prev = words[i-1];
            cur = words[i];
            if(check(n, words)){
                answer[0] = i%n + 1;
                answer[1] = i/n + 1;
                break;
            }
        }
        
        return answer;
    }
}