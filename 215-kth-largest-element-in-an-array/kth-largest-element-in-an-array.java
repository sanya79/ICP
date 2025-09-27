class Solution {
    public int findKthLargest(int[] a, int k) {
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int i=0;i<a.length;i++){
            pq.add(a[i]);
            while(pq.size()>k){
                pq.remove();
            }
            
        }
        return pq.remove();

    }
}