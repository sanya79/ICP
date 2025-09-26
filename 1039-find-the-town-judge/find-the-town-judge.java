class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] count=new int[n+1];
        for(int[] t:trust){
            int u=t[0];
            int v=t[1];
            count[u]--;
            count[v]++;
        }
        for(int i=1;i<=n;i++){
            if(count[i]==n-1 ){
                return i;
            }
        }
        return -1;
        
    }
}