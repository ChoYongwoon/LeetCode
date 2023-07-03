class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()){return false;}
        int[] alphaS = new int[26];
        int[] alphaG = new int[26];
        int cnt = 0;
        int idx = -1;

        for(int i = 0; i < s.length(); i++){
            alphaS[s.charAt(i) - 'a']++;
            alphaG[goal.charAt(i) - 'a']++;
        }

        boolean check = false;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != goal.charAt(i)){
                if(cnt == 0){
                    cnt++;
                    idx = i;
                }
                else if(cnt == 1){
                    if(s.charAt(idx) == goal.charAt(i) && s.charAt(i) == goal.charAt(idx)){
                        check = true;
                    }
                    cnt++;
                }
                else{
                    cnt++;
                }
            }
        }

        if(cnt == 0){
            for(int i = 0; i < alphaS.length; i++){
                if(alphaS[i] > 1){
                    return true;
                }
            }
            return false;
        }
        else if(cnt == 2){
            if(check) return true;
            return false;
        }
        return false;
    }
}