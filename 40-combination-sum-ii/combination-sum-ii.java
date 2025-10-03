import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum2(int[] a, int t) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(a);
        dfs(ans, new ArrayList<>(), a, t, 0);
        return ans;
    }
    void dfs(List<List<Integer>> ans, List<Integer> cur, int[] a, int rem, int s) {
        if (rem == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = s; i < a.length; i++) {
            if (i > s && a[i] == a[i - 1]) continue; 
            if (a[i] > rem) break;
            cur.add(a[i]);
            dfs(ans, cur, a, rem - a[i], i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
