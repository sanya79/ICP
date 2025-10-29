import java.io.*;
import java.util.*;

public class Recursive_Queries {
    static final int MAX = 1000000;
    static int[] g = new int[MAX + 1];
    static int[][] prefix = new int[10][MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int Q = Integer.parseInt(br.readLine());

        precompute();

        while (Q-- > 0) {
            String[] parts = br.readLine().split(" ");
            int l = Integer.parseInt(parts[0]);
            int r = Integer.parseInt(parts[1]);
            int k = Integer.parseInt(parts[2]);
            out.append(prefix[k][r] - prefix[k][l - 1]).append("\n");
        }

        System.out.print(out);
    }

    static void precompute() {
        for (int i = 1; i <= 9; i++) g[i] = i;
        for (int i = 10; i <= MAX; i++) g[i] = g[f(i)];

        for (int k = 1; k <= 9; k++) {
            for (int i = 1; i <= MAX; i++) {
                prefix[k][i] = prefix[k][i - 1] + (g[i] == k ? 1 : 0);
            }
        }
    }

    static int f(int x) {
        int prod = 1;
        while (x > 0) {
            int d = x % 10;
            if (d != 0) prod *= d;
            x /= 10;
        }
        return prod;
    }
}
