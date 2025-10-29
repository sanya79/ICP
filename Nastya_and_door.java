import java.io.*;
import java.util.*;

public class Nastya_and_door {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder out = new StringBuilder();

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] a = new int[n + 1]; 
            for (int i = 1; i <= n; i++) a[i] = Integer.parseInt(st.nextToken());

            int[] peak = new int[n + 1]; 
            for (int i = 2; i <= n - 1; i++) {
                if (a[i] > a[i - 1] && a[i] > a[i + 1]) peak[i] = 1;
            }

            int[] pref = new int[n + 1];
            for (int i = 1; i <= n; i++) pref[i] = pref[i - 1] + peak[i];
            int bestPeaks = -1;
            int bestL = 1;
            for (int l = 1; l <= n - k + 1; l++) {
                int rIndex = l + k - 2;
                int curPeaks = 0;
                if (rIndex >= l + 1) {
                    curPeaks = pref[rIndex] - pref[l];
                } else {
                    curPeaks = 0;
                }
                if (curPeaks > bestPeaks) {
                    bestPeaks = curPeaks;
                    bestL = l;
                }
            }
            out.append((bestPeaks + 1)).append(" ").append(bestL).append("\n");
        }

        System.out.print(out.toString());
    }
}
