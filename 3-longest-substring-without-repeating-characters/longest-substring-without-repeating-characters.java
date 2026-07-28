class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0,j=0,best=0;
        

        while(j<s.length()){
            if(s.substring(i,j).contains(String.valueOf(s.charAt(j)))){
                i++;
            }
            if(!(s.substring(i,j).contains(String.valueOf(s.charAt(j))))){
                j++;
                best = Math.max(best,j-i);
            }
            
        }

        return best;
    }
}





















 // int i = 0,j=0, best = 0;
        // String temp = "";
        // while (j<s.length()){
            
        //     if(temp.contains(String.valueOf(s.charAt(j)))){
        //         i++;
        //         //curr = temp.length();
        //         temp = s.substring(i, j);
        //     }
        //     if(!temp.contains(String.valueOf(s.charAt(j)))){
        //     temp += s.charAt(j);
        //     best = Math.max(j-i+1, best);
        //     j++;
        //     }
            
        // }