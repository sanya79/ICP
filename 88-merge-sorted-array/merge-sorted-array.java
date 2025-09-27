class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] med=new int[n+m];
        for(int i=0;i<m;i++){
            med[i]=nums1[i];
        }
        for(int j=0;j<n;j++){
            med[m+j]=nums2[j];
        }
        Arrays.sort(med);
        for(int k=0;k<m+n;k++){
            nums1[k]=med[k];
        }
        
    }
}