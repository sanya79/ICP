import java.io.*;
import java.util.*;


public class Lunar_New_year_and_a_Recursive_Sequence {
    static final long P = 998244353L;
    static final long PHI = P - 1; 
    static final long G = 3L;      
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int k = fs.nextInt();
        long[] b = new long[k];
        for (int i = 0; i < k; i++) b[i] = fs.nextLong() % PHI;
        long n = fs.nextLong();
        long m = fs.nextLong();

        if (n < k) {
            if (m == 1) {
                System.out.println(1);
            } else {
                System.out.println(-1);
            }
            return;
        }
        if (n == k) {
            System.out.println(m % P);
            return;
        }
        long[][] T = new long[k][k];
        for (int j = 0; j < k; j++) T[0][j] = (b[j] % PHI + PHI) % PHI;
        for (int i = 1; i < k; i++) T[i][i - 1] = 1L;

        long exp = n - k;
        long[][] Tpow = matPow(T, exp, PHI);
        long C = Tpow[0][0] % PHI; 
        long t = bsgs(G, m % P, P);
        if (t == -1) {
            System.out.println(-1);
            return;
        }
        long d = gcd(C, PHI);
        if (t % d != 0) {
            System.out.println(-1);
            return;
        }
        long modReduced = PHI / d;
        long Cred = (C / d) % modReduced;
        long tred = (t / d) % modReduced;
        if (Cred < 0) Cred += modReduced;
        if (tred < 0) tred += modReduced;

        long invCred = modInverse(Cred, modReduced);
        if (invCred == -1) {
            System.out.println(-1);
            return;
        }

        long x0 = (tred * invCred) % modReduced; 
        long exponent = x0 % PHI;
        long fk = modPow(G, exponent, P);
        System.out.println(fk);
    }
    static long[][] matMul(long[][] A, long[][] B, long mod) {
        int n = A.length;
        long[][] C = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                long aik = A[i][k];
                if (aik == 0) continue;
                for (int j = 0; j < n; j++) {
                    long val = (aik * B[k][j]) % mod;
                    C[i][j] += val;
                    if (C[i][j] >= (1L << 62)) C[i][j] %= mod;
                }
            }
            for (int j = 0; j < n; j++) C[i][j] %= mod;
        }
        return C;
    }

    static long[][] matPow(long[][] A, long e, long mod) {
        int n = A.length;
        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) res[i][i] = 1L;
        long[][] base = new long[n][n];
        for (int i = 0; i < n; i++) System.arraycopy(A[i], 0, base[i], 0, n);

        while (e > 0) {
            if ((e & 1L) == 1L) res = matMul(res, base, mod);
            base = matMul(base, base, mod);
            e >>= 1;
        }
        return res;
    }
    static long modPow(long a, long e, long mod) {
        a %= mod;
        long res = 1 % mod;
        while (e > 0) {
            if ((e & 1L) == 1L) res = (res * a) % mod;
            a = (a * a) % mod;
            e >>= 1;
        }
        return res;
    }

    static long gcd(long a, long b) {
        if (a < 0) a = -a;
        if (b < 0) b = -b;
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
    static long[] extGcd(long a, long b) {
        if (b == 0) return new long[]{a, 1, 0};
        long[] r = extGcd(b, a % b);
        long g = r[0], x = r[2], y = r[1] - (a / b) * r[2];
        return new long[]{g, x, y};
    }

    static long modInverse(long a, long mod) {
        a %= mod;
        if (a < 0) a += mod;
        long[] eg = extGcd(a, mod);
        if (eg[0] != 1) return -1;
        long inv = eg[1] % mod;
        if (inv < 0) inv += mod;
        return inv;
    }
    static long bsgs(long a, long b, long mod) {
        a %= mod;
        b %= mod;
        if (b == 1) return 0;
        long m = (long) Math.ceil(Math.sqrt(mod));
        HashMap<Long, Long> baby = new HashMap<>((int) m + 3);

        long aj = 1;
        for (long j = 0; j < m; j++) {
            if (!baby.containsKey(aj)) baby.put(aj, j);
            aj = (aj * a) % mod;
        }

        long am = modPow(a, m, mod);
        long inv_am = modInverse(am, mod); 
        if (inv_am == -1) return -1;

        long cur = b;
        for (long i = 0; i <= m; i++) {
            Long j = baby.get(cur);
            if (j != null) {
                long ans = i * m + j;
                ans %= (mod - 1);
                return ans;
            }
            cur = (cur * inv_am) % mod;
        }
        return -1;
    }
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        FastScanner(InputStream is) { in = is; }
        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= ' ') if (c == -1) return -1;
            int sign = 1;
            if (c == '-') { sign = -1; c = read(); }
            int val = 0;
            while (c > ' ') { val = val * 10 + (c - '0'); c = read(); }
            return val * sign;
        }
        long nextLong() throws IOException {
            int c;
            while ((c = read()) <= ' ') if (c == -1) return -1;
            int sign = 1;
            if (c == '-') { sign = -1; c = read(); }
            long val = 0;
            while (c > ' ') { val = val * 10 + (c - '0'); c = read(); }
            return val * sign;
        }
    }
}
