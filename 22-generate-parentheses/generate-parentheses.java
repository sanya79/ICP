class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ll=new ArrayList<>();
        GenerateParentheses(ll,n,0,0,"");
        return ll;
    }
        public static void GenerateParentheses(List<String> ll,int n ,int open ,int close,String ans){

        if(open == n && close==n){
            ll.add(ans);
            return;
        }
        if(open < n){
            GenerateParentheses(ll,n,open+1,close,ans+"(");
        }
        if(close < open){
            GenerateParentheses(ll,n,open,close+1,ans+")");
        }
    }
}