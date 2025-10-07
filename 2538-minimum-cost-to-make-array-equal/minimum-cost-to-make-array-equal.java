class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n=nums.length;
        int[][] arr=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=nums[i];
            arr[i][1]=cost[i];
        }
        Arrays.sort(arr,Comparator.comparingInt(a->a[0]));
        long totalCost=0;
        for(int c:cost) totalCost+=c;
        long half=(totalCost+1)/2;

        long cumulative=0;
        int median=0;
        for(int i=0;i<n;i++){
            cumulative+=arr[i][1];
            if(cumulative>=half){
                median=arr[i][0];
                break;
            }
        }
        long ans=0;
        for(int i=0;i<n;i++){
            ans+=(long) Math.abs(arr[i][0]-median)* arr[i][1];
        }
        return ans;  
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        int[] cost=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            cost[i]=sc.nextInt();
        }
        Solution sol=new Solution();
        long result= sol.minCost(nums,cost);
        System.out.println(result);
        sc.close();
    }
}