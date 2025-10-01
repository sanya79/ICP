class Solution {
    public boolean lemonadeChange(int[] bills) {
        int a[]=new int[3];
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5) a[0]++;
            else {
                if(bills[i]==10) {
                    a[1]++;
                    if(a[0]==0) return false;
                    a[0]--;
                }

                else {
                    a[2]++;
                    if(a[0]>=1 && a[1]>=1) {
                        a[0]--;
                        a[1]--;
                    }
                    else if(a[0]>=3) a[0]=a[0]-3;
                    else return false;
                }
            }
        }
        return true;
    }
}