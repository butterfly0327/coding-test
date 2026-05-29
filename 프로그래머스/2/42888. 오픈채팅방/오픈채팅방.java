import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        String[] check;
        String[] answer;
        int count = 0;
        
        for(String current : record){
            check = current.split(" ");
            if(check[0].equals("Enter")){
                map.put(check[1], check[2]);
                count++;
            } else if(check[0].equals("Change")){
                map.put(check[1], check[2]);
            } else {
                count++;
            }
        }
        
        answer = new String[count];
        
        int index = 0;
        
        for(String current : record){
            check = current.split(" ");
            if(check[0].equals("Enter")){
                answer[index++] = map.get(check[1]) + "님이 들어왔습니다.";
            } else if(check[0].equals("Leave")){
                answer[index++] = map.get(check[1]) + "님이 나갔습니다.";
            }
            
        }
        
        
        
        return answer;
    }
}