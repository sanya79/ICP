class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0){
                    return 0;
                }
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);        
        int count=0;
        int previous=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
                if(intervals[i][0]<previous){
                    count++;
                }
                else{
                    previous=intervals[i][1];
                }
            }
        return count;
    }
}