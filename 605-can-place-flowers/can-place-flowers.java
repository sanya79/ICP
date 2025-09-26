class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int l=flowerbed.length;
        for(int i=0;i<l && n>0;i++){
            if(flowerbed[i]==0){
                boolean leftempt=(i==0) || (flowerbed[i-1]==0) ;
                boolean rightempt=(i==l-1) || (flowerbed[i+1]==0) ;
                if(leftempt && rightempt){
                    flowerbed[i]=1;
                    n--;
                }
            
            }
        }
        return n==0;

    }
}