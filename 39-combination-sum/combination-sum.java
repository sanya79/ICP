import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum(int[] c, int rem) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(c);
        dfs(ans, new ArrayList<>(), c, rem, 0);
        return ans;
    }
    public static void dfs(List<List<Integer>> ans, List<Integer> cur, int[] c, int rem, int s) {
        if (rem == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = s; i < c.length; i++) {
         //   if (i > s && c[i] == c[i - 1] ) continue; 
            if (c[i] <= rem){
            cur.add(c[i]);
            dfs(ans, cur, c, rem - c[i], i );
            cur.remove(cur.size() - 1);
        }
        }
    }
}
