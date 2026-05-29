class Solution {
    public static int answer = 0;
    public static int[] selected = new int[3];
    
    public int solution(int[] nums) {
        
        check(nums, 0, 0);
        
        return answer;
    }
    
    public static void check(int[] num, int start, int depth){
        
        if(depth == 3){
            int now = 0;
            for(int i = 0; i<3; i++){
                now += selected[i];
            }
            
            if(find(now)){
                answer++;
            }
            
            return;
        }
        
        for(int i = start; i<num.length; i++){
            selected[depth] = num[i];
            check(num, i + 1, depth + 1);
        }
        
    }
    
    public static boolean find(int a){
        
        int checkpoint = a - 1;
        
        while(checkpoint != 1){
            if(a%checkpoint-- == 0) return false;
        }
        
        return true;
    }
}