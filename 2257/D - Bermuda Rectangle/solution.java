import java.io.*;
import java.util.*;
 
public class Main {
 
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
 
        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
 
        long nextLong() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ');
 
            long res = 0;
            while (c > ' ') {
                res = res * 10 + (c - '0');
                c = read();
            }
            return res;
        }
 
        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }
 
    // Last index with a[index] <= x
    static int upperBound(long[] a, int n, long x) {
        int lo = 0, hi = n;
 
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
 
            if (a[mid] <= x)
                lo = mid + 1;
            else
                hi = mid;
        }
 
        return lo - 1;
    }
 
    // First index with a[index] <= x
    // Array is sorted in decreasing order.
    static int firstLEDescending(long[] a, int n, long x) {
        int lo = 0, hi = n;
 
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
 
            if (a[mid] > x)
                lo = mid + 1;
            else
                hi = mid;
        }
 
        return lo;
    }
 
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();
 
        int T = fs.nextInt();
 
        while (T-- > 0) {
 
            long S = fs.nextLong();
            int q = fs.nextInt();
 
            // All divisors of S.
            ArrayList<Long> list = new ArrayList<>();
 
            for (long d = 1; d * d <= S; d++) {
                if (S % d == 0) {
                    list.add(d);
 
                    if (d * d != S) {
                        list.add(S / d);
                    }
                }
            }
 
            Collections.sort(list);
 
            int n = list.size();
 
            long[] div = new long[n];
            long[] height = new long[n];
 
            for (int i = 0; i < n; i++) {
                div[i] = list.get(i);
                height[i] = S / div[i];
            }
 
            /*
             * prefArea[i]:
             * Area of the staircase from x = 0
             * through the rectangle whose width ends at div[i].
             */
            long[] prefArea = new long[n];
 
            /*
             * prefWidth[i]:
             * Total width covered by the first i+1 staircase segments.
             *
             * This is effectively div[i].
             */
            long[] prefWidth = new long[n];
 
            prefArea[0] = div[0] * height[0];
            prefWidth[0] = div[0];
 
            for (int i = 1; i < n; i++) {
                long width = div[i] - div[i - 1];
 
                prefArea[i] =
                        prefArea[i - 1] + width * height[i];
 
                prefWidth[i] =
                        prefWidth[i - 1] + width;
            }
 
            while (q-- > 0) {
 
                long x = fs.nextLong();
                long y = fs.nextLong();
 
                /*
                 * idx = largest divisor <= x.
                 */
                int idx = upperBound(div, n, x);
 
                /*
                 * idy = first staircase height <= y.
                 *
                 * Heights are decreasing.
                 */
                int idy = firstLEDescending(height, n, y);
 
                /*
                 * Only segments up to idx can contribute.
                 */
                idy = Math.min(idy, idx + 1);
 
                long ans = 0;
 
                /*
                 * Part 1:
                 * Segments whose height <= y.
                 */
                if (idx >= idy) {
                    ans += prefArea[idx];
 
                    if (idy > 0) {
                        ans -= prefArea[idy - 1];
                    }
                }
 
                /*
                 * Part 2:
                 * Segments whose height > y.
                 * Their height is clipped to y.
                 */
                if (idy > 0) {
                    ans += y * prefWidth[idy - 1];
                }
 
                /*
                 * Part 3:
                 * x may lie between two consecutive divisors.
                 */
                if (idx + 1 < n) {
                    long remainingWidth = x - div[idx];
 
                    long nextHeight = height[idx + 1];
 
                    ans += remainingWidth * Math.min(y, nextHeight);
                }
 
                out.append(ans).append('
');
            }
        }
 
        System.out.print(out);
    }
}