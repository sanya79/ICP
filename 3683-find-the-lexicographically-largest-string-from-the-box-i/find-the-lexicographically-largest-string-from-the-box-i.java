class Solution {
    public String answerString(String word, int numFriends) {
        int n=word.length();
        String result="";
        if(numFriends==1){
            return word;
        }
        int longestPossible=n-(numFriends-1);
        for(int i=0;i<n;i++){
            int cantakeLength=Math.min(longestPossible,n-i);
            String sub=word.substring(i,i+cantakeLength);
            if(sub.compareTo(result)>0){
                result=sub;
            }
        }
        return result;  
    }
}