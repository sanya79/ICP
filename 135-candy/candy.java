class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] count = new int[n];
        count[0] = 1;
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                count[i]=count[i-1]+1;
            }
            else{
                count[i]=1;
            }
        }
        int[] counts=new int[n];
        counts[n-1]=1;
        for(int j=n-2;j>=0;j--){
            if(ratings[j]>ratings[j+1]){
                counts[j]=counts[j+1]+1;
            }
            else{
                counts[j]=1;
            }
        }
        int index=0;
        for(int k=0;k<n;k++){
            index=index+Math.max(count[k],counts[k]);
        }
        return index;
    }
}